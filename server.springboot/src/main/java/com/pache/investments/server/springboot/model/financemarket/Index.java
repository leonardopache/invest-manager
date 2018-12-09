/**
 * 
 */
package com.pache.investments.server.springboot.model.financemarket;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author lpache
 *
 */
public class Index implements Serializable{

	private static final long serialVersionUID = -6410496877024783360L;

	@Id
	private ObjectId _id;
	private String name;
	private String code;
	private String resourceTypeId;

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
	public String getResourceTypeId() {
		return resourceTypeId;
	}
	public void setResourceTypeId(String resourceTypeId) {
		this.resourceTypeId = resourceTypeId;
	}
	
	
}
