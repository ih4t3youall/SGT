package ar.com.sgt.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import ar.com.sgt.persistence.dao.IGenericJpaDao;
import ar.com.sgt.persistence.dao.exception.DaoException;

public class GenericJpaDao<T, K extends Serializable> implements
	IGenericJpaDao<T, K> {

    private Class<T> clazz;

    private EntityManager entityManager;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GenericJpaDao() {
	Type t = getClass().getGenericSuperclass();
	ParameterizedType pt = (ParameterizedType) t;
	clazz = (Class) pt.getActualTypeArguments()[0];

    }

    /**
     * @return the clazz
     */
    public Class<T> getClazz() {
	return clazz;
    }

    /**
     * @param clazz
     *            the clazz to set
     */
    public void setClazz(Class<T> clazz) {
	this.clazz = clazz;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
	return entityManager;
    }

    /**
     * @param entityManager
     *            the entityManager to set
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
	this.entityManager = entityManager;
    }

    /**
     * @return the session
     */
    public Session getSession() {
	return (Session) getEntityManager().getDelegate();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.catused.persistence.shared.dao.IAbstractJpaDao#persist(java.lang.
     * Object)
     */
    @Override
    @Transactional
    public void persist(T entity) throws DaoException {
	try {
	    entityManager.persist(entity);
	} catch (Exception e) {
	    throw new DaoException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.catused.persistence.shared.dao.IAbstractJpaDao#merge(java.lang.Object
     * )
     */
    @Override
    @Transactional
    public void merge(T entity) throws DaoException {
	try {
	    entityManager.merge(entity);
	} catch (Exception e) {
	    throw new DaoException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.catused.persistence.shared.dao.IAbstractJpaDao#remove(java.lang.Object
     * )
     */
    @Override
    @Transactional
    public void remove(final T entity) throws DaoException {
	try {
	    entityManager.remove(entityManager.contains(entity) ? entity
		    : entityManager.merge(entity));
	} catch (Exception e) {
	    throw new DaoException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.catused.persistence.shared.dao.IAbstractJpaDao#findById(java.io.
     * Serializable)
     */
    @Override
    @Transactional
    public T findById(K id) throws DaoException {
	try {
	    return entityManager.find(clazz, id);
	} catch (Exception e) {
	    throw new DaoException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.catused.persistence.shared.dao.IAbstractJpaDao#findAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> findAll() throws DaoException {
	try {
	    return entityManager.createQuery("from " + clazz.getName())
		    .getResultList();
	} catch (Exception e) {
	    throw new DaoException(e);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.catused.persistence.shared.dao.IAbstractJpaDao#deleteById(java.io
     * .Serializable)
     */
    @Override
    @Transactional
    public void deleteById(final K id) throws DaoException {
	try {
	    final T entity = findById(id);
	    remove(entity);
	} catch (Exception e) {
	    throw new DaoException(e);
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.catused.persistence.shared.dao.IAbstractJpaDao#flush()
     */
    @Override
    @Transactional
    public void flush() throws DaoException {
	try {
	    entityManager.flush();
	} catch (Exception e) {
	    throw new DaoException(e);
	}
    }
}