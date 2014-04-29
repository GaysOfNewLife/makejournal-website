package cn.com.newlife.makejournal.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.com.newlife.makejournal.dao.ISimpleHibernateDAO;

public class SimpleHibernateDAO implements ISimpleHibernateDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Object object) {
		getSession().saveOrUpdate(object);
	}

	@Override
	public void delete(Object object) {
		getSession().delete(object);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void deleteAll(Collection entities) {
		Iterator it = entities.iterator();
		while (it.hasNext()) {
			delete(it.next());
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object get(Class c, Serializable id) {
		return getSession().get(c, id);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findByHQL(String hql, Object... params) {
		return getResults(getSession().createQuery(hql), params);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findByHQL(int startRow, int rowSize, String hql,
			Object... params) {
		return getResults(getSession().createQuery(hql)
				.setFirstResult(startRow).setMaxResults(rowSize), params);
	}

	@Override
	public Object getUniqueResultByHQL(String hql, Object... params) {
		return getUniqueResult(getSession().createQuery(hql), params);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findBySQL(String sql, Object... params) {
		return getResults(getSession().createSQLQuery(sql), params);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List findBySQL(int startRow, int rowSize, String sql,
			Object... params) {
		return getResults(
				getSession().createSQLQuery(sql).setFirstResult(startRow)
						.setMaxResults(rowSize), params);
	}

	@Override
	public Object getUniqueResultBySQL(String sql, Object... params) {
		return getUniqueResult(getSession().createSQLQuery(sql), params);
	}

	@SuppressWarnings("rawtypes")
	private List getResults(Query query, Object... params) {
		return setParamsToQuery(query, params).list();
	}

	private Object getUniqueResult(Query query, Object... params) {
		return setParamsToQuery(query, params).uniqueResult();
	}

	private Query setParamsToQuery(Query query, Object... params) {
		if (params != null)
			for (int i = 0; i < params.length; i++)
				query.setParameter(i, params[i]);
		return query;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
