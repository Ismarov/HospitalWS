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
@Table(name="paciente_openmrs")
public class Paciente_openmrs implements Serializable {
	public Paciente_openmrs() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ORM_PACIENTE_OPENMRS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_PACIENTE_OPENMRS_ID_GENERATOR", strategy="identity")	
	private int id;
	
	@Column(name="uuid", nullable=false, unique=true, length=50)	
	private String uuid;
	
	@OneToOne(targetEntity=orm.Paciente.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="pacienteid", referencedColumnName="id", nullable=false) })	
	private orm.Paciente paciente;
	
	public void setUuid(String value) {
		this.uuid = value;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPaciente(orm.Paciente value) {
		if (this.paciente != value) {
			orm.Paciente lpaciente = this.paciente;
			this.paciente = value;
			if (value != null) {
				paciente.setPaciente_openmrs(this);
			}
			if (lpaciente != null) {
				lpaciente.setPaciente_openmrs(null);
			}
		}
	}
	
	public orm.Paciente getPaciente() {
		return paciente;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
