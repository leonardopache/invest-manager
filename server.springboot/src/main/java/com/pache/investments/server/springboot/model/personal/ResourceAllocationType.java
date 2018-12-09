package com.pache.investments.server.springboot.model.personal;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.pache.investments.server.springboot.model.financemarket.ResourceType;

/**
 * @author lpache
 */
public class ResourceAllocationType implements Serializable{

	private static final long serialVersionUID = -6405808106596184057L;

	@DBRef
	private ResourceType resourceType;
	@DBRef
	private ResourceAllocation resourceAllocation;
	private double percent;

	public ResourceAllocationType(ResourceType resourceType, ResourceAllocation resourceAllocation, double percent) {
		this.resourceType = resourceType;
		this.resourceAllocation = resourceAllocation;
		this.percent = percent;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public ResourceAllocation getResourceAllocation() {
		return resourceAllocation;
	}

	public void setResourceAllocation(ResourceAllocation resourceAllocation) {
		this.resourceAllocation = resourceAllocation;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

}
