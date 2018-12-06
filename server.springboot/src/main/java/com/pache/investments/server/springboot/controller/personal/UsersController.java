/**
 * 
 */
package com.pache.investments.server.springboot.controller.personal;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pache.investments.server.springboot.model.personal.Users;
import com.pache.investments.server.springboot.repository.personal.UsersRepository;

/**
 * @author lpache
 */
@ControllerAdvice
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersRepository repository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Users> getAllUsers() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Users getPetById(@PathVariable("id") ObjectId id) {
		Optional<Users> user = repository.findById(id);
		return (user.isPresent())? user.get(): null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Users user) {
		user.set_id(id);
		repository.save(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Users createPet(@Valid @RequestBody Users users) {
		users.set_id(ObjectId.get());
		repository.save(users);
		return users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.delete(repository.findById(id).get());
	}
}
