package cliente;

//import java.sql.Timestamp;
//import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.orm.PersistentException;


//import orm.Paciente;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.PersonaVo;
import cliente.RestClient;
import cliente.SimpleObject;
import business.Director;

/**
 * Constructor para el cliente Rest PersonOpenMRS Usar� las credenciales de
 * nuestra Api REST OpenMRS Posteriormente, hacemos un objeto Director y un
 * objeto PersonaVo.
 **/

public class PersonOpenMRS {
	RestClient rc = new RestClient("admin", "test",
			"http://localhost:8080/openmrs/ws/rest/v1");

	Director dir = new Director();
	PersonaVo p = new PersonaVo();

	/**
	 * M�todo ingresarPersonaORMS, ingresa una Persona a OpenMRS
	 * 
	 * @param p
	 *            La Persona que recibiremos e ingresamos a trav�s de la Api
	 *            REST
	 * @return String uuid generado por OpenMRS al ingresar a la Persona
	 * 
	 */
	private String ingresarPersonaORMS(PersonaVo p) {
		// Genera dos SimpleObject, que servir�n de lista m�s adelante para el
		// JSON de la
		// Api REST
		SimpleObject names = new SimpleObject();
		SimpleObject person = new SimpleObject();
		// Extrae los nombres, apellidos, sexo y los a�ade al SimpleObject
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
	 * M�todo ingresarPacienteORMS, ingresa un Paciente a OpenMRS
	 * 
	 * @param p
	 *            El Paciente que recibiremos e ingresamos a trav�s de la Api
	 *            REST, verificando su UUID de Persona
	 * @return boolean True en caso de ingreso exitoso, de lo contrario, false.
	 * 
	 */
	public boolean ingresarPacienteORMS(PacienteVo p)
			throws PersistentException {
		// Genera dos SimpleObject, que servir�n de lista m�s adelante para el
		// JSON de la
		// Api REST
		SimpleObject patient = new SimpleObject();
		SimpleObject identifiers = new SimpleObject();
		// Extraemos las Id del paciente y la persona correspondiente
		// int pers_id = p.getPersonavo().getId();
		// int pac_id = p.getId();
		// Para setear la Id de la persona al UUID correspondiente a OpenMRS
		String pers_uuid = this.ingresarPersonaORMS(p.getPersonavo());
		String pat_uuid = null;
		// Si la UUID no es nula (no fall� la extracci�n de Id):
		if (pers_uuid != null) {
			// Generamos el JSON para el ingreso del paciente, seteando su Id,
			// Identificador de tipo Paciente, Localizaci�n por defecto, y
			// preferencia
			identifiers
					.add("identifier", String.valueOf(p.getId()))
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
			orm.PacienteCriteria pc = new orm.PacienteCriteria();

			// Busca el paciente con id p.getId()
			pc.personaId.eq(p.getId());

			// Busca un solo registro de Paciente concordante con el criteria de
			// Hibernate (Id)

			Object pacienteResult = pc.uniqueResult();
			// Si el resultado es distinto de null:
			if (pacienteResult != null) {
				orm.Paciente paciente = (orm.Paciente) pacienteResult;
				patOrms.setUuid(pat_uuid);

				// Persistimos este Paciente, ya que ya ha sido ingresado en
				// OpenMRS
				patOrms.setPaciente(paciente);
				orm.Paciente_openmrsDAO.save(patOrms);
			}
		}

		return false;
	}

	/**
	 * M�todo ingresarMedicoORMS, ingresa un M�dico a OpenMRS
	 * 
	 * @param p
	 *            El m�dico que recibiremos e ingresamos a trav�s de la Api REST
	 * @return boolean True en caso de ingreso exitoso, de lo contrario, false.
	 * 
	 */
	public boolean ingresarMedicoORMS(MedicoVo m) throws PersistentException {
		// Genera dos SimpleObject, que servir�n de lista m�s adelante para el
		// JSON de la
		// Api REST
		SimpleObject provider = new SimpleObject();
		SimpleObject identifiers = new SimpleObject();
		// Extraemos las Id del M�dico y la persona correspondiente
		// int pers_id = m.getPersona().getId();
		// int med_id = m.getId();
		// Para setear la Id de la persona al UUID correspondiente a OpenMRS

		String pers_uuid = this.ingresarPersonaORMS(m.getPersona());
		String med_uuid = null;
		// Si la UUID no es nula (no fall� la extracci�n de Id):

		if (pers_uuid != null) {
			// Generamos el JSON para el ingreso del M�dico, seteando su Id,
			// e Identificadores
			identifiers
					.add("identifier", String.valueOf(m.getId()))
					.add("providerattributetype",
							"8d793bee-c2cc-11de-8d13-0010c6dffd0f")
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("retired", false);
			provider.add("person", pers_uuid).add("identifiers",
					new SimpleObject[] { identifiers });
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
		// Si ahora existe la UUID de Persona y M�dico:

		if (pers_uuid != null && med_uuid != null) {
			orm.Proveedor_openmrs medOrms = new orm.Proveedor_openmrs();
			orm.MedicoCriteria mc = new orm.MedicoCriteria();

			// Buscar el M�dico con id p.getId()
			mc.personaId.eq(p.getId());

			// Busca un solo registro de M�dico concordante con el criterio

			Object medicoResult = mc.uniqueResult();
			// Si el resultado es distinto de null:
			if (medicoResult != null) {
				orm.Medico medico = (orm.Medico) medicoResult;
				medOrms.setUuid(med_uuid);

				// Persistimos este M�dico, ya que ya ha sido ingresado en
				// OpenMRS
				medOrms.setMedico(medico);
			}
			orm.Proveedor_openmrsDAO.save(medOrms);
		}

		return false;
	}

}