/**
 * 
 */
package com.pache.investments.server.springboot.repository.personal;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.personal.ResourceAllocation;

/**
 * @author lpache
 *
 */
public interface InvestmentsRepository extends MongoRepository<ResourceAllocation, ObjectId> {

}
