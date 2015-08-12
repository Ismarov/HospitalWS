package cliente;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.orm.PersistentException;

//import com.google.gson.Gson;

import orm.Paciente;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.PersonaVo;
import cliente.RestClient;
import cliente.SimpleObject;
import bussines.Director;

public class PersonOpenMRS {
	RestClient rc = new RestClient("admin", "Admin1234",
			"http://localhost:8080/openmrs1/ws/rest/v1");

	Director dir = new Director();
	PersonaVo p = new PersonaVo();

	/*
	 * names.add("givenName", "lucho"); names.add("familyName","Smith");
	 * person.add("gender", "M").add("names", new SimpleObject[]{names});
	 */

	public boolean ingresarPacienteORMS(PacienteVo p)
			throws PersistentException {
		// falta sacar el id de nuestra bd
		SimpleObject patient = new SimpleObject();
		SimpleObject identifiers = new SimpleObject();

		int pers_id = p.getPersonavo().getId();
		int pac_id = p.getId();

		String pers_uuid = this.ingresarPersonaORMS(p.getPersonavo());
		String pat_uuid = null;

		if (pers_uuid != null) {

			identifiers
					.add("identifier", String.valueOf(p.getId()))
					.add("identifierType",
							"8d793bee-c2cc-11de-8d13-0010c6dffd0f")
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("preferred", true);
			patient.add("person", pers_uuid).add("identifiers",
					new SimpleObject[] { identifiers });

			Map<String, Object> result = new HashMap<String, Object>();

			try {
				result = rc.post("patient", patient);
				pat_uuid = result.get("uuid").toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pers_uuid != null && pat_uuid != null) {
			orm.Paciente_openmrs patOrms = new orm.Paciente_openmrs();
			orm.PacienteCriteria pc = new orm.PacienteCriteria();

			// Buscar el paciente con id p.getId()
			pc.personaId.eq(p.getId());

			// Busca un solo registro de paciente concordante con el criterio

			Object pacienteResult = pc.uniqueResult();
			// Si el resultado es distinto de null:
			if (pacienteResult != null) {
				orm.Paciente paciente = (orm.Paciente) pacienteResult;
				patOrms.setUuid(pat_uuid);

				// Pasar ese orm.Paciente en lugar de null
				patOrms.setPaciente(paciente);
			}
			orm.Paciente_openmrsDAO.save(patOrms);
		}

		return false;
	}

	public boolean ingresarMedicoORMS(MedicoVo m) throws PersistentException {
		// falta sacar el id de nuestra bd
		SimpleObject provider = new SimpleObject();
		SimpleObject identifiers = new SimpleObject();

		int pers_id = m.getPersona().getId();
		int med_id = m.getId();

		String pers_uuid = this.ingresarPersonaORMS(m.getPersona());
		String med_uuid = null;

		if (pers_uuid != null) {

			identifiers
					.add("identifier", String.valueOf(m.getId()))
					.add("providerattributetype",
							"8d793bee-c2cc-11de-8d13-0010c6dffd0f")
					.add("location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f")
					.add("retired", false);
			provider.add("person", pers_uuid).add("identifiers",
					new SimpleObject[] { identifiers });

			Map<String, Object> result = new HashMap<String, Object>();

			try {
				result = rc.post("provider", provider);
				med_uuid = result.get("uuid").toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (pers_uuid != null && med_uuid != null) {
			orm.Proveedor_openmrs medOrms = new orm.Proveedor_openmrs();
			orm.MedicoCriteria mc = new orm.MedicoCriteria();

			// Buscar el paciente con id p.getId()
			mc.personaId.eq(p.getId());

			// Busca un solo registro de paciente concordante con el criterio

			Object medicoResult = mc.uniqueResult();
			// Si el resultado es distinto de null:
			if (medicoResult != null) {
				orm.Medico medico = (orm.Medico) medicoResult;
				medOrms.setUuid(med_uuid);

				// Pasar ese orm.Paciente en lugar de null
				medOrms.setMedico(medico);
			}
			orm.Proveedor_openmrsDAO.save(medOrms);
		}

		return false;
	}

	private String ingresarPersonaORMS(PersonaVo p) {
		SimpleObject names = new SimpleObject();
		SimpleObject person = new SimpleObject();

		names.add("givenName", p.getNombres()).add("familyName",
				p.getApellidos());
		person.add("gender", "M").add("names", new SimpleObject[] { names });

		try {
			Map<String, Object> mapa = new HashMap<String, Object>();
			mapa = rc.post("person", person);
			String uuid = mapa.get("uuid").toString();
			return uuid;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}