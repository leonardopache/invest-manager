/**
 * 
 */
package com.pache.investments.server.springboot.model.personal;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author lpache
 */
@Document(collection="resourceAllocation")
@TypeAlias("resourceAllocation")
public class ResourceAllocation implements Serializable {

	private static final long serialVersionUID = 4619313799306677790L;

	@Id
	private ObjectId _id;
	private String name;
	@DBRef
	private User user;
	@DBRef
	private List<ResourceAllocationType> allocationTypeList;

	public ResourceAllocation() {
	}

	public ResourceAllocation(ObjectId _id, String name, User user, List<ResourceAllocationType> allocationTypeList) {
		this._id = _id;
		this.name = name;
		this.user = user;
		this.allocationTypeList = allocationTypeList;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ResourceAllocationType> getAllocationTypeList() {
		return allocationTypeList;
	}

	public void setAllocationTypeList(List<ResourceAllocationType> allocationTypeList) {
		this.allocationTypeList = allocationTypeList;
	}

}
