package reportes;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;

import orm.Hora_medicaCriteria;
import orm.MedicoCriteria;
import orm.ReservaCriteria;
import vo.MedicoVo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class RepMedMasSol extends Reporte {
	/* +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+ */
	final class MedReservas implements Comparable<MedReservas>{
		private int reservas;
		private MedicoVo medico;
		
		public MedReservas(int reservas, MedicoVo medico){
			this.reservas = reservas;
			this.medico = medico;
		}
		
		public MedicoVo getMedico(){ return this.medico; }
		public int getReservas(){ return this.reservas; }
		
		public int compareTo(MedReservas other){
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
			//Traer medicos que han reservado ordenados por id.
			MedicoCriteria mc = new MedicoCriteria();
			Hora_medicaCriteria hmc = mc.createHora_medicaCriteria();
			hmc.f_inicio.between(new Timestamp(t1.getTime()), new Timestamp(t2.getTime()));
			ReservaCriteria rc = hmc.createHora_medica_reservaCriteria();
			rc.hora_medicas.isNotEmpty();
			mc.addOrder(Order.asc("id"));
			//mc.setProjection(Projections.distinct(null));
			
			@SuppressWarnings("unchecked")
			List<orm.Medico> medicos = mc.list();
			List<MedReservas> lMedRes = new ArrayList<MedReservas>();
			
			orm.Hora_medica hm = orm.Hora_medicaDAO.getHora_medicaByORMID(1);
			orm.Reserva re = orm.ReservaDAO.getReservaByORMID(1);
			re.hora_medicas.add(hm);
			orm.ReservaDAO.save(re);
			
			// Cuenta de la cantidad de reservas de cada paciente y las asocia a este.
			int count = 0;
			int current_id = 0;
			
			if( medicos.size() > 0 ){ 										// Si existen medicos con reservas. 
				
				current_id = medicos.get(0).getId(); 							// El id actual es el del primer medico;
				for(int i=0; i<medicos.size(); i++){
					
					if(medicos.get(i).getId() != current_id || i == medicos.size()-1 ){	// Sigo contando a menos que el id cambie.
						if( i == medicos.size()-1 ){							// Si añadimos el ultimo medico debemos incrementar
							count++;											// en 1+ la cuenta.
						}
						MedicoVo med = MedicoVo.fromORM(medicos.get(i-1)); // Creo Un objeto MedReservas para convertirlo a JSON luego.
						int porcentaje = (int) (count * 100)/medicos.size();
						lMedRes.add(new MedReservas(porcentaje, med));
						count = 1;												// Reseteo el contador a  para el id siguiente.
						current_id = medicos.get(i).getId();
					}
					else{
						count++;
					}
				}// fin for
			}
			
			// Ordenar por cantidad de reservas
			Collections.sort(lMedRes);
			Collections.reverse(lMedRes);  // invertir orden de mayor a menor
			
			return g.toJson(lMedRes);
			
		} catch (PersistentException e) {
			e.printStackTrace();
		}		
		return null;

	}
}
