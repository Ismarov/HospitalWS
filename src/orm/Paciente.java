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
@Table(name="paciente")
public class Paciente implements Serializable {
	public Paciente() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == orm.ORMConstants.KEY_PACIENTE_RESERVA) {
			return ORM_reserva;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ORM_PACIENTE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_PACIENTE_ID_GENERATOR", strategy="identity")	
	private int id;
	
	@OneToOne(targetEntity=orm.Persona.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="persona_id", referencedColumnName="id", nullable=false) })	
	private orm.Persona persona;
	
	@OneToMany(mappedBy="paciente", targetEntity=orm.Reserva.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_reserva = new java.util.HashSet();
	
	@OneToOne(mappedBy="paciente", targetEntity=orm.Paciente_openmrs.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	private orm.Paciente_openmrs paciente_openmrs;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPersona(orm.Persona value) {
		if (this.persona != value) {
			orm.Persona lpersona = this.persona;
			this.persona = value;
			if (value != null) {
				persona.setPaciente(this);
			}
			if (lpersona != null) {
				lpersona.setPaciente(null);
			}
		}
	}
	
	public orm.Persona getPersona() {
		return persona;
	}
	
	private void setORM_Reserva(java.util.Set value) {
		this.ORM_reserva = value;
	}
	
	private java.util.Set getORM_Reserva() {
		return ORM_reserva;
	}
	
	@Transient	
	public final orm.ReservaSetCollection reserva = new orm.ReservaSetCollection(this, _ormAdapter, orm.ORMConstants.KEY_PACIENTE_RESERVA, orm.ORMConstants.KEY_RESERVA_PACIENTE, orm.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPaciente_openmrs(orm.Paciente_openmrs value) {
		if (this.paciente_openmrs != value) {
			orm.Paciente_openmrs lpaciente_openmrs = this.paciente_openmrs;
			this.paciente_openmrs = value;
			if (value != null) {
				paciente_openmrs.setPaciente(this);
			}
			if (lpaciente_openmrs != null) {
				lpaciente_openmrs.setPaciente(null);
			}
		}
	}
	
	public orm.Paciente_openmrs getPaciente_openmrs() {
		return paciente_openmrs;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
