/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="hora_medica")
public class Hora_medica implements Serializable {
	public Hora_medica() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_HORA_MEDICA_RESERVA) {
			return ORM_reserva;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == orm.ORMConstants.KEY_HORA_MEDICA_MEDICO) {
			this.medico = (orm.Medico) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_HORA_MEDICA_BOX) {
			this.box = (orm.Box) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_HORA_MEDICA_HORA_MEDICA_VISITA_OPENMRS) {
			this.hora_medica_visita_openmrs = (orm.Hora_medica_visita_openmrs) owner;
		}
		
		else if (key == orm.ORMConstants.KEY_HORA_MEDICA_HORA_MEDICA_APS_ENCUENTRO_OPENMRS) {
			this.hora_medica_aps_encuentro_openmrs = (orm.Hora_medica_aps_encuentro_openmrs) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ORM_HORA_MEDICA_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_HORA_MEDICA_ID_GENERATOR", strategy="identity")	
	private int id;
	
	@ManyToOne(targetEntity=orm.Medico.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="medico_id", referencedColumnName="id", nullable=false) })	
	private orm.Medico medico;
	
	@ManyToOne(targetEntity=orm.Box.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="box_id", referencedColumnName="id", nullable=false) })	
	private orm.Box box;
	
	@Column(name="f_inicio", nullable=false)	
	private java.sql.Timestamp f_inicio;
	
	@Column(name="f_fin", nullable=false)	
	private java.sql.Timestamp f_fin;
	
	@ManyToMany(mappedBy="ORM_hora_medica", targetEntity=orm.Reserva.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_reserva = new java.util.HashSet();
	
	@OneToOne(mappedBy="hora_medica", targetEntity=orm.Hora_medica_visita_openmrs.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs;
	
	@OneToOne(mappedBy="hora_medica", targetEntity=orm.Hora_medica_aps_encuentro_openmrs.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private orm.Hora_medica_aps_encuentro_openmrs hora_medica_aps_encuentro_openmrs;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setF_inicio(java.sql.Timestamp value) {
		this.f_inicio = value;
	}
	
	public java.sql.Timestamp getF_inicio() {
		return f_inicio;
	}
	
	public void setF_fin(java.sql.Timestamp value) {
		this.f_fin = value;
	}
	
	public java.sql.Timestamp getF_fin() {
		return f_fin;
	}
	
	public void setMedico(orm.Medico value) {
		if (medico != null) {
			medico.hora_medica.remove(this);
		}
		if (value != null) {
			value.hora_medica.add(this);
		}
	}
	
	public orm.Medico getMedico() {
		return medico;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Medico(orm.Medico value) {
		this.medico = value;
	}
	
	private orm.Medico getORM_Medico() {
		return medico;
	}
	
	public void setBox(orm.Box value) {
		if (box != null) {
			box.hora_medica.remove(this);
		}
		if (value != null) {
			value.hora_medica.add(this);
		}
	}
	
	public orm.Box getBox() {
		return box;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Box(orm.Box value) {
		this.box = value;
	}
	
	private orm.Box getORM_Box() {
		return box;
	}
	
	private void setORM_Reserva(java.util.Set value) {
		this.ORM_reserva = value;
	}
	
	private java.util.Set getORM_Reserva() {
		return ORM_reserva;
	}
	
	@Transient	
	public final orm.ReservaSetCollection reserva = new orm.ReservaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_HORA_MEDICA_RESERVA, orm.ORMConstants.KEY_RESERVA_HORA_MEDICA, orm.ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setHora_medica_visita_openmrs(orm.Hora_medica_visita_openmrs value) {
		if (this.hora_medica_visita_openmrs != value) {
			orm.Hora_medica_visita_openmrs lhora_medica_visita_openmrs = this.hora_medica_visita_openmrs;
			this.hora_medica_visita_openmrs = value;
			if (value != null) {
				hora_medica_visita_openmrs.setHora_medica(this);
			}
			if (lhora_medica_visita_openmrs != null) {
				lhora_medica_visita_openmrs.setHora_medica(null);
			}
		}
	}
	
	public orm.Hora_medica_visita_openmrs getHora_medica_visita_openmrs() {
		return hora_medica_visita_openmrs;
	}
	
	public void setHora_medica_aps_encuentro_openmrs(orm.Hora_medica_aps_encuentro_openmrs value) {
		if (this.hora_medica_aps_encuentro_openmrs != value) {
			orm.Hora_medica_aps_encuentro_openmrs lhora_medica_aps_encuentro_openmrs = this.hora_medica_aps_encuentro_openmrs;
			this.hora_medica_aps_encuentro_openmrs = value;
			if (value != null) {
				hora_medica_aps_encuentro_openmrs.setHora_medica(this);
			}
			if (lhora_medica_aps_encuentro_openmrs != null) {
				lhora_medica_aps_encuentro_openmrs.setHora_medica(null);
			}
		}
	}
	
	public orm.Hora_medica_aps_encuentro_openmrs getHora_medica_aps_encuentro_openmrs() {
		return hora_medica_aps_encuentro_openmrs;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
