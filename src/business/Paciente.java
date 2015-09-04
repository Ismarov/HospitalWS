package business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import orm.Hora_medicaCriteria;
import orm.ReservaCriteria;
import vo.EspecialidadVo;
import vo.HoraMedicaVo;
import vo.MedicoVo;
import vo.ReservaVo;



/**
 * 
 * Clase Paciente Es nuestra clase Paciente de la capa de negocios. Contiene
 * todos los atributos de nuestro PacienteVo, y a�ade las funcionalidades de
 * persistencia de la capa ORM.
 *
 */
public class Paciente {

	/**
	 * M�todo obtenerEspecialidad
	 * 
	 * @return Retorna la lista de especialidades disponibles.
	 */
	public ArrayList<EspecialidadVo> obtenerEspecialidades() {

		ArrayList<EspecialidadVo> lEspecialidad = new ArrayList<EspecialidadVo>();

		try {
			orm.Especialidad[] especialidades = orm.EspecialidadDAO
					.listEspecialidadByQuery(null, null);

			for (int i = 0; i < especialidades.length; i++) {
				lEspecialidad.add(EspecialidadVo.fromORM(especialidades[i]));
			}
			return lEspecialidad;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * M�todo ObtenerMedicosDeUnaEspecialidad
	 * 
	 * @param IdEspecialidad
	 * @return Retorna la lista de medicos de un IdEspecialidad dado.
	 */
	public ArrayList<MedicoVo> ObtenerMedicosDeUnaEspecialidad(int IdEspecialidad) {

		ArrayList<MedicoVo> medicovos = new ArrayList<MedicoVo>();
		try {
			orm.Medico[] ormMedicos = orm.MedicoDAO.listMedicoByQuery(
					"especialidad_id='" + String.valueOf(IdEspecialidad) + "'",
					null);

			for (int i = 0; i < ormMedicos.length; i++) {
				medicovos.add(MedicoVo.fromORM(ormMedicos[i]));
			}
			return medicovos;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * M�todo buscarHoraAps Busca las horas APS de un idMedico dado entre un
	 * rango de fechas f1 y f2.
	 * 
	 * @param idMedico
	 * @param f1
	 * @param f2
	 * @return Lista con las horas APS del M�dico en el rango de fechas dado.
	 */
	public ArrayList<HoraMedicaVo> buscarHoraAps(int idMedico, Date f1, Date f2) {

		ArrayList<HoraMedicaVo> lHoras = new ArrayList<HoraMedicaVo>();
		try {
			Hora_medicaCriteria c = new Hora_medicaCriteria();
			c.f_inicio.between(new Timestamp(f1.getTime()),
					new Timestamp(f2.getTime()));
			c.medicoId.eq(idMedico);
			c.reserva.isEmpty();

			@SuppressWarnings("unchecked")
			List<orm.Hora_medica> horas = c.list();

			for (int i = 0; i < horas.size(); i++) {
				HoraMedicaVo h = HoraMedicaVo.fromORM(horas.get(i));
				lHoras.add(h);
			}
			return lHoras;

		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * M�todo reservarHoraAps Reserva una hora APS dando el idHoraMedicaAps
	 * correspondiente y el idPaciente al cual se la asignaremos.
	 * 
	 * @param idHoraMedicaAps
	 * @param idPaciente
	 * @return Retorna un ValueObject de la reserva asiciada a las horas medicas o null en caso de error.
	 */
	public ReservaVo reservarHoraAps(int idHoraMedicaAps, int idPaciente) {

		try {
			orm.Hora_medica hm = orm.Hora_medicaDAO
					.getHora_medicaByORMID(idHoraMedicaAps);
			orm.Paciente pa = orm.PacienteDAO.getPacienteByORMID(idPaciente);
			orm.Reserva re = null;
			ReservaVo reVo = null;

			if (hm != null && pa != null) {
				if (hm.reserva.isEmpty()) {
					re = new orm.Reserva();
					re.setPaciente(pa);
					re.setPersona(pa.getPersona());
					re.hora_medica.add(hm);
					orm.ReservaDAO.save(re);
					orm.ReservaDAO.refresh(re);

					reVo = ReservaVo.fromORM(re);
					return reVo;
				}
			}

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
	
	
	/**
	 * obtenerHorasPaciente Obtiene las horas reservadas del paciente 
	 * @param idPaciente
	 * @return Lista con las horas reservadas para el paciente desde la fecha actual hacia el fururo
	 */
	@SuppressWarnings("deprecation")
	public ArrayList<HoraMedicaVo> obtenerHorasPaciente(int idPaciente) {

		Date f1 = new Date();
		f1.setHours(f1.getHours()-1);
		ArrayList<HoraMedicaVo> lhoras = new ArrayList<HoraMedicaVo>();
		try {
			/*ReservaCriteria rc = new ReservaCriteria();
			rc.pacienteId.eq(idPaciente);
			Hora_medicaCriteria hc = rc.createHora_medicaCriteria();
			hc.f_inicio.gt(new Timestamp(f1.getTime()));
			*/
			Hora_medicaCriteria hc = new Hora_medicaCriteria();
			hc.f_inicio.gt(new Timestamp(f1.getTime()));
			ReservaCriteria rc = new ReservaCriteria();
			rc.pacienteId.eq(idPaciente);
			
			@SuppressWarnings("unchecked")
			List<orm.Hora_medica> horas = hc.list();
			for (int i = 0; i < horas.size(); i++) {
				HoraMedicaVo hmed = HoraMedicaVo.fromORM(horas.get(i));
				lhoras.add(hmed);
			}// end for
			return lhoras;
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}