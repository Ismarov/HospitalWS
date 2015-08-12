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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Proveedor_openmrsCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression uuid;
	public final IntegerExpression medicoId;
	public final AssociationExpression medico;
	
	public Proveedor_openmrsCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		uuid = new IntegerExpression("uuid", this);
		medicoId = new IntegerExpression("medico.id", this);
		medico = new AssociationExpression("medico", this);
	}
	
	public Proveedor_openmrsCriteria(PersistentSession session) {
		this(session.createCriteria(Proveedor_openmrs.class));
	}
	
	public Proveedor_openmrsCriteria() throws PersistentException {
		this(orm.Hospitaldb2PersistentManager.instance().getSession());
	}
	
	public MedicoCriteria createMedicoCriteria() {
		return new MedicoCriteria(createCriteria("medico"));
	}
	
	public Proveedor_openmrs uniqueProveedor_openmrs() {
		return (Proveedor_openmrs) super.uniqueResult();
	}
	
	public Proveedor_openmrs[] listProveedor_openmrs() {
		java.util.List list = super.list();
		return (Proveedor_openmrs[]) list.toArray(new Proveedor_openmrs[list.size()]);
	}
}

