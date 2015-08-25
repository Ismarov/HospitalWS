package bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import orm.Hora_medicaCriteria;
import vo.HoraMedicaVo;
//import vo.MedicoVo;
//import vo.PacienteVo;
import vo.ReservaVo;

import com.google.gson.Gson;

/**
 * 
 * Clase Medico
 * Es nuestra clase Medico de la capa de negocios.
 * Contiene todos los atributos de nuestro MedicoVo, 
 * y añade las funcionalidades de persistencia de la capa ORM.
 *
 */
public class Medico {
	
	/**
	 * Método buscarSuDisponibilidadHora
	 * Busca las horas médicas disponibles de un médico dado entre un rango de fechas.
	 * @param idMedico
	 * @param f1
	 * @param f2
	 * @return Lista de horas médicas disponibles del Médico.
	 */
	
	public String buscarSuDisponibilidadHora(int idMedico, Date f1, Date f2) {
		Gson g = new Gson();
		List<HoraMedicaVo> lhoras = new ArrayList<HoraMedicaVo>();
		try {
			Hora_medicaCriteria c = new Hora_medicaCriteria();
			c.f_inicio.between(new Timestamp(f1.getTime()),
					new Timestamp(f2.getTime()));
			c.reserva.isEmpty();
			c.medicoId.eq(idMedico);

			@SuppressWarnings("unchecked")
			List<orm.Hora_medica> horas = c.list();
			for (int i = 0; i < horas.size(); i++) {
				HoraMedicaVo hmed = HoraMedicaVo.fromORM(horas.get(i));
				lhoras.add(hmed);
			}// end for
			return g.toJson(lhoras);
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método ReservarHoraMedicaControl
	 * Recibe un arreglo de enteros correspondientes a horas de control
	 * y el id del paciente para posteriormente reservarlas.
	 * @param idHoraControl
	 * @param idPaciente
	 * @return Lista de horas reservadas.
	 */
	public String ReservarHoraMedicaControl(int idHoraControl[], int idPaciente) {

		Gson g = new Gson();
		List<orm.Hora_medica> horas = new ArrayList<orm.Hora_medica>();
		try {

			orm.Paciente pa = orm.PacienteDAO.getPacienteByORMID(idPaciente);
			orm.Reserva re = null;
			ReservaVo reVo = null;

			for (int i = 0; i < idHoraControl.length; i++) {

				orm.Hora_medica hm = orm.Hora_medicaDAO
						.getHora_medicaByORMID(idHoraControl[i]);
				if (hm == null || hm.reserva.size() != 0)
					return null;
				horas.add(hm);

			}

			if (pa != null) {

				re = new orm.Reserva();
				re.setPaciente(pa);
				re.setPersona(pa.getPersona());
				for (int i = 0; i < horas.size(); i++) {
					re.hora_medica.add(horas.get(i));
				}
				orm.ReservaDAO.save(re);
				orm.ReservaDAO.refresh(re);
				reVo = ReservaVo.fromORM(re);
				return g.toJson(reVo);

			}

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

}