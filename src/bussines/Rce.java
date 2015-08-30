package bussines;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.orm.PersistentException;

import orm.MedicoDAO;
import orm.PacienteDAO;
import orm.Persona;
import vo.*;

import com.google.gson.Gson;

public class Rce {
	
	public String obtenerActividad() {
		Gson g = new Gson();
		List<ActividadVo> lActividad = new ArrayList<ActividadVo>();

		try {
			orm.Actividad[] actividades = orm.ActividadDAO
					.listActividadByQuery(null, null);

			for (int i = 0; i < actividades.length; i++) {
				lActividad.add(ActividadVo.fromORM(actividades[i]));
			}
			String salida = g.toJson(lActividad);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String obtenerCertificado() {
		Gson g = new Gson();
		List<CertificadoVo> lCertificado = new ArrayList<CertificadoVo>();

		try {
			orm.Certificado[] certificados = orm.CertificadoDAO
					.listCertificadoByQuery(null, null);

			for (int i = 0; i < certificados.length; i++) {
				lCertificado.add(CertificadoVo.fromORM(certificados[i]));
			}
			String salida = g.toJson(lCertificado);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		}
	}
	
	public String obtenerCierre_destino() {
		Gson g = new Gson();
		List<Cierre_destinoVo> lCierre_destino = new ArrayList<Cierre_destinoVo>();

		try {
			orm.Cierre_destino[] cierre_destinos = orm.Cierre_destinoDAO
					.listCierre_destinoByQuery(null, null);

			for (int i = 0; i < cierre_destinos.length; i++) {
				lCierre_destino.add(Cierre_destinoVo.fromORM(cierre_destinos[i]));
			}
			String salida = g.toJson(lCierre_destino);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		}
	}
	
	public String obtenerCierre_tipo() {
		Gson g = new Gson();
		List<Cierre_tipoVo> lCierre_tipo = new ArrayList<Cierre_tipoVo>();

		try {
			orm.Cierre_tipo[] cierre_tipos = orm.Cierre_tipoDAO
					.listCierre_tipoByQuery(null, null);

			for (int i = 0; i < cierre_tipos.length; i++) {
				lCierre_tipo.add(Cierre_tipoVo.fromORM(cierre_tipos[i]));
			}
			String salida = g.toJson(lCierre_tipo);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		}
	}
	
	public String obtenerDiagnostico() {
		Gson g = new Gson();
		List<DiagnosticoVo> lDiagnostico = new ArrayList<DiagnosticoVo>();

		try {
			orm.Diagnostico[] diagnosticos = orm.DiagnosticoDAO
					.listDiagnosticoByQuery(null, null);

			for (int i = 0; i < diagnosticos.length; i++) {
				lDiagnostico.add(DiagnosticoVo.fromORM(diagnosticos[i]));
			}
			String salida = g.toJson(lDiagnostico);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String obtenerProcedimiento() {
		Gson g = new Gson();
		List<ProcedimientoVo> lProcedimiento = new ArrayList<ProcedimientoVo>();

		try {
			orm.Procedimiento[] procedimientos = orm.ProcedimientoDAO
					.listProcedimientoByQuery(null, null);

			for (int i = 0; i < procedimientos.length; i++) {
				lProcedimiento.add(ProcedimientoVo.fromORM(procedimientos[i]));
			}
			String salida = g.toJson(lProcedimiento);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String obtenerRce_cierre() {
		Gson g = new Gson();
		List<Rce_cierreVo> lRce_cierre = new ArrayList<Rce_cierreVo>();

		try {
			orm.Rce_cierre[] rce_cierres = orm.Rce_cierreDAO
					.listRce_cierreByQuery(null, null);

			for (int i = 0; i < rce_cierres.length; i++) {
				lRce_cierre.add(Rce_cierreVo.fromORM(rce_cierres[i]));
			}
			String salida = g.toJson(lRce_cierre);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String obtenerReceta() {
		Gson g = new Gson();
		List<RecetaVo> lReceta = new ArrayList<RecetaVo>();

		try {
			orm.Receta[] recetas = orm.RecetaDAO
					.listRecetaByQuery(null, null);

			for (int i = 0; i < recetas.length; i++) {
				lReceta.add(RecetaVo.fromORM(recetas[i]));
			}
			String salida = g.toJson(lReceta);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String obtenerTiempo_control() {
		Gson g = new Gson();
		List<Tiempo_controlVo> lTiempo_control = new ArrayList<Tiempo_controlVo>();

		try {
			orm.Tiempo_control[] tiempo_controles = orm.Tiempo_controlDAO
					.listTiempo_controlByQuery(null, null);

			for (int i = 0; i < tiempo_controles.length; i++) {
				lTiempo_control.add(Tiempo_controlVo.fromORM(tiempo_controles[i]));
			}
			String salida = g.toJson(lTiempo_control);

			return salida;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String ingresarRce(int id, String encounter_uuid, String alergias, String anamnesis,
			String motivo, String examen_fisico, String indicador_medico,
			String indicador_cierre, String hipotesis, String detalle_ges,
			int horamedica_id, int receta_id,
			int diagnostico_id, int procedimiento_id,
			int actividad_id, int paciente_id, int[] lCertificados) {

			Gson g = new Gson();
			try {
				orm.Rce rce = new orm.Rce();
				orm.Receta receta = orm.RecetaDAO.getRecetaByORMID(receta_id);
				orm.Hora_medica hora = orm.Hora_medicaDAO.getHora_medicaByORMID(horamedica_id);
				orm.Diagnostico diag = orm.DiagnosticoDAO.getDiagnosticoByORMID(receta_id);
				orm.Procedimiento proce = orm.ProcedimientoDAO.getProcedimientoByORMID(procedimiento_id);
				orm.Actividad activ = orm.ActividadDAO.getActividadByORMID(actividad_id);
				orm.Paciente paci = orm.PacienteDAO.getPacienteByORMID(paciente_id);
				rce.setEncounter_uuid(encounter_uuid);
				rce.setAlergias(alergias);
				rce.setAnamnesis(anamnesis);
				rce.setMotivo(motivo);
				rce.setExamen_fisico(examen_fisico);
				rce.setIndicador_medico(indicador_medico);
				rce.setIndicador_cierre(indicador_cierre);
				rce.setHipotesis(hipotesis);
				rce.setDetalle_ges(detalle_ges);
				
				rce.setReceta(receta);
				rce.setDiagnostico(diag);
				rce.setProcedimiento(proce);
				rce.setActividad(activ);
				rce.setPaciente(paci);
				rce.setHora_medica(hora);
				
				
				if (orm.RceDAO.save(rce)) {
					
					orm.RceDAO.refresh(rce);
					ArrayList<orm.Certificado> c = new ArrayList<>();
					for (int i = 0; i < lCertificados.length; i++) {
						c.add(orm.CertificadoDAO.getCertificadoByORMID(lCertificados[i]));
					}
					
					for (int i = 0; i < c.size(); i++) {
						rce.certificado.add(c.get(i));
					}
					
					orm.RceDAO.save(rce);
					RceVo rvo = RceVo.fromORM(rce);
					String salida = g.toJson(rvo);
					return salida;
				}
				
			}
		 catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String obtenerRceDeUnPaciente(int IdPaciente) {
		Gson g = new Gson();
		List<RceVo> rcevos = new ArrayList<RceVo>();
		try {
			orm.Rce[] ormRce = orm.RceDAO.listRceByQuery(
					"pacienteid='" + String.valueOf(IdPaciente) + "'",
					null);

			for (int i = 0; i < ormRce.length; i++) {
				rcevos.add(RceVo.fromORM(ormRce[i]));
			}
			String salida = g.toJson(rcevos);
			return salida;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String obtenerPacientePorRut(String rutIngresado) {
		Gson g = new Gson();
		try {
			orm.PersonaCriteria pc = new orm.PersonaCriteria();
			pc.rut.eq(rutIngresado);
			orm.Persona personaResult = (orm.Persona) pc.uniqueResult();
			if (personaResult != null) {
				List lres = PacienteDAO.queryPaciente("persona_id="+personaResult.getId(), null);
				orm.Paciente pac = lres.isEmpty() ? null : (orm.Paciente)lres.get(0);
				if (pac != null) {
					return g.toJson(PacienteVo.fromORM(pac));
				}
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String obtenerMedicoPorRut(String rutIngresado) {
		Gson g = new Gson();
		try {
			orm.PersonaCriteria pc = new orm.PersonaCriteria();
			pc.rut.eq(rutIngresado);
			orm.Persona personaResult = (orm.Persona) pc.uniqueResult();
			if (personaResult != null) {
				List lres = MedicoDAO.queryMedico("persona_id="+personaResult.getId(), null);
				orm.Medico pac = lres.isEmpty() ? null : (orm.Medico)lres.get(0);
				if (pac != null) {
					return g.toJson(MedicoVo.fromORM(pac));
				}
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String ingresarReceta(int id, byte paciente_ges, byte paciente_cronico, byte patologia_ges,
			String desc) {

			Gson g = new Gson();
			try {
				orm.Receta rec = new orm.Receta();
				rec.setPaciente_ges(paciente_ges);
				rec.setPaciente_cronico(paciente_cronico);
				rec.setPatologia_ges(patologia_ges);
				rec.setDesc(desc);
				orm.RecetaDAO.save(rec);
				orm.RecetaDAO.refresh(rec);
				
				return g.toJson(RecetaVo.fromORM(rec));
			}
		 catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}