package reportes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.orm.PersistentException;

import orm.Hora_medicaCriteria;
import orm.PacienteCriteria;
import orm.ReservaCriteria;
import vo.PacienteVo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RepPacMasFrec extends Reporte {

	/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
	final class PacReservas implements Comparable<PacReservas>{
		private int reservas;
		private PacienteVo paciente;
		
		public PacReservas(int reservas, PacienteVo paciente){
			this.reservas = reservas;
			this.paciente = paciente;
		}
		
		public PacienteVo getPaciente(){ return this.paciente; }
		public int getReservas(){ return this.reservas; }
		
		public int compareTo(PacReservas other){
			// retornar < 0 si este es menor que other
			// 0 si igual o > 0 i mayor que otro.
			return this.reservas - other.reservas;
		}
		
	}
	/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
	
	@Override
	public String getReport(Date t1, Date t2) {

		//Gson g = new Gson();
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			//Traer pacientes que han reservado ordenados por id.
			PacienteCriteria pc = new PacienteCriteria();
			ReservaCriteria rc = pc.createReservaCriteria();
			Hora_medicaCriteria hmc = rc.createHora_medicasCriteria();
			hmc.f_inicio.between(new Timestamp(t1.getTime()), new Timestamp(t2.getTime()));
			pc.addOrder(Order.asc("id"));
			
			@SuppressWarnings("unchecked")
			List<orm.Paciente> pacientes = pc.list();
			List<PacReservas> lPacRes = new ArrayList<PacReservas>();
			
			
			// Cuenta de la cantidad de reservas de cada paciente y las asocia a este.
			int count = 0;
			int current_id = 0;
			
			if( pacientes.size() > 0 ){ 										// Si existen pacientes que con reservas. 
				
				current_id = pacientes.get(0).getId(); 							// El id actual es el del primer paciente;
				for(int i=0; i<pacientes.size(); i++){
					
					if(pacientes.get(i).getId() != current_id || i == pacientes.size()-1 ){	// Sigo contando a menos que el id cambie.
						if( i == pacientes.size()-1 ){							// Si añadimos el ultimo paciente debemos incrementar
							count++;											// en 1+ la cuenta.
						}
						PacienteVo pa = PacienteVo.fromORM(pacientes.get(i-1)); // Creo Un objeto PacReservas para convertirlo a JSON luego.
						int porcentaje = (int) (count * 100)/pacientes.size();
						lPacRes.add(new PacReservas(porcentaje, pa));
						count = 1;												// Reseteo el contador a  para el id siguiente.
						current_id = pacientes.get(i).getId();
					}
					else{
						count++;
					}
				}// fin for
			}
			
			// Ordenar por cantidad de reservas
			Collections.sort(lPacRes);
			Collections.reverse(lPacRes);  // invertir orden de mayor a menor
			
			return g.toJson(lPacRes);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	  

}
