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

public class Paciente_openmrsCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression uuid;
	public final IntegerExpression pacienteId;
	public final AssociationExpression paciente;
	
	public Paciente_openmrsCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		uuid = new StringExpression("uuid", this);
		pacienteId = new IntegerExpression("paciente.id", this);
		paciente = new AssociationExpression("paciente", this);
	}
	
	public Paciente_openmrsCriteria(PersistentSession session) {
		this(session.createCriteria(Paciente_openmrs.class));
	}
	
	public Paciente_openmrsCriteria() throws PersistentException {
		this(orm.Hospitaldb2PersistentManager.instance().getSession());
	}
	
	public PacienteCriteria createPacienteCriteria() {
		return new PacienteCriteria(createCriteria("paciente"));
	}
	
	public Paciente_openmrs uniquePaciente_openmrs() {
		return (Paciente_openmrs) super.uniqueResult();
	}
	
	public Paciente_openmrs[] listPaciente_openmrs() {
		java.util.List list = super.list();
		return (Paciente_openmrs[]) list.toArray(new Paciente_openmrs[list.size()]);
	}
}

