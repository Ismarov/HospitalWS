package bussines;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.orm.PersistentException;

import orm.Hora_medica;
import orm.Hora_medicaCriteria;
import orm.Reserva;
import orm.ReservaCriteria;
import vo.EspecialidadVo;
import vo.HoraMedicaVo;
import vo.MedicoVo;
import vo.ReservaVo;

import com.google.gson.Gson;
public class Paciente {
	
	public String obtenerEspecialidad(){
		Gson g  = new Gson();
		List<EspecialidadVo> lEspecialidad =new ArrayList<EspecialidadVo>();
		
		try {
			orm.Especialidad[] especialidades = orm.EspecialidadDAO.listEspecialidadByQuery(null, null);
			
			for(int i=0;i<especialidades.length;i++){
				lEspecialidad.add(EspecialidadVo.fromORM(especialidades[i]));
			}
			String salida=g.toJson(lEspecialidad); 
			
			return salida;
			
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;	
		}
	}
	
	public String ObtenerMedicosDeUnaEspecialidad(int IdEspecialidad){
		Gson g = new Gson();
		List<MedicoVo> medicovos =new ArrayList<MedicoVo>();
		try{
			orm.Medico[] ormMedicos = orm.MedicoDAO.listMedicoByQuery("especialidad_id='"+String.valueOf(IdEspecialidad)+"'", null);
			
			for(int i=0; i<ormMedicos.length;i++){
				medicovos.add(MedicoVo.fromORM(ormMedicos[i]));
			}
			String salida = g.toJson(medicovos);
			return salida;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String buscarHoraAps(int idMedico, Date f1, Date f2){
		Gson g = new Gson();
		List<HoraMedicaVo> lHoras = new ArrayList<HoraMedicaVo>();
		try {
			Hora_medicaCriteria c = new Hora_medicaCriteria();
			c.f_inicio.between(new Timestamp(f1.getTime()), new Timestamp(f2.getTime()));
			c.medicoId.eq(idMedico);
			c.hora_medica_reserva.isEmpty();
			
			@SuppressWarnings("unchecked")
			List<orm.Hora_medica> horas = c.list();
			
			for(int i=0; i < horas.size(); i++){
				HoraMedicaVo h = HoraMedicaVo.fromORM(horas.get(i));
				lHoras.add(h);
			}
			return g.toJson(lHoras);
			
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String ReservarHoraAps (int idHoraMedicaAps, int idPaciente) {
		
		Gson g = new Gson();		
		try {

			orm.Hora_medica hm = orm.Hora_medicaDAO.getHora_medicaByORMID(idHoraMedicaAps);
			orm.Paciente pa = orm.PacienteDAO.getPacienteByORMID(idPaciente);
			orm.Reserva re = null;
			ReservaVo reVo = null;
			
			if(hm != null && pa != null){
				if (hm.hora_medica_reserva.isEmpty()){
					re = new orm.Reserva();
					re.setPaciente(pa);
					re.setPersona(pa.getPersona());
					re.hora_medicas.add(hm);
					orm.ReservaDAO.save(re);
					orm.ReservaDAO.refresh(re);
					
					reVo = ReservaVo.fromORM(re);
					return g.toJson(reVo);
				}
			}
				
		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
}