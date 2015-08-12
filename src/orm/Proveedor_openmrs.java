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
@Table(name="proveedor_openmrs")
public class Proveedor_openmrs implements Serializable {
	public Proveedor_openmrs() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ORM_PROVEEDOR_OPENMRS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORM_PROVEEDOR_OPENMRS_ID_GENERATOR", strategy="identity")	
	private int id;
	
	@Column(name="uuid", nullable=false, unique=true, length=10)	
	private int uuid;
	
	@OneToOne(targetEntity=orm.Medico.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="medicoid", referencedColumnName="id", nullable=false) })	
	private orm.Medico medico;
	
	public void setUuid(int value) {
		this.uuid = value;
	}
	
	public int getUuid() {
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
	
	public void setMedico(orm.Medico value) {
		if (this.medico != value) {
			orm.Medico lmedico = this.medico;
			this.medico = value;
			if (value != null) {
				medico.setProveedor_openmrs(this);
			}
			if (lmedico != null) {
				lmedico.setProveedor_openmrs(null);
			}
		}
	}
	
	public orm.Medico getMedico() {
		return medico;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
