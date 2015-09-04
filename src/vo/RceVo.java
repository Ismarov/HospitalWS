package vo;

public class RceVo {
	
	private int id;
	private String encounter_uuid;
	private String alergias;
	private String anamnesis;
	private String motivo;
	private String examen_fisico;
	private String indicador_medico;
	private String indicador_cierre;
	private String hipotesis;
	private String detalle_ges;
	HoraMedicaVo horamedica;
	RecetaVo[] receta;
	DiagnosticoVo diagnostico;
	ProcedimientoVo[] procedimiento;
	ActividadVo[] actividad;
	PacienteVo paciente;
	
	public RceVo(int id, String encounter_uuid, String alergias, String anamnesis,
			String motivo, String examen_fisico, String indicador_medico,
			String indicador_cierre, String hipotesis, String detalle_ges,
			HoraMedicaVo horamedica, RecetaVo[] receta,
			DiagnosticoVo diagnostico, ProcedimientoVo[] procedimiento,
			ActividadVo[] actividad, PacienteVo paciente) {
		super();
		this.id = id;
		this.encounter_uuid = encounter_uuid;
		this.alergias = alergias;
		this.anamnesis = anamnesis;
		this.motivo = motivo;
		this.examen_fisico = examen_fisico;
		this.indicador_medico = indicador_medico;
		this.indicador_cierre = indicador_cierre;
		this.hipotesis = hipotesis;
		this.detalle_ges = detalle_ges;
		this.horamedica = horamedica;
		this.receta = receta;
		this.diagnostico = diagnostico;
		this.procedimiento = procedimiento;
		this.actividad = actividad;
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

	public String getEncounter_uuid() {
		return encounter_uuid;
	}

	public String getAlergias() {
		return alergias;
	}

	public String getAnamnesis() {
		return anamnesis;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getExamen_fisico() {
		return examen_fisico;
	}

	public String getIndicador_medico() {
		return indicador_medico;
	}

	public String getIndicador_cierre() {
		return indicador_cierre;
	}

	public String getHipotesis() {
		return hipotesis;
	}

	public String getDetalle_ges() {
		return detalle_ges;
	}

	public HoraMedicaVo getHoramedica() {
		return horamedica;
	}

	public RecetaVo[] getRecetas() {
		return receta;
	}

	public DiagnosticoVo getDiagnosticos() {
		return diagnostico;
	}

	public ProcedimientoVo[] getProcedimientos() {
		return procedimiento;
	}

	public ActividadVo[] getActividades() {
		return actividad;
	}

	public PacienteVo getPaciente() {
		return paciente;
	}
	
	public static RceVo fromORM(orm.Rce r) {
		//Actividades
		ActividadVo[] actividades = new ActividadVo[ r.actividad.size()];
		orm.Actividad[] act_orm = (orm.Actividad[])(r.actividad.toArray());
		for(int i=0; i< r.actividad.size(); i++){
			actividades[i] = ActividadVo.fromORM(act_orm[i]);
		}
		//Procedimientos
		ProcedimientoVo[] procedimientos = new ProcedimientoVo[ r.procedimiento.size()];
		orm.Procedimiento[] proc_orm = (orm.Procedimiento[])(r.procedimiento.toArray());
		for(int i=0; i< r.procedimiento.size(); i++){
			procedimientos[i] = ProcedimientoVo.fromORM(proc_orm[i]);
		}
		
		//Recetas
		RecetaVo[] recetas = new RecetaVo[ r.receta.size()];
		orm.Receta[] rec_orm = (orm.Receta[])(r.receta.toArray());
		for(int i=0; i< r.receta.size(); i++){
			recetas[i] = RecetaVo.fromORM(rec_orm[i]);
		}
		
		
		RceVo rc = new RceVo(r.getId(), r.getEncounter_uuid(), r.getAlergias(), r.getAnamnesis(), 
		r.getMotivo(), r.getExamen_fisico(), r.getIndicador_medico(), r.getIndicador_cierre(), 
		r.getHipotesis(), r.getDetalle_ges(), HoraMedicaVo.fromORM(r.getHora_medica()), recetas, 
		DiagnosticoVo.fromORM(r.getDiagnostico()), procedimientos, 
		actividades, PacienteVo.fromORM(r.getPaciente()));
		return rc;
	}
	

}
