package com.my.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.my.model.Cookie;

/**
 * A data access object (DAO) providing persistence and search support for
 * Cookie entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.my.dao.Cookie
 * @author MyEclipse Persistence Tools
 */
public class CookieDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(CookieDAO.class);
	// property constants
	public static final String INGREDIENT = "ingredient";
	public static final String NAME = "name";
	public static final String PRICE = "price";

	public void save(Cookie transientInstance) {
		log.debug("saving Cookie instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cookie persistentInstance) {
		log.debug("deleting Cookie instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cookie findById(java.lang.Integer id) {
		log.debug("getting Cookie instance with id: " + id);
		try {
			Cookie instance = (Cookie) getSession()
					.get("com.my.dao.Cookie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cookie instance) {
		log.debug("finding Cookie instance by example");
		try {
			List results = getSession().createCriteria("com.my.dao.Cookie")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cookie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cookie as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIngredient(Object ingredient) {
		return findByProperty(INGREDIENT, ingredient);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all Cookie instances");
		try {
			String queryString = "from Cookie";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cookie merge(Cookie detachedInstance) {
		log.debug("merging Cookie instance");
		try {
			Cookie result = (Cookie) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cookie instance) {
		log.debug("attaching dirty Cookie instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cookie instance) {
		log.debug("attaching clean Cookie instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}