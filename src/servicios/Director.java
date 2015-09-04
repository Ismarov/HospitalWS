package servicios;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Director {
	private Gson g;
	private business.Director dir;
	
	
	/**
	 *  Director inicializa el objeto Director y el parser JSON para responder a los servicios invocados 
	 */
	public Director(){
		this.g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		this.dir = new business.Director();
	}
	
	
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
	 * @return Objeto JSON representando al paciente ingresado o null en caso de error.
	 */
	public String ingresarPaciente(String nombres, String apellidos,
			String rut, Date f_nac, String telefono, String direccion,
			String ciudad, String email, int activo) {
		return g.toJson(dir.ingresarPaciente(nombres, apellidos, rut, f_nac, telefono, direccion, ciudad, email, activo));
	}
	
	
	/**
	 * ingersarMedico: Ingresa un nuevo Medico a nuestro sistema
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
	 * @return Objeto JSON representando al medico ingresado o null en caso de error.
	 */
	public String ingresarMedico(String nombres, String apellidos, String rut,
			Date f_nac, String telefono, String direccion, String ciudad,
			String email, int activo, int idEspecialidad) {
		return g.toJson(dir.ingresarMedico(nombres, apellidos, rut, f_nac, telefono, direccion, ciudad, email, activo, idEspecialidad));
	}
	
	/**
	 * obtenerMedicos
	 * 
	 * @return JSON con lista de Medicos ingresados o null en caso de error.
	 */
	public String obtenerMedicos(){
		return g.toJson(dir.obtenerMedicos());
	}
	
	
	/**
	 * obtenerPacientesMasAtendido obtiene pacientes con mayor porcentaje de atencion.
	 * 
	 * @param f1
	 * @param f2
	 * @return Lista de Pacientes ordenada segun numero de atenciones o null en caso de error.
	 */
	public String obtenerPacientesMasAtendido(Date f1, Date f2) {
		return dir.obtenerPacientesMasAtendido(f1, f2);
	}
	
	
	/**
	 * obtenerMedicoMasSolicitado obtiene los medicos con mayor cantidad de reservas APS asociadas
	 * @param f1
	 * @param f2
	 * @return Lista JSON de Medicos segun su numero de horas reservadas o null en caso de error.
	 */
	public String obtenerMedicoMasSolicitado(Date f1, Date f2) {
		return dir.obtenerMedicoMasSolicitado(f1, f2);
	}
	
	
	/**
	 * obtenerPorcentajeOcupacionMedico obtiene un porcentaje de ocupacion del medico
	 * respecto a sus horas y las reservas existentes.
	 * @param medicoId
	 * @param f1
	 * @param f2
	 * @return Retorna un valor numerico representando el porcentaje numerico de ocupacion del medico,
	 *         entre sus horas ingresadas y sus horas reservadas, o -1 en caso de error.
	 */
	public int obtenerPorcentajeOcupacionMedico(int medicoId, Date f1, Date f2) {
		return dir.obtenerPorcentajeOcupacionMedico(medicoId, f1, f2);
	}
	
		
	/**
	 * obtenerPorcentajeOcupacionBox Obtiene el porcentaje de ocupacion
	 * de un box, respecto de sus horas medicas, sus reservas y el rango de fechas.
	 * 
	 * @param boxId
	 * @param f1
	 * @param f2
	 * @return Entero representando el porcentaje de ocupacion del box, o -1 en caso de error.
	 */
	public int obtenerPorcentajeOcupacionBox(int boxId, Date f1, Date f2) {
		return dir.obtenerPorcentajeOcupacionBox(boxId, f1, f2);
	}
	
	
	/**
	 * obtenerBoxes Obtiene la lista de boxes y sus nombres.
	 * @return string JSON representando una lista de objetos Box
	 */
	public String obtenerBoxes() {
		return g.toJson(dir.obtenerBoxes());
	}
	
	
	/**
	 * crearHoraMedica Crea una hora medica.
	 * 
	 * @param idMedico
	 * @param idBox
	 * @param fecha
	 * @return Retorna un string JSON representando el objeto de hora medica creado o null en caso de error.
	 */
	public String crearHoraMedica(int idMedico, int idBox, Date fecha) {
		return g.toJson(dir.crearHoraMedica(idMedico, idBox, fecha));
	}
	
	
}
