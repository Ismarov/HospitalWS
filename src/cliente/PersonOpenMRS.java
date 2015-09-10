package cliente;

//import java.sql.Timestamp;
//import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.orm.PersistentException;

//import orm.Paciente;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.PersonaVo;
import vo.RceVo;
import cliente.RestClient;
import cliente.SimpleObject;

import java.util.Date;

/**
 * Constructor para el cliente Rest PersonOpenMRS Usa las credenciales de
 * nuestra Api REST OpenMRS. Posteriormente, generamos un objeto PersonaVo.
 **/

public class PersonOpenMRS {
	RestClient rc = new RestClient("admin", "test",
			"http://localhost:8080/openmrs/ws/rest/v1");

	PersonaVo p = new PersonaVo();

	/**
	 * Metodo ingresarPersonaORMS, ingresa una Persona a OpenMRS
	 * 
	 * @param p
	 *            La Persona que recibiremos e ingresaremos a traves de la Api
	 *            REST
	 * @return String uuid generado por OpenMRS al ingresar a la Persona
	 * 
	 */
	private String ingresarPersonaOMRS(PersonaVo p) {
		// Genera dos SimpleObject, que serviran de lista mas adelante para el
		// JSON de la Api REST
		SimpleObject names = new SimpleObject();
		SimpleObject person = new SimpleObject();
		// Extrae los nombres, apellidos, sexo y los ingresa al SimpleObject
		names.add("givenName", p.getNombres()).add("familyName",
				p.getApellidos());
		person.add("gender", "M").add("names", new SimpleObject[] { names });

		try {
			// Generamos este Array de String, Object (JSON Anidado)
			Map<String, Object> mapa = new HashMap<String, Object>();
			// Intentamos postearlo con el cliente REST
			mapa = rc.post("person", person);
			String uuid = mapa.get("uuid").toString();
			// Retornamos el UUID
			return uuid;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Metodo ingresarPacienteORMS, ingresa un Paciente a OpenMRS
	 * 
	 * @param p
	 *            El Paciente que recibiremos e ingresamos a traves de la Api
	 *            REST, verificando su UUID de Persona
	 * @return boolean True en caso de ingreso exitoso, de lo contrario, false.
	 * 
	 */
	public boolean ingresarPacienteOMRS(PacienteVo p)
			throws PersistentException {
		// Genera dos SimpleObject, que servir�n de lista mas adelante para el
		// JSON de la Api REST
		SimpleObject patient = new SimpleObject();
		SimpleObject identifiers = new SimpleObject();
		// Extraemos las Id del paciente y la persona correspondiente
		// int pers_id = p.getPersonavo().getId();
		// int pac_id = p.getId();
		// Para setear la Id de la persona al UUID correspondiente a OpenMRS
		String pers_uuid = this.ingresarPersonaOMRS(p.getPersonavo());
		String pat_uuid = null;
		// Si la UUID no es nula (no fallo la extraccion de Id):
		if (pers_uuid != null) {
			// Generamos el JSON para el ingreso del paciente, seteando su Id,
			// Identificador de tipo Paciente, Localizacion por defecto, y
			// preferencia
			Date d = new Date();
			String s = String.valueOf(d.getTime());
			int unique_id = Integer.parseInt(s.substring(s.length() - 9,
					s.length()));

			identifiers
					.add("identifier", String.valueOf(unique_id))
					.add("identifierType",
							"8d793bee-c2cc-11de-8d13-0010c6dffd0f")
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("preferred", true);
			patient.add("person", pers_uuid).add("identifiers",
					new SimpleObject[] { identifiers });
			// Generamos este Array de String, Object (JSON Anidado)
			Map<String, Object> result = new HashMap<String, Object>();
			// Intentamos postearlo con el cliente REST
			try {
				result = rc.post("patient", patient);
				pat_uuid = result.get("uuid").toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Si ahora existe la UUID de Persona y Paciente:
		if (pers_uuid != null && pat_uuid != null) {
			// Verificamos si la Id es concordante con el UUID de la Persona
			orm.Paciente_openmrs patOrms = new orm.Paciente_openmrs();

			// Busca un solo registro de Paciente concordante desde Hibernate

			orm.Paciente pacienteResult = orm.PacienteDAO.loadPacienteByORMID(p
					.getId());
			// Si el resultado es distinto de null:
			if (pacienteResult != null) {
				orm.Paciente paciente = (orm.Paciente) pacienteResult;
				patOrms.setUuid(pat_uuid);

				// Persistimos este Paciente, ya que ya ha sido ingresado en
				// OpenMRS
				patOrms.setPaciente(paciente);
				return orm.Paciente_openmrsDAO.save(patOrms);
			}
		}

		return false;
	}

	/**
	 * Metodo ingresarMedicoORMS, ingresa un Medico a OpenMRS
	 * 
	 * @param m
	 *            El medico que recibiremos e ingresamos a traves de la Api REST
	 * @return boolean True en caso de ingreso exitoso, de lo contrario, false.
	 * 
	 */
	public boolean ingresarMedicoOMRS(MedicoVo m) throws PersistentException {
		// Genera dos SimpleObject, que serviran de lista mas adelante para el
		// JSON de la Api REST
		SimpleObject provider = new SimpleObject();
		// Extraemos las Id del Medico y la persona correspondiente
		// int pers_id = m.getPersona().getId();
		// int med_id = m.getId();
		// Para setear la Id de la persona al UUID correspondiente a OpenMRS

		String pers_uuid = this.ingresarPersonaOMRS(m.getPersona());
		String med_uuid = null;
		// Si la UUID no es nula (no fallo la extraccion de Id):

		if (pers_uuid != null) {
			// Generamos el JSON para el ingreso del Medico, seteando su Id,
			// e Identificadores
			Date d = new Date();
			String s = String.valueOf(d.getTime());
			int unique_id = Integer.parseInt(s.substring(s.length() - 9,
					s.length()));

			provider.add("person", pers_uuid).add("identifier",
					String.valueOf(unique_id));
			// Generamos este Array de String, Object (JSON Anidado)

			Map<String, Object> result = new HashMap<String, Object>();

			// Intentamos postearlo con el cliente REST

			try {
				result = rc.post("provider", provider);
				med_uuid = result.get("uuid").toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Si ahora existe la UUID de Persona y Medico:

		if (pers_uuid != null && med_uuid != null) {
			orm.Proveedor_openmrs medOrms = new orm.Proveedor_openmrs();

			// Busca un solo registro de Medico concordante desde Hibernate

			orm.Medico medico = orm.MedicoDAO.loadMedicoByORMID(m.getId());
			// Si el resultado es distinto de null:
			if (medico != null) {
				medOrms.setUuid(med_uuid);

				// Persistimos este Medico, ya que ya ha sido ingresado en
				// OpenMRS
				medOrms.setMedico(medico);
			}
			return orm.Proveedor_openmrsDAO.save(medOrms);
		}

		return false;
	}

	/**
	 * Metodo ingresarEncuentroORMS, ingresa un Encuentro a OpenMRS
	 * 
	 * @param rce
	 *            El RCE que ingresamos a traves de la Api REST
	 * @return boolean True en caso de ingreso exitoso, de lo contrario, false.
	 * 
	 */

	public boolean ingresarEncuentroOMRS(RceVo rce) throws PersistentException {

		SimpleObject encounter = new SimpleObject();
		SimpleObject obs = new SimpleObject();
		SimpleObject visit = new SimpleObject();

		String obs_uuid = null;
		String visit_uuid = null;
		String enc_uuid = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		String encounterdateini = sdf.format(rce.getHoramedica().getFinicio());
		String encounterdatefin = sdf.format(rce.getHoramedica().getFfin());
		// formato = "2015-07-31T00:00:00.000-0300";
		orm.Paciente_openmrs pac_omrs = orm.Paciente_openmrsDAO
				.loadPaciente_openmrsByQuery("pacienteid="
						+ rce.getPaciente().getId(), null);
		orm.Proveedor_openmrs med_omrs = orm.Proveedor_openmrsDAO
				.loadProveedor_openmrsByQuery("medicoid="
						+ rce.getHoramedica().getMedicoVo().getId(), null);

		if (pac_omrs != null && med_omrs != null) {

			obs.add("person", pac_omrs.getUuid())
					.add("obsDatetime", encounterdateini)
					.add("comment", rce.getAnamnesis())
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("concept", "8ce4186d-d4ed-488d-94a2-3e3e85d6c4e4");

			visit.add("patient", pac_omrs.getUuid())
					.add("visitType", "73bbb069-9781-4afc-a9d1-54b6b2270e01")
					.add("startDatetime", encounterdateini)
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("stopDatetime", encounterdatefin);

		}

		Map<String, Object> resultObs = new HashMap<String, Object>();
		Map<String, Object> resultVisit = new HashMap<String, Object>();
		Map<String, Object> resultEncounter = new HashMap<String, Object>();

		try {
			resultObs = rc.post("obs", obs);
			resultVisit = rc.post("visit", visit);

			obs_uuid = resultObs.get("uuid").toString();
			visit_uuid = resultVisit.get("uuid").toString();
			encounter
					.add("encounterDatetime", encounterdateini)
					.add("patient", pac_omrs.getUuid())
					.add("encounterType",
							"8d5b27bc-c2cc-11de-8d13-0010c6dffd0f")
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("provider", med_omrs.getUuid()).add("visit", visit_uuid)
					.add("concept", "409b5360-66c6-4c08-9438-1a61763f7341")
					.add("obs", new String[] { obs_uuid });
			
			resultEncounter = rc.post("encounter", encounter);
			enc_uuid = resultEncounter.get("uuid").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (enc_uuid != null) {

			orm.Hora_medica_visita_openmrs encOmrs = new orm.Hora_medica_visita_openmrs();

			orm.Hora_medica horamedica = orm.Hora_medicaDAO
					.loadHora_medicaByORMID(rce.getHoramedica().getId());
			if (horamedica != null) {

				encOmrs.setUuid(enc_uuid);
				encOmrs.setHora_medica(horamedica);
			}
			return orm.Hora_medica_visita_openmrsDAO.save(encOmrs);
		}

		return false;
	}

}