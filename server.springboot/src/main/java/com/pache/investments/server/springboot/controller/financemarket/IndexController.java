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

import com.pache.investments.server.springboot.model.financemarket.Index;
import com.pache.investments.server.springboot.repository.financemarket.IndexRepository;


/**
 * @author lpache
 */
@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private IndexRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Index> getAllIndexes() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Index getIndexById(@PathVariable("id") ObjectId id) {
		Optional<Index> resource = repository.findById(id);
		if (resource.isPresent())
			return resource.get();
		else
			throw new RuntimeException("Index not found!!");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyIndexById(@PathVariable("id") ObjectId id,
			@Valid @RequestBody Index resource) {
		resource.set_id(id);
		repository.save(resource);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Index createIndex(@Valid @RequestBody Index resource) {
		resource.set_id(ObjectId.get());
		repository.save(resource);
		return resource;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteIndex(@PathVariable ObjectId id) {
		Optional<Index> resource = repository.findById(id);
		if (resource.isPresent())
			repository.delete(resource.get());
		else
			throw new RuntimeException("Index not found!!");
	}
}
