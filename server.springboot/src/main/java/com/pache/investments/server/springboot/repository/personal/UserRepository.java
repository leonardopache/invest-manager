/**
 * 
 */
package com.pache.investments.server.springboot.repository.personal;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.personal.User;

/**
 * @author lpache
 *
 */
public interface UserRepository extends MongoRepository<User, ObjectId> {

	User findByUsername(String username);
}
