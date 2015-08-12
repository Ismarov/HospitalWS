package cliente;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.orm.PersistentException;

import com.google.gson.Gson;





import vo.PacienteVo;
import vo.PersonaVo;
import cliente.RestClient;
import cliente.SimpleObject;
import bussines.Director;

public class PersonOpenMRS {
	RestClient rc = new RestClient("admin", "Admin1234",
			"http://localhost:8080/openmrs/ws/rest/v1");

	Director dir = new Director();
	PersonaVo p = new PersonaVo();
	

	/*
	 * names.add("givenName", "lucho"); names.add("familyName","Smith");
	 * person.add("gender", "M").add("names", new SimpleObject[]{names});
	 */

	public Map<String, Object> ingresarPersonaOMRS(PersonaVo pe) {
		SimpleObject names = new SimpleObject();
		SimpleObject person = new SimpleObject();

		names.add("givenName", pe.getNombres()).add("familyName",
				pe.getApellidos());
		person.add("gender", "M").add("names", new SimpleObject[] { names });

		try {
			Map<String, Object> mapa = new HashMap<String, Object>();
			SimpleObject result = new SimpleObject();
			
			mapa = rc.post("person", person);
			String uuid = result.get("uuid").toString();
			
			ingresarPacienteOMRS(uuid);
			return rc.post("person", person);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	public Map<String, Object> ingresarPacienteOMRS(String uuid) {
		//falta sacar el id de nuestra bd
		SimpleObject person = new SimpleObject();
		SimpleObject identifiers = new SimpleObject();
		
		identifiers.add("identifier", "1234").add("identifierType", "8d793bee-c2cc-11de-8d13-0010c6dffd0f").add(
				"location", "8d6c993e-c2cc-11de-8d13-0010c6dffd0f").add("preferred", true);
		
		person.add("person", uuid).add("identifiers", new SimpleObject[] { identifiers });
		try {
			return rc.post("patient", person);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}