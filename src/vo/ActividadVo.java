package vo;

public class ActividadVo {
	private int id;
	private String desc;
	
	public ActividadVo(int id, String desc) {
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
	

	public static ActividadVo fromORM(orm.Actividad a) {
		ActividadVo ac = new ActividadVo(a.getId(), a.getDesc());
		return ac;
	}
	

}
