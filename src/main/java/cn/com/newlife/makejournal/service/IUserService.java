package cn.com.newlife.makejournal.service;

import java.util.List;

import cn.com.newlife.makejournal.entity.Role;
import cn.com.newlife.makejournal.entity.User;

public interface IUserService {

	/**
	 * 通过id获取用户
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(String id);

	/**
	 * 通过用户名获取用户
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);

	/**
	 * 获取用户权限
	 * 
	 * @param username
	 * @return
	 */
	public List<Role> getRolesByUsername(String username);

}
