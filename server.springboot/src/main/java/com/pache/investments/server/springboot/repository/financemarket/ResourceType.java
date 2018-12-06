/**
 * 
 */
package com.pache.investments.server.springboot.repository.financemarket;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lpache
 *
 */
public interface ResourceType extends MongoRepository<ResourceType, ObjectId> {

}
