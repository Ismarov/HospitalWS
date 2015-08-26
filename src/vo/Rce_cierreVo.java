package vo;

import java.util.Date;

public class Rce_cierreVo {
	
	private int id;
	private Date f_atencion;
	private Date hora_atencion;
	private Date f_cierre;
	private Date hora_cierre;
	Cierre_destinoVo cierre_destino;
	Cierre_tipoVo cierre_tipo;
	Tiempo_controlVo tiempo_control;
	RceVo rce;
	
	public Rce_cierreVo(int id, Date f_atencion, Date hora_atencion,
			Date f_cierre, Date hora_cierre, Cierre_destinoVo cierre_destino,
			Cierre_tipoVo cierre_tipo, Tiempo_controlVo tiempo_control,
			RceVo rce) {
		super();
		this.id = id;
		this.f_atencion = f_atencion;
		this.hora_atencion = hora_atencion;
		this.f_cierre = f_cierre;
		this.hora_cierre = hora_cierre;
		this.cierre_destino = cierre_destino;
		this.cierre_tipo = cierre_tipo;
		this.tiempo_control = tiempo_control;
		this.rce = rce;
	}

	public int getId() {
		return id;
	}

	public Date getF_atencion() {
		return f_atencion;
	}

	public Date getHora_atencion() {
		return hora_atencion;
	}

	public Date getF_cierre() {
		return f_cierre;
	}

	public Date getHora_cierre() {
		return hora_cierre;
	}

	public Cierre_destinoVo getCierre_destino() {
		return cierre_destino;
	}

	public Cierre_tipoVo getCierre_tipo() {
		return cierre_tipo;
	}

	public Tiempo_controlVo getTiempo_control() {
		return tiempo_control;
	}

	public RceVo getRce() {
		return rce;
	}
	
	public static Rce_cierreVo fromORM(orm.Rce_cierre r) {
		Rce_cierreVo rc = new Rce_cierreVo(r.getId(), r.getF_atencion(), r.getHora_atencion(), 
		r.getF_cierre(), r.getHora_cierre(), Cierre_destinoVo.fromORM(r.getCierre_destino()), 
		Cierre_tipoVo.fromORM(r.getCierre_tipo()), Tiempo_controlVo.fromORM(r.getTiempo_control()), 
		RceVo.fromORM(r.getRce()));
		return rc;
	}
	
	

}
