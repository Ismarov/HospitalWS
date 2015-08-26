package vo;

public class ProcedimientoVo {
	
	private int id;
	private String desc;
	DiagnosticoVo diagnostico;
	
	public ProcedimientoVo(int id, String desc, DiagnosticoVo diagnostico) {
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

	public static ProcedimientoVo fromORM(orm.Procedimiento p) {
		ProcedimientoVo pr = new ProcedimientoVo(p.getId(), p.getDesc(), DiagnosticoVo.fromORM(p.getDiagnostico()));
		return pr;
	}

}
