package vo;

/**
 * 
 * Clase EspecialidadVo
 * Genera un VO de Especialidad con los datos de Especialidad, constructor con parámetros, 
 * getters y método para usar con ORM.
 *
 */
public class EspecialidadVo {
	private int id;
	private String nombre;

	public EspecialidadVo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public static EspecialidadVo fromORM(orm.Especialidad e) {
		EspecialidadVo es = new EspecialidadVo(e.getId(), e.getNombre());
		return es;
	}

}
