package vo;

public class MedicoVo {
	private PersonaVo persona;
	private EspecialidadVo especialidad;
	private int id;
	
	public MedicoVo(int id, PersonaVo personavo,
			EspecialidadVo especialidadvo) {
		super();
		this.id = id;
		this.persona = personavo;
		this.especialidad = especialidadvo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public PersonaVo getPersona() {
		return this.persona;
	}

	public EspecialidadVo getEspecialidad() {
		return this.especialidad;
	}
	
	public static MedicoVo fromORM(orm.Medico m) {
		PersonaVo p = PersonaVo.fromORM(m.getPersona());
		EspecialidadVo e = EspecialidadVo.fromORM(m.getEspecialidad());
		MedicoVo me = new MedicoVo(m.getId(), p, e);
		return me;
	}
	
}