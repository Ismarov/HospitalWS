package vo;

public class RceVo {
	
	private int id;
	private int encounter_uuid;
	private String alergias;
	private String anamnesis;
	private String motivo;
	private String examen_fisico;
	private String indicador_medico;
	private String indicador_cierre;
	private String hipotesis;
	private String detalle_ges;
	HoraMedicaVo horamedica;
	RecetaVo receta;
	DiagnosticoVo diagnostico;
	ProcedimientoVo procedimiento;
	ActividadVo actividad;
	PacienteVo paciente;
	
	public RceVo(int id, int encounter_uuid, String alergias, String anamnesis,
			String motivo, String examen_fisico, String indicador_medico,
			String indicador_cierre, String hipotesis, String detalle_ges,
			HoraMedicaVo horamedica, RecetaVo receta,
			DiagnosticoVo diagnostico, ProcedimientoVo procedimiento,
			ActividadVo actividad, PacienteVo paciente) {
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

	public int getEncounter_uuid() {
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

	public RecetaVo getReceta() {
		return receta;
	}

	public DiagnosticoVo getDiagnostico() {
		return diagnostico;
	}

	public ProcedimientoVo getProcedimiento() {
		return procedimiento;
	}

	public ActividadVo getActividad() {
		return actividad;
	}

	public PacienteVo getPaciente() {
		return paciente;
	}
	
	public static RceVo fromORM(orm.Rce r) {
		RceVo rc = new RceVo(r.getId(), r.getEncounter_uuid(), r.getAlergias(), r.getAnamnesis(), 
		r.getMotivo(), r.getExamen_fisico(), r.getIndicador_medico(), r.getIndicador_cierre(), 
		r.getHipotesis(), r.getDetalle_ges(), HoraMedicaVo.fromORM(r.getHora_medica()), RecetaVo.fromORM(r.getReceta()), 
		DiagnosticoVo.fromORM(r.getDiagnostico()), ProcedimientoVo.fromORM(r.getProcedimiento()), 
		ActividadVo.fromORM(r.getActividad()), PacienteVo.fromORM(r.getPaciente()));
		return rc;
	}
	

}
