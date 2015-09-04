package business;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import orm.Hospitaldb2PersistentManager;
import orm.MedicoDAO;
import orm.PacienteDAO;
import orm.Receta;
import vo.ActividadVo;
import vo.CertificadoVo;
import vo.Cierre_destinoVo;
import vo.Cierre_tipoVo;
import vo.DiagnosticoVo;
import vo.MedicoVo;
import vo.PacienteVo;
import vo.ProcedimientoVo;
import vo.RceVo;
import vo.Rce_cierreVo;
import vo.RecetaVo;
import vo.Tiempo_controlVo;

import com.google.gson.Gson;

public class Rce {
	
	
	/**
	 * obtenerActividades Entrega una lista con los actividades existentes.
	 * @return Una lista de actividades o null en caso de error.
	 */
	public ArrayList<ActividadVo> obtenerActividades() {

		ArrayList<ActividadVo> lActividad = new ArrayList<ActividadVo>();

		try {
			orm.Actividad[] actividades = orm.ActividadDAO
					.listActividadByQuery(null, null);

			for (int i = 0; i < actividades.length; i++) {
				lActividad.add(ActividadVo.fromORM(actividades[i]));
			}
			return lActividad;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * obtenerCertificados Entrega una lista con los certificados existentes.
	 * @return Una lista de certificados o null en caso de error.
	 */
	public ArrayList<CertificadoVo> obtenerCertificados() {

		ArrayList<CertificadoVo> lCertificado = new ArrayList<CertificadoVo>();

		try {
			orm.Certificado[] certificados = orm.CertificadoDAO
					.listCertificadoByQuery(null, null);

			for (int i = 0; i < certificados.length; i++) {
				lCertificado.add(CertificadoVo.fromORM(certificados[i]));
			}
			return lCertificado;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;

		}
	}
	
	
	/**
	 * obtenerDiagnosticos Entrega una lista con los diagnosticos existentes.
	 * @return Una lista de diagnosticos o null.
	 */
	public ArrayList<DiagnosticoVo> obtenerDiagnosticos() {
		
		ArrayList<DiagnosticoVo> lDiagnostico = new ArrayList<DiagnosticoVo>();

		try {
			orm.Diagnostico[] diagnosticos = orm.DiagnosticoDAO
					.listDiagnosticoByQuery(null, null);

			for (int i = 0; i < diagnosticos.length; i++) {
				lDiagnostico.add(DiagnosticoVo.fromORM(diagnosticos[i]));
			}
			return lDiagnostico;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * obtenerProcedimientos Entrega una lista con los procedimientos existentes.
	 * @return Una lista de procedimientos o null.
	 */
	public ArrayList<ProcedimientoVo> obtenerProcedimientos() {
		
		ArrayList<ProcedimientoVo> lProcedimiento = new ArrayList<ProcedimientoVo>();

		try {
			orm.Procedimiento[] procedimientos = orm.ProcedimientoDAO
					.listProcedimientoByQuery(null, null);

			for (int i = 0; i < procedimientos.length; i++) {
				lProcedimiento.add(ProcedimientoVo.fromORM(procedimientos[i]));
			}
			return lProcedimiento;

		} catch (PersistentException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * ingresarRce Inserta un Registro Clinico Electronico en el sistema.
	 * @param id
	 * @param encounter_uuid
	 * @param alergias
	 * @param anamnesis
	 * @param motivo
	 * @param examen_fisico
	 * @param indicador_medico
	 * @param indicador_cierre
	 * @param hipotesis
	 * @param detalle_ges
	 * @param horamedica_id
	 * @param receta_json
	 * @param diagnostico_id
	 * @param lprocedimiento_id
	 * @param lactividad_id
	 * @param paciente_id
	 * @param lCertificados
	 * @return ValueObject representando el RCE ingresado, o null si ocurre un error. 
	 */
	public RceVo ingresarRce(int id, String encounter_uuid, String alergias, String anamnesis,
			String motivo, String examen_fisico, String indicador_medico,
			String indicador_cierre, String hipotesis, String detalle_ges,
			int horamedica_id, String receta_json,
			int diagnostico_id, int[] lprocedimiento_id,
			int[] lactividad_id, int paciente_id, int[] lCertificados) {

			Gson g = new Gson();
			
			try {
				
				// Iniciar Transacción
				PersistentTransaction t = Hospitaldb2PersistentManager.instance().getSession().beginTransaction();

				// Procesar recetas
				RecetaVo[] recetas = g.fromJson(receta_json, RecetaVo[].class);
				orm.Receta[] r_orm = new orm.Receta[recetas.length];
				
				for (int i = 0; i < r_orm.length; i++) {
					r_orm[i] = new Receta();
					r_orm[i].setDesc(recetas[i].getDesc());
					r_orm[i].setPaciente_cronico((byte)recetas[i].getPaciente_cronico());
					r_orm[i].setPaciente_ges((byte)recetas[i].getPaciente_ges());
					r_orm[i].setPatologia_ges((byte)recetas[i].getPatologia_ges());
					orm.RecetaDAO.save(r_orm[i]);
					orm.RecetaDAO.refresh(r_orm[i]);
				}
				
				// Crear lista de parametros
				ArrayList<orm.Certificado> c = new ArrayList<>();
				for (int i = 0; i < lCertificados.length; i++) {
					c.add(orm.CertificadoDAO.getCertificadoByORMID(lCertificados[i]));
				}
				
				ArrayList<orm.Actividad> a = new ArrayList<>();
				for (int i = 0; i < lactividad_id.length; i++) {
					a.add(orm.ActividadDAO.getActividadByORMID(lactividad_id[i]));
				}
				
				ArrayList<orm.Procedimiento> p = new ArrayList<>();
				for (int i = 0; i < lprocedimiento_id.length; i++) {
					p.add(orm.ProcedimientoDAO.getProcedimientoByORMID(lprocedimiento_id[i]));
				}
				
				// Crear RCE
				orm.Rce rce = new orm.Rce();
				
				orm.Hora_medica hora = orm.Hora_medicaDAO.getHora_medicaByORMID(horamedica_id);
				orm.Diagnostico diag = orm.DiagnosticoDAO.getDiagnosticoByORMID(diagnostico_id);
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
				rce.setDiagnostico(diag);
				rce.setPaciente(paci);
				rce.setHora_medica(hora);
				
				if (orm.RceDAO.save(rce)) {					
					orm.RceDAO.refresh(rce);
					
					// Asociar con Certificados, Actividades, Procedimientos y Recetas
					for (int i = 0; i < c.size(); i++) {
						rce.certificado.add(c.get(i));
					}
					for (int i = 0; i < a.size(); i++) {
						rce.actividad.add(a.get(i));
					}
					for (int i = 0; i < p.size(); i++) {
						rce.procedimiento.add(p.get(i));
					}
					for (int i = 0; i < r_orm.length; i++) {
						rce.receta.add(r_orm[i]);
					}
					
					orm.RceDAO.save(rce);
					orm.RceDAO.refresh(rce);
				}
				
				// Comprometer la transacción
				t.commit();				
				return RceVo.fromORM(rce);
				
			} catch (PersistentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return null;
	}
	
	
	/**
	 * obtenerHceDeUnPaciente obtiene el historial de RCEs del paciente.
	 * @param IdPaciente
	 * @return Lista representando el Historial de RCEs de un Paciente o null si encuentra un error.
	 */
	public ArrayList<RceVo> obtenerHceDeUnPaciente(int IdPaciente) {

		ArrayList<RceVo> rcevos = new ArrayList<RceVo>();
		try {
			orm.Rce[] ormRce = orm.RceDAO.listRceByQuery(
					"pacienteid='" + String.valueOf(IdPaciente) + "'",
					null);

			for (int i = 0; i < ormRce.length; i++) {
				rcevos.add(RceVo.fromORM(ormRce[i]));
			}
			return rcevos;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * obtenetPacientePorRut Obtiene un paciente segun su RUT 
	 * @param rut
	 * @return ValueObject representando al paciente o null en caso de no haberlo encontrado.
	 */
	public PacienteVo obtenerPacientePorRut(String rut) {

		try {
			orm.PersonaCriteria pc = new orm.PersonaCriteria();
			pc.rut.eq(rut);
			orm.Persona personaResult = (orm.Persona) pc.uniqueResult();
			if (personaResult != null) {
				@SuppressWarnings("rawtypes")
				List lres = PacienteDAO.queryPaciente("persona_id="+personaResult.getId(), null);
				orm.Paciente pac = lres.isEmpty() ? null : (orm.Paciente)lres.get(0);
				if (pac != null) {
					return PacienteVo.fromORM(pac);
				}
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* ################################################### */
	/* ##
	/* ## -- NO IMPLEMENTADOS COMO SERVICIOS TODAVIA -- ## */
	// ##
	
	
	public String obtenerMedicoPorRut(String rutIngresado) {
		Gson g = new Gson();
		try {
			orm.PersonaCriteria pc = new orm.PersonaCriteria();
			pc.rut.eq(rutIngresado);
			orm.Persona personaResult = (orm.Persona) pc.uniqueResult();
			if (personaResult != null) {
				@SuppressWarnings("rawtypes")
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

}