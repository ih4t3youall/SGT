package ar.com.sgt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ar.com.sgt.dominio.Persona;

public class PersonaDAO {

	
	 private SessionFactory sessionFactory;
	 
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	     
	    
	    public void save(Persona p) {
	        Session session = this.sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.persist(p);
	        tx.commit();
	        session.close();
	    }
	 
	    @SuppressWarnings("unchecked")
	    
	    public List<Persona> list() {
	        Session session = this.sessionFactory.openSession();
	        List<Persona> personList = session.createQuery("from persona").list();
	        session.close();
	        return personList;
	    }
	
}
