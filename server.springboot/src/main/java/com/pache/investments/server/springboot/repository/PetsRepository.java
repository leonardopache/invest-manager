/**
 * 
 */
package com.pache.investments.server.springboot.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.Pets;

/**
 * @author lpache
 */
public interface PetsRepository extends MongoRepository<Pets, String>{

	Pets findBy_id(ObjectId _id);
}
