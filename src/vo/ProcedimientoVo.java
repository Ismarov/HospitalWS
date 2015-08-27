package vo;

public class ProcedimientoVo {
	
	private int id;
	private String desc;
	
	public ProcedimientoVo(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}
	public String getDesc(){
		return desc;
	}
	
	public static ProcedimientoVo fromORM(orm.Procedimiento p) {
		ProcedimientoVo pr = new ProcedimientoVo(p.getId(), p.getDesc());
		return pr;
	}

}
