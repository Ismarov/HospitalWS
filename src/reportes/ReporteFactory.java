package reportes;

public final class ReporteFactory {
	private static ReporteFactory _instance;
	public static enum REPORTE_TIPO { PAC_MAS_FREC, MED_MAS_SOL, BOX_OCUP_PORCENT };
	
	protected ReporteFactory(){}
	
	public static synchronized ReporteFactory getInstance(){
		if(_instance == null){
			_instance = new ReporteFactory();
			return _instance;
		}
		return _instance;
	}
	
	public Reporte getReporte(REPORTE_TIPO tipo){
		switch(tipo){
			case PAC_MAS_FREC:
				return new RepPacMasFrec();
			case MED_MAS_SOL:
				return new RepMedMasSol();
			case BOX_OCUP_PORCENT:
				return null;
		}
		return null;
	}

}
