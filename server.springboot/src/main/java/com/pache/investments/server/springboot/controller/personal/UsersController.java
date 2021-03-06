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

import com.pache.investments.server.springboot.model.personal.User;
import com.pache.investments.server.springboot.repository.personal.UserRepository;

/**
 * @author lpache
 */
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") ObjectId id) {
		Optional<User> user = repository.findById(id);
		return (user.isPresent())? user.get(): null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyUserById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
		user.set_id(id);
		repository.save(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		user.set_id(ObjectId.get());
		repository.save(user);
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable ObjectId id) {
		repository.delete(repository.findById(id).get());
	}
}
