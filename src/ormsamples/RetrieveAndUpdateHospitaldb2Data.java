/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateHospitaldb2Data {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = orm.Hospitaldb2PersistentManager.instance().getSession().beginTransaction();
		try {
			orm.Persona lormPersona = orm.PersonaDAO.loadPersonaByQuery(null, null);
			// Update the properties of the persistent object
			orm.PersonaDAO.save(lormPersona);
			orm.Paciente lormPaciente = orm.PacienteDAO.loadPacienteByQuery(null, null);
			// Update the properties of the persistent object
			orm.PacienteDAO.save(lormPaciente);
			orm.Director lormDirector = orm.DirectorDAO.loadDirectorByQuery(null, null);
			// Update the properties of the persistent object
			orm.DirectorDAO.save(lormDirector);
			orm.Medico lormMedico = orm.MedicoDAO.loadMedicoByQuery(null, null);
			// Update the properties of the persistent object
			orm.MedicoDAO.save(lormMedico);
			orm.Especialidad lormEspecialidad = orm.EspecialidadDAO.loadEspecialidadByQuery(null, null);
			// Update the properties of the persistent object
			orm.EspecialidadDAO.save(lormEspecialidad);
			orm.Reserva lormReserva = orm.ReservaDAO.loadReservaByQuery(null, null);
			// Update the properties of the persistent object
			orm.ReservaDAO.save(lormReserva);
			orm.Hora_medica lormHora_medica = orm.Hora_medicaDAO.loadHora_medicaByQuery(null, null);
			// Update the properties of the persistent object
			orm.Hora_medicaDAO.save(lormHora_medica);
			orm.Box lormBox = orm.BoxDAO.loadBoxByQuery(null, null);
			// Update the properties of the persistent object
			orm.BoxDAO.save(lormBox);
			orm.Paciente_openmrs lormPaciente_openmrs = orm.Paciente_openmrsDAO.loadPaciente_openmrsByQuery(null, null);
			// Update the properties of the persistent object
			orm.Paciente_openmrsDAO.save(lormPaciente_openmrs);
			orm.Hora_medica_aps_encuentro_openmrs lormHora_medica_aps_encuentro_openmrs = orm.Hora_medica_aps_encuentro_openmrsDAO.loadHora_medica_aps_encuentro_openmrsByQuery(null, null);
			// Update the properties of the persistent object
			orm.Hora_medica_aps_encuentro_openmrsDAO.save(lormHora_medica_aps_encuentro_openmrs);
			orm.Hora_medica_visita_openmrs lormHora_medica_visita_openmrs = orm.Hora_medica_visita_openmrsDAO.loadHora_medica_visita_openmrsByQuery(null, null);
			// Update the properties of the persistent object
			orm.Hora_medica_visita_openmrsDAO.save(lormHora_medica_visita_openmrs);
			orm.Proveedor_openmrs lormProveedor_openmrs = orm.Proveedor_openmrsDAO.loadProveedor_openmrsByQuery(null, null);
			// Update the properties of the persistent object
			orm.Proveedor_openmrsDAO.save(lormProveedor_openmrs);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Persona by PersonaCriteria");
		orm.PersonaCriteria lormPersonaCriteria = new orm.PersonaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormPersonaCriteria.id.eq();
		System.out.println(lormPersonaCriteria.uniquePersona());
		
		System.out.println("Retrieving Paciente by PacienteCriteria");
		orm.PacienteCriteria lormPacienteCriteria = new orm.PacienteCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormPacienteCriteria.id.eq();
		System.out.println(lormPacienteCriteria.uniquePaciente());
		
		System.out.println("Retrieving Director by DirectorCriteria");
		orm.DirectorCriteria lormDirectorCriteria = new orm.DirectorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormDirectorCriteria.id.eq();
		System.out.println(lormDirectorCriteria.uniqueDirector());
		
		System.out.println("Retrieving Medico by MedicoCriteria");
		orm.MedicoCriteria lormMedicoCriteria = new orm.MedicoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormMedicoCriteria.id.eq();
		System.out.println(lormMedicoCriteria.uniqueMedico());
		
		System.out.println("Retrieving Especialidad by EspecialidadCriteria");
		orm.EspecialidadCriteria lormEspecialidadCriteria = new orm.EspecialidadCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormEspecialidadCriteria.id.eq();
		System.out.println(lormEspecialidadCriteria.uniqueEspecialidad());
		
		System.out.println("Retrieving Reserva by ReservaCriteria");
		orm.ReservaCriteria lormReservaCriteria = new orm.ReservaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormReservaCriteria.id.eq();
		System.out.println(lormReservaCriteria.uniqueReserva());
		
		System.out.println("Retrieving Hora_medica by Hora_medicaCriteria");
		orm.Hora_medicaCriteria lormHora_medicaCriteria = new orm.Hora_medicaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormHora_medicaCriteria.id.eq();
		System.out.println(lormHora_medicaCriteria.uniqueHora_medica());
		
		System.out.println("Retrieving Box by BoxCriteria");
		orm.BoxCriteria lormBoxCriteria = new orm.BoxCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormBoxCriteria.id.eq();
		System.out.println(lormBoxCriteria.uniqueBox());
		
		System.out.println("Retrieving Paciente_openmrs by Paciente_openmrsCriteria");
		orm.Paciente_openmrsCriteria lormPaciente_openmrsCriteria = new orm.Paciente_openmrsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormPaciente_openmrsCriteria.id.eq();
		System.out.println(lormPaciente_openmrsCriteria.uniquePaciente_openmrs());
		
		System.out.println("Retrieving Hora_medica_aps_encuentro_openmrs by Hora_medica_aps_encuentro_openmrsCriteria");
		orm.Hora_medica_aps_encuentro_openmrsCriteria lormHora_medica_aps_encuentro_openmrsCriteria = new orm.Hora_medica_aps_encuentro_openmrsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormHora_medica_aps_encuentro_openmrsCriteria.id.eq();
		System.out.println(lormHora_medica_aps_encuentro_openmrsCriteria.uniqueHora_medica_aps_encuentro_openmrs());
		
		System.out.println("Retrieving Hora_medica_visita_openmrs by Hora_medica_visita_openmrsCriteria");
		orm.Hora_medica_visita_openmrsCriteria lormHora_medica_visita_openmrsCriteria = new orm.Hora_medica_visita_openmrsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormHora_medica_visita_openmrsCriteria.id.eq();
		System.out.println(lormHora_medica_visita_openmrsCriteria.uniqueHora_medica_visita_openmrs());
		
		System.out.println("Retrieving Proveedor_openmrs by Proveedor_openmrsCriteria");
		orm.Proveedor_openmrsCriteria lormProveedor_openmrsCriteria = new orm.Proveedor_openmrsCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//lormProveedor_openmrsCriteria.id.eq();
		System.out.println(lormProveedor_openmrsCriteria.uniqueProveedor_openmrs());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateHospitaldb2Data retrieveAndUpdateHospitaldb2Data = new RetrieveAndUpdateHospitaldb2Data();
			try {
				retrieveAndUpdateHospitaldb2Data.retrieveAndUpdateTestData();
				//retrieveAndUpdateHospitaldb2Data.retrieveByCriteria();
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
