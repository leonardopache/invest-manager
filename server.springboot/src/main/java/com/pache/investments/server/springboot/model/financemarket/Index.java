/**
 * 
 */
package com.pache.investments.server.springboot.model.financemarket;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author lpache
 *
 */
public class Index {

	@Id
	private ObjectId _id;
	private String name;
	private String code;
	private ResourceType resourceType;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

}
