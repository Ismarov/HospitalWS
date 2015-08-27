package bussines;

import java.util.ArrayList;
import java.util.List;

import org.orm.PersistentException;

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
}