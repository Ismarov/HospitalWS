package bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

//import org.hibernate.criterion.Order;
//import org.hibernate.criterion.Projections;
import org.orm.PersistentException;
//import org.orm.util.ORMAdapter;

import orm.BoxCriteria;
import orm.Hora_medicaCriteria;
import orm.MedicoCriteria;
//import orm.PacienteCriteria;
import orm.ReservaCriteria;
import reportes.ReporteFactory.REPORTE_TIPO;
import vo.BoxVo;
import vo.EspecialidadVo;
import vo.HoraMedicaVo;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.PersonaVo;
//import vo.ReservaVo;
//import cliente.PersonOpenMRS;

import com.google.gson.Gson;

//import com.google.gson.GsonBuilder;

/**
 * 
 * Clase Director Es nuestra clase Director de la capa de negocios. Contiene
 * todos los atributos de nuestro DirectorVo, y añade las funcionalidades de
 * persistencia de la capa ORM.
 *
 */
public class Director {

	public String ingresarPaciente(String nombres, String apellidos,
			String rut, Date f_nac, String telefono, String direccion,
			String ciudad, String email, int activo) {

		// Instancia un nuevo objeto Gson para el parseo Objeto/JSON y
		// JSON/Objeto
		Gson g = new Gson();
		try {
			// Intenta setear todos los atributos heredados del orm Persona
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
			// Si la persona se logra persistir, se asigna como Director
			if (orm.PersonaDAO.save(per)) {
				orm.PersonaDAO.refresh(per);
				orm.Paciente pac = new orm.Paciente();
				pac.setPersona(per);

				if (orm.PacienteDAO.save(pac)) {
					orm.PacienteDAO.refresh(pac);
					PacienteVo pvo = PacienteVo.fromORM(pac);
					return g.toJson(pvo);
				}
			}
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método ingersarMedico: Ingresa un nuevo Médico a nuestro sistema
	 * utilizando los datos de su persona Mas los atributos propios de Médico
	 * (idEspecialidad) para luego persistirlos en nuestra base de datos local y
	 * en OpenMRS.
	 * 
	 * @param nombres
	 * @param apellidos
	 * @param rut
	 * @param f_nac
	 * @param telefono
	 * @param direccion
	 * @param ciudad
	 * @param email
	 * @param activo
	 * @param idEspecialidad
	 * @return
	 */
	public String ingresarMedico(String nombres, String apellidos, String rut,
			Date f_nac, String telefono, String direccion, String ciudad,
			String email, int activo, int idEspecialidad) {
		// Instancia un nuevo objeto Gson para el parseo Objeto/JSON y
		// JSON/Objeto

		Gson g = new Gson();
		try {
			// Intenta setear todos los atributos heredados del orm Persona

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
				// Si la persona se logra persistir, se asigna como Médico

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

	/**
	 * obtenerMedico
	 * 
	 * @return JSON con lista de Médicos ingresados
	 */
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

	/**
	 * Método obtenerPacientesMasAtendido
	 * 
	 * @param f1
	 *            fecha 1
	 * @param f2
	 *            fecha 2
	 * @return Lista de Pacientes ordenada segun numero de atenciones.
	 */
	public String obtenerPacientesMasAtendido(Date f1, Date f2) {

		// Reportes.ReporteFactory
		reportes.ReporteFactory rf = reportes.ReporteFactory.getInstance();
		reportes.RepPacMasFrec rp = (reportes.RepPacMasFrec) rf
				.getReporte(REPORTE_TIPO.PAC_MAS_FREC);
		return rp.getReport(f1, f2);
	}

	/**
	 * Método obtenerMedicoMasSolicitado
	 * 
	 * @param f1
	 *            fecha 1
	 * @param f2
	 *            fecha 2
	 * @return Lista de Médicos segun su numero de horas reservadas.
	 */
	public String obtenerMedicoMasSolicitado(Date f1, Date f2) {

		// Reportes.ReporteFactory
		reportes.ReporteFactory rf = reportes.ReporteFactory.getInstance();
		reportes.RepMedMasSol rm = (reportes.RepMedMasSol) rf
				.getReporte(REPORTE_TIPO.MED_MAS_SOL);
		return rm.getReport(f1, f2);
	}

	/**
	 * Método obtenerPorcentajeOcupacionMedico Recibe el Id del medico a
	 * solicitar y el rango de fechas a consultar.
	 * 
	 * @param medicoId
	 * @param f1
	 * @param f2
	 * @return Retorna un entero en % de el numero de ocupacion del medico,
	 *         entre sus horas ingresadas y sus horas reservadas.
	 */
	public int obtenerPorcentajeOcupacionMedico(int medicoId, Date f1, Date f2) {
		//
		try {
			// Genera los criterios Hibernate para consultar las reservas y las
			// fechas segun las horas
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
											// Médico

			if (hmm == 0)
				return 0;

			return (int) (res * 100) / hmm; // Calcular porcentaje de reservas
											// por horas médicas asoc al Médico

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * Método obtenerBox
	 * 
	 * @return Retorna lista de boxes y sus nombres.
	 */
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

	/**
	 * Método obtenerPorcentajeOcupacionBox Obtiene el porcentaje de ocupacion
	 * de un box, respecto de sus horas médicas, sus reservas y el rango de
	 * fechas.
	 * 
	 * @param boxId
	 * @param f1
	 * @param f2
	 * @return Entero en % de su ocupación
	 */
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

	/**
	 * } Método crearHoraMedica Crea una hora médica utilizando los parámetros
	 * necesarios para ello.
	 * 
	 * @param idMedico
	 * @param idBox
	 * @param fecha
	 * @return Retorna los datos de la hora médica creada.
	 */
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
