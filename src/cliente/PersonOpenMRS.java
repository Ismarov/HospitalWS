package cliente;

import java.sql.Timestamp;
import java.util.Date;
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
	SimpleObject names = new SimpleObject();
	SimpleObject person = new SimpleObject();

	/*
	 * names.add("givenName", "lucho"); names.add("familyName","Smith");
	 * person.add("gender", "M").add("names", new SimpleObject[]{names});
	 */

	public Map<String, Object> ingresarPersonaOMRS(PersonaVo pe) {

		names.add("givenName", pe.getNombres()).add("familyName",
				pe.getApellidos());
		person.add("gender", "M").add("names", new SimpleObject[] { names });
		rc.post("person", person);
		return rc.post("person", person);
		

	}
}