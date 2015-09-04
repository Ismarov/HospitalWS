package business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


import org.orm.PersistentException;


import orm.BoxCriteria;
import orm.Hora_medicaCriteria;
import orm.MedicoCriteria;

import orm.ReservaCriteria;
import reportes.ReporteFactory.REPORTE_TIPO;
import vo.BoxVo;
import vo.EspecialidadVo;
import vo.HoraMedicaVo;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.PersonaVo;


public class Director {

	
	/**
	 * ingresarPaciente ingresa un paciente al sistema.
	 * @param nombres
	 * @param apellidos
	 * @param rut
	 * @param f_nac
	 * @param telefono
	 * @param direccion
	 * @param ciudad
	 * @param email
	 * @param activo
	 * @return ValueObject representando al paciente ingresado o null en caso de error.
	 */
	public PacienteVo ingresarPaciente(String nombres, String apellidos,
			String rut, Date f_nac, String telefono, String direccion,
			String ciudad, String email, int activo) {

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
					return pvo;
				}
			}
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * M�todo ingersarMedico: Ingresa un nuevo M�dico a nuestro sistema
	 * utilizando los datos de su persona Mas los atributos propios de M�dico
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
	 * @return ValueObject representando al medico ingresado o null en caso de error.
	 */
	public MedicoVo ingresarMedico(String nombres, String apellidos, String rut,
			Date f_nac, String telefono, String direccion, String ciudad,
			String email, int activo, int idEspecialidad) {

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
				// Si la persona se logra persistir, se asigna como M�dico

				orm.PersonaDAO.refresh(per);
				orm.Medico med = new orm.Medico();
				med.setPersona(per);
				med.setEspecialidad(esp);
				if (orm.MedicoDAO.save(med)) {
					orm.MedicoDAO.refresh(med);
					MedicoVo mvo = MedicoVo.fromORM(med);
					return mvo;
				}
			}
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * obtenerMedicos
	 * 
	 * @return JSON con lista de M�dicos ingresados
	 */
	public ArrayList<MedicoVo> obtenerMedicos() {

		ArrayList<MedicoVo> lMedicos = new ArrayList<MedicoVo>();
		try {
			orm.Medico[] medicos = orm.MedicoDAO.listMedicoByQuery(null, null);
			for (int i = 0; i < medicos.length; i++) {
				PersonaVo p = PersonaVo.fromORM(medicos[i].getPersona());
				EspecialidadVo e = EspecialidadVo.fromORM(medicos[i]
						.getEspecialidad());
				lMedicos.add(new MedicoVo(medicos[i].getId(), p, e));
			}
			return lMedicos;

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * M�todo obtenerPacientesMasAtendido
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
	 * M�todo obtenerMedicoMasSolicitado
	 * 
	 * @param f1
	 *            fecha 1
	 * @param f2
	 *            fecha 2
	 * @return Lista de M�dicos segun su numero de horas reservadas.
	 */
	public String obtenerMedicoMasSolicitado(Date f1, Date f2) {

		// Reportes.ReporteFactory
		reportes.ReporteFactory rf = reportes.ReporteFactory.getInstance();
		reportes.RepMedMasSol rm = (reportes.RepMedMasSol) rf
				.getReporte(REPORTE_TIPO.MED_MAS_SOL);
		return rm.getReport(f1, f2);
	}

	/**
	 * M�todo obtenerPorcentajeOcupacionMedico Recibe el Id del medico a
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
											// M�dico

			if (hmm == 0)
				return 0;

			return (int) (res * 100) / hmm; // Calcular porcentaje de reservas
											// por horas m�dicas asoc al M�dico

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * M�todo obtenerBoxes
	 * 
	 * @return Retorna lista de boxes y sus nombres.
	 */
	public ArrayList<BoxVo> obtenerBoxes() {
		ArrayList<BoxVo> lBoxes = new ArrayList<BoxVo>();
		try {
			orm.Box[] boxes = orm.BoxDAO.listBoxByQuery(null, null);
			for (int i = 0; i < boxes.length; i++) {
				lBoxes.add(new BoxVo(boxes[i].getId(), boxes[i].getNombre()));
			}
			return  lBoxes;

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * M�todo obtenerPorcentajeOcupacionBox Obtiene el porcentaje de ocupacion
	 * de un box, respecto de sus horas m�dicas, sus reservas y el rango de
	 * fechas.
	 * 
	 * @param boxId
	 * @param f1
	 * @param f2
	 * @return Entero en % de su ocupaci�n
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
	 * crearHoraMedica Crea una hora medica
	 * @param idMedico
	 * @param idBox
	 * @param fecha
	 * @return ValueObject con los datos de la hora medica creada o null en caso de error.
	 */
	public HoraMedicaVo crearHoraMedica(int idMedico, int idBox, Date fecha) {

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
					return hvo;
				}

			}

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}
