/**
 * 
 */
package com.pache.investments.server.springboot.model.personal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author lpache
 */
public class Users {

	@Id
	private ObjectId _id;
	private String username;
	private String password;
	private String name;

	public Users() {
	}

	public Users(ObjectId _id, String username, String password) {
		this._id = _id;
		this.username = username;
		this.password = password;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
