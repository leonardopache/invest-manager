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

import com.pache.investments.server.springboot.model.personal.Investments;
import com.pache.investments.server.springboot.repository.personal.InvestmentsRepository;

/**
 * @author lpache
 */
@RestController
@RequestMapping("/investments")
public class InvestmentsController {

	@Autowired
	private InvestmentsRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Investments> getAllInvestments() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Investments getInvestmentsById(@PathVariable("id") ObjectId id) {
		Optional<Investments> investments = repository.findById(id);
		return (investments.isPresent())? investments.get(): null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyInvestmentsById(@PathVariable("id") ObjectId id, @Valid @RequestBody Investments investments) {
		investments.set_id(id);
		repository.save(investments);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Investments createInvestments(@Valid @RequestBody Investments investments) {
		investments.set_id(ObjectId.get());
		repository.save(investments);
		return investments;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteInvestments(@PathVariable ObjectId id) {
		repository.delete(repository.findById(id).get());
	}
}
