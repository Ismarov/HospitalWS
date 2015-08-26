package vo;

public class Tiempo_controlVo {
	private int id;
	private String desc;
	
	public Tiempo_controlVo(int id, String desc) {
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
	
	public static Tiempo_controlVo fromORM(orm.Tiempo_control t) {
		Tiempo_controlVo ti = new Tiempo_controlVo(t.getId(), t.getDesc());
		return ti;
	}

}
