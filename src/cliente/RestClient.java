/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package cliente;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.LoggingFilter;

/**
 * Helper class for making REST calls
 */
public class RestClient {

	private String serverUrl;
	private String username;
	private String password;
	private Client client;

	public RestClient(String usr, String pass, String url) {
		this.username = usr;
		this.password = pass;
		this.serverUrl = url;
		client = Client.create();
		client.addFilter(new LoggingFilter(System.out));
		Authenticator.setDefault(new MyAuthenticator(this.username,
				this.password));
	}

	class MyAuthenticator extends Authenticator {
		/**
		 * @see java.net.Authenticator#getPasswordAuthentication()
		 */
		private String username;
		private String password;

		public MyAuthenticator(String usr, String pass) {
			this.username = usr;
			this.password = pass;
		}

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.username,
					this.password.toCharArray());
		}
	}

	private WebResource getRootResource() {
		return client.resource(this.serverUrl);
	}

	private WebResource getPatientResource() {
		return getRootResource().path("patient");
	}

	public boolean login() throws Exception {
		/*
		 * String resultString =
		 * getRootResource().path("session").accept(MediaType
		 * .APPLICATION_JSON_TYPE).get(String.class); Map<String, Object> result
		 * = handleJsonObject(resultString); if
		 * (result.get("authenticated").equals("true")) { // sessionid =
		 * result.get("session"); return true; }
		 * 
		 * return false;
		 */
		return true;
	}

	/*
	 * handleResultList Query de lista de argumentos, recibe el recurso
	 * (patient, person, encounter, visit), argumento (?q), y la consulta (john)
	 * y devuelve una lista de handeResultList
	 */
	public List<Map<String, Object>> listQuery(String resourceName,
			String queryParamName, String query) throws Exception {
		String result = getRootResource().path(resourceName)
				.queryParam(queryParamName, query)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		return handleResultList(result);
	}

	/*
	 * getResource Recibe un nombre de recurso (patient, person, encounter,
	 * visit), y un uuid, y devuelve un resultado de HandleJsonObject
	 */
	public Map<String, Object> getResource(String resourceName, String uuid)
			throws Exception {
		String result = getRootResource().path(resourceName).path(uuid)
				.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		return handleJsonObject(result);
	}

	/*
	 * handleJsonObject Recibe un String json y lo devuelve como mapa de
	 * simpleObjects
	 */
	public Map<String, Object> handleJsonObject(String json) throws Exception {
		return new ObjectMapper().readValue(json, SimpleObject.class);
	}

	/*
	 * handleResultList Recibe una lista de json y devuelve una lista de objects
	 */
	public List<Map<String, Object>> handleResultList(String json)
			throws Exception {
		Map<String, Object> object = handleJsonObject(json);
		return (List<Map<String, Object>>) object.get("results");
	}

	/*
	 * post Recibe un resource (patient, person, encounter, visit), y un map de
	 * propiedades (clave - valor)
	 */
	public Map<String, Object> post(String resource,
			Map<String, Object> properties) throws Exception {
		String json = "";
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			json = ow.writeValueAsString(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = getRootResource().path(resource)
				.accept("application/json").type("application/json")
				.post(String.class, json);

		return handleJsonObject(result);
	}

}
