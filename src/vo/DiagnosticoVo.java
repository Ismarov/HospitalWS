package vo;

public class DiagnosticoVo {
	
	private int id;
	private String desc;
	
	public DiagnosticoVo(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static DiagnosticoVo fromORM(orm.Diagnostico d) {
		DiagnosticoVo di = new DiagnosticoVo(d.getId(), d.getDesc());
		return di;
	}

}
