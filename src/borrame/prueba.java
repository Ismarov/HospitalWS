package borrame;

import cliente.RestClient;
import cliente.SimpleObject;

import java.util.List;
import java.util.Map;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestClient rc = new RestClient("admin", "test",
				"http://localhost:8080/openmrs/ws/rest/v1");
		// List l = null;
		SimpleObject names = new SimpleObject();
		SimpleObject person = new SimpleObject();
		names.add("givenName", "lucho").add("familyName", "Smith");
		person.add("gender", "M").add("names", new SimpleObject[] { names });

		// Map<String, Object> parsjson;
		try {
			rc.post("person", person);
			// System.out.println(rc.toString());
			// l = rc.listQuery("patient", "q", "john");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if (l != null) {
		// System.out.println(l.toString());
		// }
	}

}
