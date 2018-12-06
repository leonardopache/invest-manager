/**
 * 
 */
package com.pache.finance.server.personal;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lpache
 */
public interface PetsRepository extends MongoRepository<Pets, String>{

	Pets findBy_id(ObjectId _id);
}
