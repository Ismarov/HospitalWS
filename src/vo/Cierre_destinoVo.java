package vo;

public class Cierre_destinoVo {
	
	private int id;
	private String desc;
	
	public Cierre_destinoVo(int id, String desc) {
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
	
	public static Cierre_destinoVo fromORM(orm.Cierre_destino c) {
		Cierre_destinoVo ci = new Cierre_destinoVo(c.getId(), c.getDesc());
		return ci;
	}

}
