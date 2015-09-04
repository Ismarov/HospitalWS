package servicios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class Medico {
	private Gson g;
	private business.Medico med;
	
	
	/**
	 *  Medico inicializa el objeto Medico y el parser JSON para responder a los servicios invocados 
	 */
	public Medico(){
		this.g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		this.med = new business.Medico();
	}
	
	
	/**
	 * buscarSuDisponibilidadHora Busca las horas medicas disponibles de un medico dado entre un rango de fechas.
	 * @param idMedico
	 * @param f1
	 * @param f2
	 * @return Lista JSON de horas medicas disponibles del Medico o null en caso de error.
	 */
	public String buscarSuDisponibilidadHora(int idMedico, Date f1, Date f2) {
		return g.toJson(med.buscarSuDisponibilidadHora(idMedico, f1, f2));
	}
	
	
	/**
	 * reservarHoraMedicaControl Recibe un arreglo de enteros
	 * correspondientes a horas de control y el id del paciente para
	 * posteriormente reservarlas.
	 * 
	 * @param idHoraControl
	 * @param idPaciente
	 * @return Objeto JSON representando la reserva con sus horas asociadas o null en caso de error.
	 */
	public String reservarHoraMedicaControl(int idHoraControl[], int idPaciente) {
		return g.toJson(med.reservarHoraMedicaControl(idHoraControl, idPaciente)); 
	}
}
