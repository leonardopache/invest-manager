package com.pache.investments.server.springboot.model.financemarket;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author lpache
 */
public class ResourceType {

	@Id
	private ObjectId _id;
	private String name;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
