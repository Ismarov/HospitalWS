package vo;

/**
 * 
 * Clase HoraMedicaPacienteVo
 * Genera un VO de HoraMedicaPaciente con los datos de HoraMedicaPaciente, constructor con parámetros, 
 * getters y método para usar con ORM.
 *
 */
public class HoraMedicaPacienteVo {
	private HoraMedicaVo horamedicavo;
	private ReservaVo reservavo;

	public HoraMedicaPacienteVo(HoraMedicaVo horamedicavo, ReservaVo reservavo) {
		super();
		this.horamedicavo = horamedicavo;
		this.reservavo = reservavo;
	}

	public HoraMedicaVo getHoramedicapaciente_horamedicavo() {
		return horamedicavo;
	}

	public void setHoramedicapaciente_horamedicavo(
			HoraMedicaVo horamedicapaciente_horamedicavo) {
		this.horamedicavo = horamedicapaciente_horamedicavo;
	}

	public ReservaVo getHoramedicapaciente_reservavo() {
		return reservavo;
	}

	public void setHoramedicapaciente_reservavo(
			ReservaVo horamedicapaciente_reservavo) {
		this.reservavo = horamedicapaciente_reservavo;
	}

}
