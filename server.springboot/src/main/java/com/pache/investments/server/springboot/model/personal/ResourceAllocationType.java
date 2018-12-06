package com.pache.investments.server.springboot.model.personal;

import com.pache.investments.server.springboot.model.financemarket.ResourceType;

/**
 * @author lpache
 */
public class ResourceAllocationType {

	private ResourceType resourceType;
	private ResourceAllocation resourceAllocation;
	private double percent;

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
