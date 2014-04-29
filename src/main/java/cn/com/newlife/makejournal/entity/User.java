package cn.com.newlife.makejournal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.newlife.makejournal.utils.IdUtil;

@Entity
@Table(name = "user")
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private boolean enabled;

	public User() {
		super();
		this.id = IdUtil.getUUID();
	}

	public User(String id, String username, String password) {
		this(id, username, password, true);
	}

	public User(String id, String username, String password, boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

}
