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

public class Hora_medica_visita_openmrsDAO {
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadHora_medica_visita_openmrsByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs getHora_medica_visita_openmrsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return getHora_medica_visita_openmrsByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadHora_medica_visita_openmrsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs getHora_medica_visita_openmrsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return getHora_medica_visita_openmrsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Hora_medica_visita_openmrs) session.load(orm.Hora_medica_visita_openmrs.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs getHora_medica_visita_openmrsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Hora_medica_visita_openmrs) session.get(orm.Hora_medica_visita_openmrs.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hora_medica_visita_openmrs) session.load(orm.Hora_medica_visita_openmrs.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs getHora_medica_visita_openmrsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hora_medica_visita_openmrs) session.get(orm.Hora_medica_visita_openmrs.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHora_medica_visita_openmrs(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return queryHora_medica_visita_openmrs(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHora_medica_visita_openmrs(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return queryHora_medica_visita_openmrs(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs[] listHora_medica_visita_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return listHora_medica_visita_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs[] listHora_medica_visita_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return listHora_medica_visita_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHora_medica_visita_openmrs(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Hora_medica_visita_openmrs as Hora_medica_visita_openmrs");
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
	
	public static List queryHora_medica_visita_openmrs(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Hora_medica_visita_openmrs as Hora_medica_visita_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hora_medica_visita_openmrs", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs[] listHora_medica_visita_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHora_medica_visita_openmrs(session, condition, orderBy);
			return (Hora_medica_visita_openmrs[]) list.toArray(new Hora_medica_visita_openmrs[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs[] listHora_medica_visita_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHora_medica_visita_openmrs(session, condition, orderBy, lockMode);
			return (Hora_medica_visita_openmrs[]) list.toArray(new Hora_medica_visita_openmrs[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadHora_medica_visita_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadHora_medica_visita_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Hora_medica_visita_openmrs[] hora_medica_visita_openmrses = listHora_medica_visita_openmrsByQuery(session, condition, orderBy);
		if (hora_medica_visita_openmrses != null && hora_medica_visita_openmrses.length > 0)
			return hora_medica_visita_openmrses[0];
		else
			return null;
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Hora_medica_visita_openmrs[] hora_medica_visita_openmrses = listHora_medica_visita_openmrsByQuery(session, condition, orderBy, lockMode);
		if (hora_medica_visita_openmrses != null && hora_medica_visita_openmrses.length > 0)
			return hora_medica_visita_openmrses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHora_medica_visita_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return iterateHora_medica_visita_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHora_medica_visita_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return iterateHora_medica_visita_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHora_medica_visita_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Hora_medica_visita_openmrs as Hora_medica_visita_openmrs");
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
	
	public static java.util.Iterator iterateHora_medica_visita_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Hora_medica_visita_openmrs as Hora_medica_visita_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hora_medica_visita_openmrs", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs createHora_medica_visita_openmrs() {
		return new orm.Hora_medica_visita_openmrs();
	}
	
	public static boolean save(orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().saveObject(hora_medica_visita_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().deleteObject(hora_medica_visita_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs)throws PersistentException {
		try {
			if(hora_medica_visita_openmrs.getHora_medica() != null) {
				hora_medica_visita_openmrs.getHora_medica().setHora_medica_visita_openmrs(null);
			}
			
			return delete(hora_medica_visita_openmrs);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(hora_medica_visita_openmrs.getHora_medica() != null) {
				hora_medica_visita_openmrs.getHora_medica().setHora_medica_visita_openmrs(null);
			}
			
			try {
				session.delete(hora_medica_visita_openmrs);
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
	
	public static boolean refresh(orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().getSession().refresh(hora_medica_visita_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Hora_medica_visita_openmrs hora_medica_visita_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().getSession().evict(hora_medica_visita_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora_medica_visita_openmrs loadHora_medica_visita_openmrsByCriteria(Hora_medica_visita_openmrsCriteria hora_medica_visita_openmrsCriteria) {
		Hora_medica_visita_openmrs[] hora_medica_visita_openmrses = listHora_medica_visita_openmrsByCriteria(hora_medica_visita_openmrsCriteria);
		if(hora_medica_visita_openmrses == null || hora_medica_visita_openmrses.length == 0) {
			return null;
		}
		return hora_medica_visita_openmrses[0];
	}
	
	public static Hora_medica_visita_openmrs[] listHora_medica_visita_openmrsByCriteria(Hora_medica_visita_openmrsCriteria hora_medica_visita_openmrsCriteria) {
		return hora_medica_visita_openmrsCriteria.listHora_medica_visita_openmrs();
	}
}
