package cn.com.newlife.makejournal.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface ISimpleHibernateDAO {

	/**
	 * 新增或更新
	 * 
	 * @param object
	 */
	public void saveOrUpdate(Object object);

	/**
	 * 删除对象
	 * 
	 * @param object
	 */
	public void delete(Object object);

	/**
	 * 删除对象集合
	 * 
	 * @param entities
	 */
	public void deleteAll(Collection entities);

	/**
	 * 通过id获取对象
	 * 
	 * @param c
	 * @param id
	 * @return
	 */
	public Object get(Class c, Serializable id);

	/**
	 * 通过hql获取集合
	 * 
	 * @param hql
	 * @param params
	 *            语句中的参数
	 * @return
	 */
	public List findByHQL(String hql, Object... params);

	/**
	 * 通过hql获取集合
	 * 
	 * @param startRow
	 *            起始行数
	 * @param rowSize
	 *            获取数据条数
	 * @param hql
	 * @param params
	 *            语句中的参数
	 * @return
	 */
	public List findByHQL(int startRow, int rowSize, String hql,
			Object... params);

	/**
	 * 通过hql获取唯一结果
	 * 
	 * @param hql
	 * @param params
	 *            语句中的参数
	 * @return
	 */
	public Object getUniqueResultByHQL(String hql, Object... params);

	/**
	 * 通过sql获取集合
	 * 
	 * @param sql
	 * @param params
	 *            语句中的参数
	 * @return
	 */
	public List findBySQL(String sql, Object... params);

	/**
	 * 通过sql获取集合
	 * 
	 * @param startRow
	 *            起始行数
	 * @param rowSize
	 *            获取数据条数
	 * @param sql
	 * @param params
	 *            语句中的参数
	 * @return
	 */
	public List findBySQL(int startRow, int rowSize, String sql,
			Object... params);

	/**
	 * 通过sql获取唯一结果
	 * 
	 * @param sql
	 * @param params
	 *            语句中的参数
	 * @return
	 */
	public Object getUniqueResultBySQL(String sql, Object... params);

}
