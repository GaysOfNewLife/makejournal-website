package cn.com.newlife.makejournal.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.com.newlife.makejournal.entity.Role;
import cn.com.newlife.makejournal.entity.User;
import cn.com.newlife.makejournal.service.IUserService;

public class MyUserDetailServiceImpl implements UserDetailsService {

	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		System.out.println("---------MyUserDetailServiceImpl:loadUserByUsername------正在加载用户名和密码，用户名为：" + username);

		User user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("用户名没有找到!");
		}

		boolean enabled = true; // 是否可用
		boolean accountNonExpired = true; // 是否过期
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		// 如果你使用资源和权限配置在xml文件中，如：<intercept-url pattern="/user/admin"
		// access="hasRole('ROLE_ADMIN')"/>；
		// 并且也不想用数据库存储，所有用户都具有相同的权限的话，你可以手动保存角色(如：预订网站)。
		// authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		for (Role role : userService.getRolesByUsername(username)) {
			GrantedAuthority ga = new GrantedAuthorityImpl(role.getName());
			authorities.add(ga);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

}
