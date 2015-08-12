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

public class Hora_medicaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression medicoId;
	public final AssociationExpression medico;
	public final IntegerExpression boxId;
	public final AssociationExpression box;
	public final TimestampExpression f_inicio;
	public final TimestampExpression f_fin;
	public final CollectionExpression reserva;
	public final IntegerExpression hora_medica_visita_openmrsId;
	public final AssociationExpression hora_medica_visita_openmrs;
	public final IntegerExpression hora_medica_aps_encuentro_openmrsId;
	public final AssociationExpression hora_medica_aps_encuentro_openmrs;
	
	public Hora_medicaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		medicoId = new IntegerExpression("medico.id", this);
		medico = new AssociationExpression("medico", this);
		boxId = new IntegerExpression("box.id", this);
		box = new AssociationExpression("box", this);
		f_inicio = new TimestampExpression("f_inicio", this);
		f_fin = new TimestampExpression("f_fin", this);
		reserva = new CollectionExpression("ORM_reserva", this);
		hora_medica_visita_openmrsId = new IntegerExpression("hora_medica_visita_openmrs.id", this);
		hora_medica_visita_openmrs = new AssociationExpression("hora_medica_visita_openmrs", this);
		hora_medica_aps_encuentro_openmrsId = new IntegerExpression("hora_medica_aps_encuentro_openmrs.id", this);
		hora_medica_aps_encuentro_openmrs = new AssociationExpression("hora_medica_aps_encuentro_openmrs", this);
	}
	
	public Hora_medicaCriteria(PersistentSession session) {
		this(session.createCriteria(Hora_medica.class));
	}
	
	public Hora_medicaCriteria() throws PersistentException {
		this(orm.Hospitaldb2PersistentManager.instance().getSession());
	}
	
	public MedicoCriteria createMedicoCriteria() {
		return new MedicoCriteria(createCriteria("medico"));
	}
	
	public BoxCriteria createBoxCriteria() {
		return new BoxCriteria(createCriteria("box"));
	}
	
	public ReservaCriteria createReservaCriteria() {
		return new ReservaCriteria(createCriteria("ORM_reserva"));
	}
	
	public Hora_medica_visita_openmrsCriteria createHora_medica_visita_openmrsCriteria() {
		return new Hora_medica_visita_openmrsCriteria(createCriteria("hora_medica_visita_openmrs"));
	}
	
	public Hora_medica_aps_encuentro_openmrsCriteria createHora_medica_aps_encuentro_openmrsCriteria() {
		return new Hora_medica_aps_encuentro_openmrsCriteria(createCriteria("hora_medica_aps_encuentro_openmrs"));
	}
	
	public Hora_medica uniqueHora_medica() {
		return (Hora_medica) super.uniqueResult();
	}
	
	public Hora_medica[] listHora_medica() {
		java.util.List list = super.list();
		return (Hora_medica[]) list.toArray(new Hora_medica[list.size()]);
	}
}

