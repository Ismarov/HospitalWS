package servicios;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Paciente {

	private Gson g;
	private business.Paciente pac;
	
	
	/**
	 *  Paciente inicializa el objeto Paciente y el parser JSON para responder a los servicios invocados 
	 */
	public Paciente() {
		this.g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		this.pac = new business.Paciente();
	}
	
	/**
	 * obtenerEspecialidades() Entrega una lista con las especialidades presentes en el sistema.
	 * @return string JSON representando una lista de especialidades o null.
	 */
	public String obtenerEspecialidades() {
		return g.toJson(pac.obtenerEspecialidades());
	}
	
	/**
	 * ObtenerMedicosDeUnaEspecialidad obtiene los medicos de una especialidad determinada.
	 * @param IdEspecialidad
	 * @return string JSON representando la lista de medicos de un IdEspecialidad dado o null en caso de error.
	 */
	public String ObtenerMedicosDeUnaEspecialidad(int IdEspecialidad) {
		return g.toJson(pac.ObtenerMedicosDeUnaEspecialidad(IdEspecialidad));
	}
	
	
	 /**
	 * buscarHoraAps Busca las horas APS de un Medico dado entre un rango de fechas f1 y f2.
	 * @param idMedico
	 * @param f1
	 * @param f2
	 * @return Lista JSON con las horas APS del Medico en el rango de fechas dado o null en caso de error.
	 */
	public String buscarHoraAps(int idMedico, Date f1, Date f2) {
		return g.toJson(pac.buscarHoraAps(idMedico, f1, f2));
	}
	
	
	/**
	 * reservarHoraAps Reserva una hora APS dando el idHoraMedica APS
	 * correspondiente y el idPaciente al cual se la asignaremos.
	 * 
	 * @param idHoraMedicaAps
	 * @param idPaciente
	 * @return Retorna un objeto JSON de la reserva asociada a las horas medicas o null en caso de error.
	 */
	public String reservarHoraAps(int idHoraMedicaAps, int idPaciente) {
		return g.toJson(pac.reservarHoraAps(idHoraMedicaAps, idPaciente));
	}
	
	/**
	 * obtenerHorasPaciente Obtiene las horas reservadas del paciente 
	 * @param idPaciente
	 * @return string JSON representando la lista de horas reservadas para el paciente
	 *  desde la fecha actual hacia el fururo, o null en caso de error.
	 */
	public String obtenerHorasPaciente(int idPaciente) {
		return g.toJson(pac.obtenerHorasPaciente(idPaciente));
	}
	
}
