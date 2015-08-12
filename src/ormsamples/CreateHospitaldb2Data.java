/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateHospitaldb2Data {
	public void createTestData() throws PersistentException {
		// Insert sample data
		PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
		PersistentTransaction transaction = session.beginTransaction();
		try {
			session.doWork(new org.hibernate.jdbc.Work() {
				public void execute(java.sql.Connection conn) throws java.sql.SQLException {
					java.sql.Statement statement = conn.createStatement();
					statement.executeUpdate("INSERT INTO persona(nombres, apellidos, rut, f_nac, telefono, direccion, ciudad, email, activo) VALUES ('gonzalo', 'gonzales', '11.111.111-1', '2000-01-01 00:00:00', '12345678', 'calle 1 asdf', 'san carlos', 'asdf@qwer.cl', 1)");
					statement.executeUpdate("INSERT INTO persona(nombres, apellidos, rut, f_nac, telefono, direccion, ciudad, email, activo) VALUES ('roberto', 'rodriguez', '22.222.222-2', '1980-05-05 00:00:00', '76543234', 'calle 3 2345', 'san carlos', 'qwer@asd.cl', 1)");
					statement.executeUpdate("INSERT INTO persona(nombres, apellidos, rut, f_nac, telefono, direccion, ciudad, email, activo) VALUES ('pedro', 'jara', '33.333.333-3', '1985-04-04 00:00:00', '1236543', 'calle osos 999', 'san carlos', 'poiu@asd.er', 1)");
					statement.executeUpdate("INSERT INTO paciente(persona_id) VALUES (3)");
					statement.executeUpdate("INSERT INTO paciente(persona_id) VALUES (2)");
					statement.executeUpdate("INSERT INTO especialidad(nombre) VALUES ('general')");
					statement.executeUpdate("INSERT INTO medico(persona_id, especialidad_id) VALUES (1, 1)");
					statement.executeUpdate("INSERT INTO reserva(persona_id, pacienteid) VALUES (1, 1)");
					statement.executeUpdate("INSERT INTO reserva(persona_id, pacienteid) VALUES (1, 2)");
					statement.executeUpdate("INSERT INTO reserva(persona_id, pacienteid) VALUES (1, 2)");
					statement.executeUpdate("INSERT INTO box(nombre) VALUES ('primero')");
					statement.executeUpdate("INSERT INTO hora_medica(medico_id, box_id, f_inicio, f_fin) VALUES (1, 1, '2015-01-01 00:00:00', '2015-01-01 00:15:00')");
					statement.executeUpdate("INSERT INTO hora_medica(medico_id, box_id, f_inicio, f_fin) VALUES (1, 1, '2015-01-01 00:15:00', '2015-01-01 00:30:00')");
					statement.executeUpdate("INSERT INTO hora_medica(medico_id, box_id, f_inicio, f_fin) VALUES (1, 1, '2015-01-01 00:30:00', '2015-01-01 00:45:00')");
					statement.executeUpdate("INSERT INTO hora_medica(medico_id, box_id, f_inicio, f_fin) VALUES (1, 1, '2015-01-01 00:45:00', '2015-01-01 01:00:00')");
					statement.close();
				}
			});
			transaction.commit();
		}
		catch (Exception e) {
			try {
				transaction.rollback();
			}
			catch (PersistentException e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		
		PersistentTransaction t = orm.Hospitaldb2PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.createPersona();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : reserva, medico, director, paciente, activo, ciudad, direccion, f_nac, rut, apellidos, nombres
			orm.PersonaDAO.save(lormPersona);
			orm.Paciente lormPaciente = orm.PacienteDAO.createPaciente();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : paciente_openmrs, persona
			orm.PacienteDAO.save(lormPaciente);
			orm.Director lormDirector = orm.DirectorDAO.createDirector();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : persona
			orm.DirectorDAO.save(lormDirector);
			orm.Medico lormMedico = orm.MedicoDAO.createMedico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : proveedor_openmrs, hora_medica, persona
			orm.MedicoDAO.save(lormMedico);
			orm.Especialidad lormEspecialidad = orm.EspecialidadDAO.createEspecialidad();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : nombre
			orm.EspecialidadDAO.save(lormEspecialidad);
			orm.Reserva lormReserva = orm.ReservaDAO.createReserva();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hora_medica, persona
			orm.ReservaDAO.save(lormReserva);
			orm.Hora_medica lormHora_medica = orm.Hora_medicaDAO.createHora_medica();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hora_medica_aps_encuentro_openmrs, hora_medica_visita_openmrs, reserva, f_fin, f_inicio, box, medico
			orm.Hora_medicaDAO.save(lormHora_medica);
			orm.Box lormBox = orm.BoxDAO.createBox();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hora_medica, nombre
			orm.BoxDAO.save(lormBox);
			orm.Paciente_openmrs lormPaciente_openmrs = orm.Paciente_openmrsDAO.createPaciente_openmrs();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : paciente, uuid
			orm.Paciente_openmrsDAO.save(lormPaciente_openmrs);
			orm.Hora_medica_aps_encuentro_openmrs lormHora_medica_aps_encuentro_openmrs = orm.Hora_medica_aps_encuentro_openmrsDAO.createHora_medica_aps_encuentro_openmrs();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hora_medica, uuid
			orm.Hora_medica_aps_encuentro_openmrsDAO.save(lormHora_medica_aps_encuentro_openmrs);
			orm.Hora_medica_visita_openmrs lormHora_medica_visita_openmrs = orm.Hora_medica_visita_openmrsDAO.createHora_medica_visita_openmrs();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : hora_medica, uuid
			orm.Hora_medica_visita_openmrsDAO.save(lormHora_medica_visita_openmrs);
			orm.Proveedor_openmrs lormProveedor_openmrs = orm.Proveedor_openmrsDAO.createProveedor_openmrs();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : medico, uuid
			orm.Proveedor_openmrsDAO.save(lormProveedor_openmrs);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateHospitaldb2Data createHospitaldb2Data = new CreateHospitaldb2Data();
			try {
				createHospitaldb2Data.createTestData();
			}
			finally {
				orm.Hospitaldb2PersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
