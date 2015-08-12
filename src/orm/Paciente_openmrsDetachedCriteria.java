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

public class Paciente_openmrsDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression uuid;
	public final IntegerExpression pacienteId;
	public final AssociationExpression paciente;
	
	public Paciente_openmrsDetachedCriteria() {
		super(orm.Paciente_openmrs.class, orm.Paciente_openmrsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		pacienteId = new IntegerExpression("paciente.id", this.getDetachedCriteria());
		paciente = new AssociationExpression("paciente", this.getDetachedCriteria());
	}
	
	public Paciente_openmrsDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, orm.Paciente_openmrsCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		uuid = new StringExpression("uuid", this.getDetachedCriteria());
		pacienteId = new IntegerExpression("paciente.id", this.getDetachedCriteria());
		paciente = new AssociationExpression("paciente", this.getDetachedCriteria());
	}
	
	public PacienteDetachedCriteria createPacienteCriteria() {
		return new PacienteDetachedCriteria(createCriteria("paciente"));
	}
	
	public Paciente_openmrs uniquePaciente_openmrs(PersistentSession session) {
		return (Paciente_openmrs) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Paciente_openmrs[] listPaciente_openmrs(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Paciente_openmrs[]) list.toArray(new Paciente_openmrs[list.size()]);
	}
}

