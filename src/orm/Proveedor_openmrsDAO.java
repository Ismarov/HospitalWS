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

public class Proveedor_openmrsDAO {
	public static Proveedor_openmrs loadProveedor_openmrsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadProveedor_openmrsByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs getProveedor_openmrsByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return getProveedor_openmrsByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadProveedor_openmrsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs getProveedor_openmrsByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return getProveedor_openmrsByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Proveedor_openmrs) session.load(orm.Proveedor_openmrs.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs getProveedor_openmrsByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Proveedor_openmrs) session.get(orm.Proveedor_openmrs.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Proveedor_openmrs) session.load(orm.Proveedor_openmrs.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs getProveedor_openmrsByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Proveedor_openmrs) session.get(orm.Proveedor_openmrs.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProveedor_openmrs(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return queryProveedor_openmrs(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProveedor_openmrs(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return queryProveedor_openmrs(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs[] listProveedor_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return listProveedor_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs[] listProveedor_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return listProveedor_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryProveedor_openmrs(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Proveedor_openmrs as Proveedor_openmrs");
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
	
	public static List queryProveedor_openmrs(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Proveedor_openmrs as Proveedor_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Proveedor_openmrs", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs[] listProveedor_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryProveedor_openmrs(session, condition, orderBy);
			return (Proveedor_openmrs[]) list.toArray(new Proveedor_openmrs[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs[] listProveedor_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryProveedor_openmrs(session, condition, orderBy, lockMode);
			return (Proveedor_openmrs[]) list.toArray(new Proveedor_openmrs[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadProveedor_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return loadProveedor_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Proveedor_openmrs[] proveedor_openmrses = listProveedor_openmrsByQuery(session, condition, orderBy);
		if (proveedor_openmrses != null && proveedor_openmrses.length > 0)
			return proveedor_openmrses[0];
		else
			return null;
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Proveedor_openmrs[] proveedor_openmrses = listProveedor_openmrsByQuery(session, condition, orderBy, lockMode);
		if (proveedor_openmrses != null && proveedor_openmrses.length > 0)
			return proveedor_openmrses[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateProveedor_openmrsByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return iterateProveedor_openmrsByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProveedor_openmrsByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = orm.Hospitaldb2PersistentManager.instance().getSession();
			return iterateProveedor_openmrsByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateProveedor_openmrsByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Proveedor_openmrs as Proveedor_openmrs");
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
	
	public static java.util.Iterator iterateProveedor_openmrsByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From orm.Proveedor_openmrs as Proveedor_openmrs");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Proveedor_openmrs", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs createProveedor_openmrs() {
		return new orm.Proveedor_openmrs();
	}
	
	public static boolean save(orm.Proveedor_openmrs proveedor_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().saveObject(proveedor_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(orm.Proveedor_openmrs proveedor_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().deleteObject(proveedor_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Proveedor_openmrs proveedor_openmrs)throws PersistentException {
		try {
			if(proveedor_openmrs.getMedico() != null) {
				proveedor_openmrs.getMedico().setProveedor_openmrs(null);
			}
			
			return delete(proveedor_openmrs);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(orm.Proveedor_openmrs proveedor_openmrs, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(proveedor_openmrs.getMedico() != null) {
				proveedor_openmrs.getMedico().setProveedor_openmrs(null);
			}
			
			try {
				session.delete(proveedor_openmrs);
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
	
	public static boolean refresh(orm.Proveedor_openmrs proveedor_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().getSession().refresh(proveedor_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(orm.Proveedor_openmrs proveedor_openmrs) throws PersistentException {
		try {
			orm.Hospitaldb2PersistentManager.instance().getSession().evict(proveedor_openmrs);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Proveedor_openmrs loadProveedor_openmrsByCriteria(Proveedor_openmrsCriteria proveedor_openmrsCriteria) {
		Proveedor_openmrs[] proveedor_openmrses = listProveedor_openmrsByCriteria(proveedor_openmrsCriteria);
		if(proveedor_openmrses == null || proveedor_openmrses.length == 0) {
			return null;
		}
		return proveedor_openmrses[0];
	}
	
	public static Proveedor_openmrs[] listProveedor_openmrsByCriteria(Proveedor_openmrsCriteria proveedor_openmrsCriteria) {
		return proveedor_openmrsCriteria.listProveedor_openmrs();
	}
}
