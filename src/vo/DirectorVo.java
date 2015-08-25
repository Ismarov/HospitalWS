package vo;

/**
 * 
 * Clase DirectorVo
 * Genera un VO de Director con los datos de Director, constructor con parámetros, 
 * getters y método para usar con ORM.
 *
 */
public class DirectorVo {
	private int id;
	private PersonaVo personavo;

	public DirectorVo(int id, PersonaVo director_personavo) {
		super();
		this.id = id;
		this.personavo = director_personavo;
	}

	public int getId() {
		return this.id;
	}

	public PersonaVo getPersonaVo() {
		return personavo;
	}

	public static DirectorVo fromORM(orm.Director d) {
		PersonaVo p = PersonaVo.fromORM(d.getPersona());
		DirectorVo di = new DirectorVo(d.getId(), p);
		return di;
	}

}
