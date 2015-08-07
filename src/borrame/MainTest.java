package borrame;

import java.util.Date;

import bussines.*;

public class MainTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

//		Director d = new Director();
//		String out = d.obtenerPacientesMasAtendido(new Date("01/01/1987 00:00:00"), new Date("12/31/2015 23:00:00"));
//		String out = d.obtenerMedicoMasSolicitado(new Date("01/01/1987 00:00:00"), new Date("12/31/2015 23:00:00"));

		Paciente p = new Paciente();
//		String out = p.buscarHoraAps(1, new Date("01/01/2015 00:15:00"), new Date("01/01/2015 00:30:00"));
//		String out = p.ReservarHoraAps(2, 2);
		
		Medico m = new Medico();
		String out = m.ReservarHoraMedicaControl(new int[]{7,8}, 1);

		System.out.println(out);
	}

}
