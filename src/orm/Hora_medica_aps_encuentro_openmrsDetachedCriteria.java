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

public class Hora_medica_aps_encuentro_openmrsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression uuid;
	public final IntegerExpression hora_medicaId;
	public final AssociationExpression hora_medica;
	
	public Hora_medica_aps_encuentro_openmrsDetachedCriteria() {
		super(orm.Hora_medica_aps_encuentro_openmrs.class, orm.Hora_medica_aps_encuentro_openmrsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		hora_medicaId = new IntegerExpression("hora_medica.id", this.getDetachedCriteria());
		hora_medica = new AssociationExpression("hora_medica", this.getDetachedCriteria());
	}
	
	public Hora_medica_aps_encuentro_openmrsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.Hora_medica_aps_encuentro_openmrsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		hora_medicaId = new IntegerExpression("hora_medica.id", this.getDetachedCriteria());
		hora_medica = new AssociationExpression("hora_medica", this.getDetachedCriteria());
	}
	
	public Hora_medicaDetachedCriteria createHora_medicaCriteria() {
		return new Hora_medicaDetachedCriteria(createCriteria("hora_medica"));
	}
	
	public Hora_medica_aps_encuentro_openmrs uniqueHora_medica_aps_encuentro_openmrs(PersistentSession session) {
		return (Hora_medica_aps_encuentro_openmrs) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Hora_medica_aps_encuentro_openmrs[] listHora_medica_aps_encuentro_openmrs(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Hora_medica_aps_encuentro_openmrs[]) list.toArray(new Hora_medica_aps_encuentro_openmrs[list.size()]);
	}
}

