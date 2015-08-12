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

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class Paciente_openmrsDAO {
	public static Paciente_openmrs loadPaciente_openmrsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadPaciente_openmrsByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs getPaciente_openmrsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return getPaciente_openmrsByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadPaciente_openmrsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs getPaciente_openmrsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return getPaciente_openmrsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Paciente_openmrs) session.load(orm.Paciente_openmrs.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs getPaciente_openmrsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Paciente_openmrs) session.get(orm.Paciente_openmrs.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Paciente_openmrs) session.load(orm.Paciente_openmrs.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs getPaciente_openmrsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Paciente_openmrs) session.get(orm.Paciente_openmrs.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaciente_openmrs(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return queryPaciente_openmrs(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaciente_openmrs(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return queryPaciente_openmrs(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs[] listPaciente_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return listPaciente_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs[] listPaciente_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return listPaciente_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaciente_openmrs(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Paciente_openmrs as Paciente_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPaciente_openmrs(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Paciente_openmrs as Paciente_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Paciente_openmrs", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs[] listPaciente_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPaciente_openmrs(session, condition, orderBy);
			return (Paciente_openmrs[]) list.toArray(new Paciente_openmrs[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs[] listPaciente_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPaciente_openmrs(session, condition, orderBy, lockMode);
			return (Paciente_openmrs[]) list.toArray(new Paciente_openmrs[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadPaciente_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadPaciente_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Paciente_openmrs[] paciente_openmrses = listPaciente_openmrsByQuery(session, condition, orderBy);
		if (paciente_openmrses != null && paciente_openmrses.length > 0)
			return paciente_openmrses[0];
		else
			return null;
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Paciente_openmrs[] paciente_openmrses = listPaciente_openmrsByQuery(session, condition, orderBy, lockMode);
		if (paciente_openmrses != null && paciente_openmrses.length > 0)
			return paciente_openmrses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePaciente_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return iteratePaciente_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePaciente_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return iteratePaciente_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePaciente_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Paciente_openmrs as Paciente_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePaciente_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Paciente_openmrs as Paciente_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Paciente_openmrs", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs createPaciente_openmrs() {
		return new orm.Paciente_openmrs();
	}
	
	public static boolean save(orm.Paciente_openmrs paciente_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().saveObject(paciente_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Paciente_openmrs paciente_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().deleteObject(paciente_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Paciente_openmrs paciente_openmrs)throws PersistentException {
		try {
			if(paciente_openmrs.getPaciente() != null) {
				paciente_openmrs.getPaciente().setPaciente_openmrs(null);
			}
			
			return delete(paciente_openmrs);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Paciente_openmrs paciente_openmrs, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(paciente_openmrs.getPaciente() != null) {
				paciente_openmrs.getPaciente().setPaciente_openmrs(null);
			}
			
			try {
				session.delete(paciente_openmrs);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(orm.Paciente_openmrs paciente_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().getSession().refresh(paciente_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Paciente_openmrs paciente_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().getSession().evict(paciente_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Paciente_openmrs loadPaciente_openmrsByCriteria(Paciente_openmrsCriteria paciente_openmrsCriteria) {
		Paciente_openmrs[] paciente_openmrses = listPaciente_openmrsByCriteria(paciente_openmrsCriteria);
		if(paciente_openmrses == null || paciente_openmrses.length == 0) {
			return null;
		}
		return paciente_openmrses[0];
	}
	
	public static Paciente_openmrs[] listPaciente_openmrsByCriteria(Paciente_openmrsCriteria paciente_openmrsCriteria) {
		return paciente_openmrsCriteria.listPaciente_openmrs();
	}
}
