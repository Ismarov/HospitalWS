package vo;

public class RecetaVo {
	private int id;
	private int paciente_ges;
	private int paciente_cronico;
	private int patologia_ges;
	private String desc;
	
	
	
	public RecetaVo(int id, int paciente_ges, int paciente_cronico,
			int patologia_ges, String desc) {
		super();
		this.id = id;
		this.paciente_ges = paciente_ges;
		this.paciente_cronico = paciente_cronico;
		this.patologia_ges = patologia_ges;
		this.desc = desc;
	}

	

	public int getId() {
		return id;
	}



	public int getPaciente_ges() {
		return paciente_ges;
	}



	public int getPaciente_cronico() {
		return paciente_cronico;
	}



	public int getPatologia_ges() {
		return patologia_ges;
	}



	public String getDesc() {
		return desc;
	}



	public static RecetaVo fromORM(orm.Receta r) {
		RecetaVo re = new RecetaVo(r.getId(), r.getPaciente_ges(), r.getPaciente_cronico(), r.getPatologia_ges(), r.getDesc());
		return re;
	}

}
