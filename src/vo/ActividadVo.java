package vo;

public class ActividadVo {
	private int id;
	private String desc;
	DiagnosticoVo diagnostico;
	
	public ActividadVo(int id, String desc, DiagnosticoVo diagnostico) {
		super();
		this.id = id;
		this.desc = desc;
		this.diagnostico = diagnostico;
	}

	public int getId() {
		return id;
	}
	public String getDesc(){
		return desc;
	}
	
	public DiagnosticoVo getDiagnostico() {
		return diagnostico;
	}

	public static ActividadVo fromORM(orm.Actividad a) {
		ActividadVo ac = new ActividadVo(a.getId(), a.getDesc(), DiagnosticoVo.fromORM(a.getDiagnostico()));
		return ac;
	}
	

}
