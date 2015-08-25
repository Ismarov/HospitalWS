package vo;

public class CertificadoVo {
	
	private int id;
	private String desc;
	
	public CertificadoVo(int id, String desc) {
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
	
	public static CertificadoVo fromORM(orm.Certificado c) {
		CertificadoVo ce = new CertificadoVo(c.getId(), c.getDesc());
		return ce;
	}
}
