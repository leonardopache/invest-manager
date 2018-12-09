/**
 * 
 */
package com.pache.investments.server.springboot.controller.personal;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pache.investments.server.springboot.model.personal.ResourceAllocation;
import com.pache.investments.server.springboot.repository.personal.ResourceAllocationRepository;

/**
 * @author lpache
 */
@RestController
@RequestMapping("/resourceAllocation")
public class ResourceAllocationController {

	@Autowired
	private ResourceAllocationRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ResourceAllocation> getAllResourcesAllocation() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResourceAllocation getResourceAllocationById(@PathVariable("id") ObjectId id) {
		Optional<ResourceAllocation> resource = repository.findById(id);
		if (resource.isPresent())
			return resource.get();
		else
			throw new RuntimeException("Resource Allocation not found!!");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyResourceAllocationById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody ResourceAllocation resource) {
		resource.set_id(id);
		repository.save(resource);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResourceAllocation createResourceAllocation(@Valid @RequestBody ResourceAllocation resource) {
		resource.set_id(ObjectId.get());
		repository.save(resource);
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteResourceAllocation(@PathVariable ObjectId id) {
		Optional<ResourceAllocation> resource = repository.findById(id);
		if (resource.isPresent())
			repository.delete(resource.get());
		else
			throw new RuntimeException("Resource Allocation not found!!");
	}
}
