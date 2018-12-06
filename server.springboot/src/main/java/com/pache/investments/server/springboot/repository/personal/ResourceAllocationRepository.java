/**
 * 
 */
package com.pache.investments.server.springboot.repository.personal;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.personal.Investments;

/**
 * @author lpache
 *
 */
public interface ResourceAllocationRepository extends MongoRepository<Investments, ObjectId> {

}
