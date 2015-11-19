package ar.com.sgt.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ar.com.sgt.dominio.Persona;

public class PersonaDAO {

    private SessionFactory sessionFactory;

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
	List<Persona> personList = session.createQuery(
		"select p  from " + Persona.class.getName() + " p").list();
	session.close();
	return personList;
    }

}
