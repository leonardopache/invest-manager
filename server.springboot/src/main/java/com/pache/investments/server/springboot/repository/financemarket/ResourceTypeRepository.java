/**
 * 
 */
package com.pache.investments.server.springboot.repository.financemarket;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.financemarket.ResourceType;


/**
 * @author lpache
 *
 */
public interface ResourceTypeRepository extends MongoRepository<ResourceType, ObjectId> {

	
}
