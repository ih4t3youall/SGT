package ar.com.sgt.persistence.dao;

import java.io.Serializable;
import java.util.List;

import ar.com.sgt.persistence.dao.exception.DaoException;

/**
 * The Interface IGenericDao.
 * 
 * @param <T>
 *            the generic type
 * @param <K>
 *            the key type
 * 
 * @author sebastian.a.coria
 * 
 */
public interface IGenericJpaDao<T, K extends Serializable> {

    public class PaginationParams {

	int pageSize;
	int pageNumber;

	public PaginationParams(int pageSize, int pageNumber) {

	    this.pageSize = pageSize;
	    this.pageNumber = pageNumber;
	}

	public int getPageSize() {
	    return pageSize;
	}

	public int getPageNumber() {
	    return pageNumber;
	}

	public int getFirstResult() {
	    return pageSize * (pageNumber - 1);
	}

	public int getMaxResults() {
	    return pageNumber * pageSize;
	}
    }

    public enum OrderName {
	ASC, DESC
    }

    OrderName DEFAULT_SORT_DIRECTION = OrderName.ASC;

    /**
     * Persist.
     * 
     * @param entity
     */
    void persist(T entity) throws DaoException;

    /**
     * Merge.
     * 
     * @param entity
     */
    void merge(T entity) throws DaoException;

    /**
     * Delete.
     * 
     * @param entity
     *            the entity
     */
    void remove(T entity) throws DaoException;

    /**
     * Load by id.
     * 
     * @param id
     *            the id
     * @return the t
     */
    T findById(K id) throws DaoException;

    /**
     * Load all.
     * 
     * @return the list
     */
    List<T> findAll() throws DaoException;

    /**
     * Delete by id
     * 
     * @param id
     */
    void deleteById(final K id) throws DaoException;

    /**
     * Flushes the session
     */
    void flush() throws DaoException;
}
