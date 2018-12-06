/**
 * 
 */
package com.pache.investments.server.springboot.repository.personal;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.personal.Users;

/**
 * @author lpache
 *
 */
public interface UsersRepository extends MongoRepository<Users, ObjectId> {

	Users findByUsername(String username);
}
