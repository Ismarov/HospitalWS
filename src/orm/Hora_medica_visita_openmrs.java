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
@Table(name="hora_medica_visita_openmrs")
public class Hora_medica_visita_openmrs implements Serializable {
	public Hora_medica_visita_openmrs() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ORM_HORA_MEDICA_VISITA_OPENMRS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_HORA_MEDICA_VISITA_OPENMRS_ID_GENERATOR", strategy="identity")	
	private int id;
	
	@Column(name="uuid", nullable=false, unique=true, length=50)	
	private String uuid;
	
	@OneToOne(targetEntity=orm.Hora_medica.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="hora_medicaid", referencedColumnName="id", nullable=false) })	
	private orm.Hora_medica hora_medica;
	
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
	
	public void setHora_medica(orm.Hora_medica value) {
		if (this.hora_medica != value) {
			orm.Hora_medica lhora_medica = this.hora_medica;
			this.hora_medica = value;
			if (value != null) {
				hora_medica.setHora_medica_visita_openmrs(this);
			}
			if (lhora_medica != null) {
				lhora_medica.setHora_medica_visita_openmrs(null);
			}
		}
	}
	
	public orm.Hora_medica getHora_medica() {
		return hora_medica;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
