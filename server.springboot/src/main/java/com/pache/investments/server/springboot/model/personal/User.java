/**
 * 
 */
package com.pache.investments.server.springboot.model.personal;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author lpache
 */
@Document(collection="users")
@TypeAlias("users")
public class User implements Serializable{

	private static final long serialVersionUID = 6259295013827626054L;

	@Id
	private ObjectId _id;
	private String username;
	private String password;
	private String name;
	
	public User() {
	}
	
	public User(String _id) {
		this._id = new ObjectId(_id);
	}

	public User(ObjectId _id, String username, String password) {
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
