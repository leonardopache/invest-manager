/**
 * 
 */
package com.pache.investments.server.springboot.model.personal;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author lpache
 */
public class ResourceAllocation {

	@Id
	private ObjectId _id;
	private String name;
	private Users user;
	private List<ResourceAllocationType> allocationTypeList;

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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<ResourceAllocationType> getAllocationTypeList() {
		return allocationTypeList;
	}

	public void setAllocationTypeList(List<ResourceAllocationType> allocationTypeList) {
		this.allocationTypeList = allocationTypeList;
	}

}
