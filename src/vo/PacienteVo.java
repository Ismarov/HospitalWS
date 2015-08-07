package vo;

public class PacienteVo {
	private int id;
	private PersonaVo personavo;

	public PacienteVo(int id, PersonaVo personavo) {
		super();
		this.id = id;
		this.personavo = personavo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public PersonaVo getPersonavo() {
		return personavo;
	}

	public static PacienteVo fromORM(orm.Paciente paciente){
		PersonaVo pe = PersonaVo.fromORM(paciente.getPersona());
		PacienteVo pa = new PacienteVo(paciente.getId(), pe);
		return pa;
	}
}
