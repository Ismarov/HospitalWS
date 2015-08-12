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

public class Hora_medica_visita_openmrsCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression uuid;
	public final IntegerExpression hora_medicaId;
	public final AssociationExpression hora_medica;
	
	public Hora_medica_visita_openmrsCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		uuid = new StringExpression("uuid", this);
		hora_medicaId = new IntegerExpression("hora_medica.id", this);
		hora_medica = new AssociationExpression("hora_medica", this);
	}
	
	public Hora_medica_visita_openmrsCriteria(PersistentSession session) {
		this(session.createCriteria(Hora_medica_visita_openmrs.class));
	}
	
	public Hora_medica_visita_openmrsCriteria() throws PersistentException {
		this(orm.Hospitaldb2PersistentManager.instance().getSession());
	}
	
	public Hora_medicaCriteria createHora_medicaCriteria() {
		return new Hora_medicaCriteria(createCriteria("hora_medica"));
	}
	
	public Hora_medica_visita_openmrs uniqueHora_medica_visita_openmrs() {
		return (Hora_medica_visita_openmrs) super.uniqueResult();
	}
	
	public Hora_medica_visita_openmrs[] listHora_medica_visita_openmrs() {
		java.util.List list = super.list();
		return (Hora_medica_visita_openmrs[]) list.toArray(new Hora_medica_visita_openmrs[list.size()]);
	}
}

