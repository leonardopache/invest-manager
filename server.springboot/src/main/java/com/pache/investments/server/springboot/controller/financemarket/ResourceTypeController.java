/**
 * 
 */
package com.pache.investments.server.springboot.controller.financemarket;

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

import com.pache.investments.server.springboot.model.financemarket.ResourceType;
import com.pache.investments.server.springboot.repository.financemarket.ResourceTypeRepository;


/**
 * @author lpache
 */
@RestController
@RequestMapping("/resourceType")
public class ResourceTypeController {

	@Autowired
	private ResourceTypeRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<ResourceType> getAllResourcesType() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResourceType getResourceTypeById(@PathVariable("id") ObjectId id) {
		Optional<ResourceType> resource = repository.findById(id);
		if (resource.isPresent())
			return resource.get();
		else
			throw new RuntimeException("Resource Type not found!!");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyResourceTypeById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody ResourceType resource) {
		resource.set_id(id);
		repository.save(resource);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResourceType createResourceType(@Valid @RequestBody ResourceType resource) {
		resource.set_id(ObjectId.get());
		repository.save(resource);
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteResourceType(@PathVariable ObjectId id) {
		Optional<ResourceType> resource = repository.findById(id);
		if (resource.isPresent())
			repository.delete(resource.get());
		else
			throw new RuntimeException("Resource Type not found!!");
	}
}
