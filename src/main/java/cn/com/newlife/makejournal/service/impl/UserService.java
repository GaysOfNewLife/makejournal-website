package cn.com.newlife.makejournal.service.impl;

import java.util.List;

import cn.com.newlife.makejournal.dao.ISimpleHibernateDAO;
import cn.com.newlife.makejournal.entity.Role;
import cn.com.newlife.makejournal.entity.User;
import cn.com.newlife.makejournal.service.IUserService;

public class UserService implements IUserService {

	private ISimpleHibernateDAO simpleHibernateDAO;

	public void setSimpleHibernateDAO(ISimpleHibernateDAO simpleHibernateDAO) {
		this.simpleHibernateDAO = simpleHibernateDAO;
	}

	@Override
	public User getUserByUsername(String username) {
		return (User) simpleHibernateDAO.getUniqueResultByHQL("from User where username = ?", username);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Role> getRolesByUsername(String username) {
		return simpleHibernateDAO.findByHQL("select ur.role from UserRole ur where ur.user.username = ?", username);
	}
}
