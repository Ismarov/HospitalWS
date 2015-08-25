package vo;

public class Cierre_tipoVo {
	
	private int id;
	private String desc;
	
	public Cierre_tipoVo(int id, String desc) {
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
	
	public static Cierre_tipoVo fromORM(orm.Cierre_tipo c) {
		Cierre_tipoVo ci = new Cierre_tipoVo(c.getId(), c.getDesc());
		return ci;
	}

}
