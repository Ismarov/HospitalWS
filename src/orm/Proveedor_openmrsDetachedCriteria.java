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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Proveedor_openmrsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression uuid;
	public final IntegerExpression medicoId;
	public final AssociationExpression medico;
	
	public Proveedor_openmrsDetachedCriteria() {
		super(orm.Proveedor_openmrs.class, orm.Proveedor_openmrsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		uuid = new IntegerExpression("uuid", this.getDetachedCriteria());
		medicoId = new IntegerExpression("medico.id", this.getDetachedCriteria());
		medico = new AssociationExpression("medico", this.getDetachedCriteria());
	}
	
	public Proveedor_openmrsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.Proveedor_openmrsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		uuid = new IntegerExpression("uuid", this.getDetachedCriteria());
		medicoId = new IntegerExpression("medico.id", this.getDetachedCriteria());
		medico = new AssociationExpression("medico", this.getDetachedCriteria());
	}
	
	public MedicoDetachedCriteria createMedicoCriteria() {
		return new MedicoDetachedCriteria(createCriteria("medico"));
	}
	
	public Proveedor_openmrs uniqueProveedor_openmrs(PersistentSession session) {
		return (Proveedor_openmrs) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Proveedor_openmrs[] listProveedor_openmrs(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Proveedor_openmrs[]) list.toArray(new Proveedor_openmrs[list.size()]);
	}
}

