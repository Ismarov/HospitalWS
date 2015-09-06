package servicios;
import java.util.ArrayList;

import org.orm.PersistentException;

import vo.RceVo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Rce {
	
	private Gson g;
	private business.Rce rce;
	
	
	/**
	 *  Rce inicializa el objeto Rce y el parser JSON para responder a los servicios invocados 
	 */
	public Rce(){
		this.g = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
		this.rce = new business.Rce();
	}
	
	
	/**
	 * ingresarRce Inserta un Registro Clinico Electronico en el sistema.
	 * @param id
	 * @param encounter_uuid
	 * @param alergias
	 * @param anamnesis
	 * @param motivo
	 * @param examen_fisico
	 * @param indicador_medico
	 * @param indicador_cierre
	 * @param hipotesis
	 * @param detalle_ges
	 * @param horamedica_id
	 * @param receta_json
	 * @param diagnostico_id
	 * @param lprocedimiento_id
	 * @param lactividad_id
	 * @param paciente_id
	 * @param lCertificados
	 * @return string JSON representando el RCE ingresado, o representando null si ocurre un error. 
	 */
	public String ingresarRce(int id, String encounter_uuid, String alergias, String anamnesis,
			String motivo, String examen_fisico, String indicador_medico,
			String indicador_cierre, String hipotesis, String detalle_ges,
			int horamedica_id, String receta_json,
			int diagnostico_id, int[] lprocedimiento_id,
			int[] lactividad_id, int paciente_id, int[] lCertificados) {
		
		RceVo rcevo = null;
		try{
		rcevo = rce.ingresarRce(id, encounter_uuid, alergias, anamnesis, motivo,
				examen_fisico, indicador_medico, indicador_cierre, hipotesis,
				detalle_ges, horamedica_id, receta_json, diagnostico_id,
				lprocedimiento_id, lactividad_id, paciente_id, lCertificados);
		}
		catch(PersistentException ex){
			ex.printStackTrace();
		}
		
		return g.toJson(rcevo);
	}
	
	/**
	 * obtenerHceDeUnPaciente obtiene el historial de RCEs del paciente.
	 * @param IdPaciente
	 * @return string JSON representando el Historial de RCEs de un Paciente o null si encuentra un error.
	 */
	public String obtenerHceDeUnPaciente(int IdPaciente) {
		ArrayList<RceVo> hce = rce.obtenerHceDeUnPaciente(IdPaciente);
		return g.toJson(hce);
	}
	
	/**
	 * obtenetPacientePorRut Obtiene un paciente segun su RUT 
	 * @param rut
	 * @return string JSON representando al paciente
	 */
	public String obtenerPacientePorRut(String rut) {
		return g.toJson(rce.obtenerPacientePorRut(rut));
	}
	
	/**
	 * obtenerProcedimientos Entrega una lista con los procedimientos existentes.
	 * @return string JSON representando una lista de procedimientos o null.
	 */
	public String obtenerProcedimientos() {
		return g.toJson(rce.obtenerProcedimientos());
	}
	
	/**
	 * obtenerDiagnosticos Entrega una lista con los diagnosticos existentes.
	 * @return string JSON representando una lista de diagnosticos o null.
	 */
	public String obtenerDiagnosticos() {
		return g.toJson(rce.obtenerDiagnosticos());
	}
	
	/**
	 * obtenerCertificados Entrega una lista con los certificados existentes.
	 * @return string JSON representando una lista de certificados o null.
	 */
	public String obtenerCertificados() {
		return g.toJson(rce.obtenerCertificados());
	}
	
	/**
	 * obtenerActividades Entrega una lista con los actividades existentes.
	 * @return string JSON representando una lista de actividades o null.
	 */
	public String obtenerActividades() {
		return g.toJson(rce.obtenerActividades());
	}
	
}
