package bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.orm.PersistentException;
import org.orm.util.ORMAdapter;

import orm.BoxCriteria;
import orm.Hora_medicaCriteria;
import orm.MedicoCriteria;
import orm.PacienteCriteria;
import orm.ReservaCriteria;
import reportes.ReporteFactory.REPORTE_TIPO;
import vo.BoxVo;
import vo.EspecialidadVo;
import vo.HoraMedicaVo;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.PersonaVo;
import vo.ReservaVo;
import cliente.PersonOpenMRS;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Director {

	public String obtenerBox() {
		Gson g = new Gson();
		List<BoxVo> lBoxes = new ArrayList<BoxVo>();
		try {
			orm.Box[] boxes = orm.BoxDAO.listBoxByQuery(null, null);
			for (int i = 0; i < boxes.length; i++) {
				lBoxes.add(new BoxVo(boxes[i].getId(), boxes[i].getNombre()));
			}
			return g.toJson(lBoxes);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String obtenerMedico() {
		Gson g = new Gson();
		List<MedicoVo> lMedicos = new ArrayList<MedicoVo>();
		try {
			orm.Medico[] medicos = orm.MedicoDAO.listMedicoByQuery(null, null);
			for (int i = 0; i < medicos.length; i++) {
				PersonaVo p = PersonaVo.fromORM(medicos[i].getPersona());
				EspecialidadVo e = EspecialidadVo.fromORM(medicos[i]
						.getEspecialidad());
				lMedicos.add(new MedicoVo(medicos[i].getId(), p, e));
			}
			return g.toJson(lMedicos);

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String obtenerPacientesMasAtendido(Date f1, Date f2) {

		// Reportes.ReporteFactory
		reportes.ReporteFactory rf = reportes.ReporteFactory.getInstance();
		reportes.RepPacMasFrec rp = (reportes.RepPacMasFrec) rf
				.getReporte(REPORTE_TIPO.PAC_MAS_FREC);
		return rp.getReport(f1, f2);
	}

	public int obtenerPorcentajeOcupacionBox(int boxId, Date f1, Date f2) {
		//
		try {
			ReservaCriteria c = new ReservaCriteria();
			Hora_medicaCriteria hm = c.createHora_medicaCriteria();
			hm.f_inicio.between(new Timestamp(f1.getTime()),
					new Timestamp(f2.getTime()));
			BoxCriteria b = hm.createBoxCriteria();
			b.id.eq(boxId);

			Hora_medicaCriteria hm2 = new Hora_medicaCriteria();
			hm2.f_inicio.between(new Timestamp(f1.getTime()),
					new Timestamp(f2.getTime()));
			BoxCriteria b2 = hm2.createBoxCriteria();
			b2.id.eq(boxId);

			int res = c.list().size(); // Cantidad de reservas para el box
			int hmb = hm2.list().size(); // Cantidad de horas asignadas al box

			if (hmb == 0)
				return 0;

			return (int) (res * 100) / hmb; // Calcular porcentaje de reservas
											// por horas medicas asoc al box

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public int obtenerPorcentajeOcupacionMedico(int medicoId, Date f1, Date f2) {
		//
		try {
			ReservaCriteria c = new ReservaCriteria();
			Hora_medicaCriteria hm = c.createHora_medicaCriteria();
			hm.f_inicio.between(new Timestamp(f1.getTime()),
					new Timestamp(f2.getTime()));
			MedicoCriteria mc = hm.createMedicoCriteria();
			mc.id.eq(medicoId);

			Hora_medicaCriteria hm2 = new Hora_medicaCriteria();
			hm2.f_inicio.between(new Timestamp(f1.getTime()),
					new Timestamp(f2.getTime()));
			MedicoCriteria mc2 = hm2.createMedicoCriteria();
			mc2.id.eq(medicoId);

			int res = c.list().size(); // Cantidad de reservas para el medico
			int hmm = hm2.list().size(); // Cantidad de horas asignadas al
											// medico

			if (hmm == 0)
				return 0;

			return (int) (res * 100) / hmm; // Calcular porcentaje de reservas
											// por horas medicas asoc al medico

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	public String obtenerMedicoMasSolicitado(Date f1, Date f2) {

		// Reportes.ReporteFactory
		reportes.ReporteFactory rf = reportes.ReporteFactory.getInstance();
		reportes.RepMedMasSol rm = (reportes.RepMedMasSol) rf
				.getReporte(REPORTE_TIPO.MED_MAS_SOL);
		return rm.getReport(f1, f2);
	}

	public String ingresarPaciente(String nombres, String apellidos,
			String rut, Date f_nac, String telefono, String direccion,
			String ciudad, String email, int activo) {

		Gson g = new Gson();
		try {

			orm.Persona per = new orm.Persona();
			per.setNombres(nombres);
			per.setApellidos(apellidos);
			per.setRut(rut);
			per.setF_nac(new Timestamp(f_nac.getTime()));
			per.setTelefono(telefono);
			per.setDireccion(direccion);
			per.setCiudad(ciudad);
			per.setEmail(email);
			per.setActivo((byte) activo);

			
			if (orm.PersonaDAO.save(per)) {
				orm.PersonaDAO.refresh(per);
				orm.Paciente pac = new orm.Paciente();
				pac.setPersona(per);
				
				if (orm.PacienteDAO.save(pac)) {
					orm.PacienteDAO.refresh(pac);
					PacienteVo pvo = PacienteVo.fromORM(pac);
					
					PersonOpenMRS pomrs = new PersonOpenMRS();
					pomrs.ingresarPacienteORMS(pvo);
					
					return g.toJson(pvo);
				}
			}
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String ingresarMedico(String nombres, String apellidos, String rut,
			Date f_nac, String telefono, String direccion, String ciudad,
			String email, int activo, int idEspecialidad) {

		Gson g = new Gson();
		try {

			orm.Persona per = new orm.Persona();
			per.setNombres(nombres);
			per.setApellidos(apellidos);
			per.setRut(rut);
			per.setF_nac(new Timestamp(f_nac.getTime()));
			per.setTelefono(telefono);
			per.setDireccion(direccion);
			per.setCiudad(ciudad);
			per.setEmail(email);
			per.setActivo((byte) activo);

			orm.Especialidad esp = orm.EspecialidadDAO
					.getEspecialidadByORMID(idEspecialidad);

			if (orm.PersonaDAO.save(per) && esp != null) {

				orm.PersonaDAO.refresh(per);
				orm.Medico med = new orm.Medico();
				med.setPersona(per);
				med.setEspecialidad(esp);
				if (orm.MedicoDAO.save(med)) {
					orm.MedicoDAO.refresh(med);
					MedicoVo mvo = MedicoVo.fromORM(med);
					return g.toJson(mvo);
				}
			}
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String crearHoraMedica(int idMedico, int idBox, Date fecha) {

		Gson g = new Gson();
		try {

			orm.Medico med = orm.MedicoDAO.getMedicoByORMID(idMedico);
			orm.Box box = orm.BoxDAO.getBoxByORMID(idBox);
			if (med != null && box != null) {
				orm.Hora_medica hora = new orm.Hora_medica();
				hora.setMedico(med);
				hora.setBox(box);
				hora.setF_inicio(new Timestamp(fecha.getTime()));
				hora.setF_fin(new Timestamp(fecha.getTime()));
				if (orm.Hora_medicaDAO.save(hora)) {
					orm.Hora_medicaDAO.refresh(hora);
					HoraMedicaVo hvo = HoraMedicaVo.fromORM(hora);
					return g.toJson(hvo);
				}

			}

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
