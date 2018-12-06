/**
 * 
 */
package com.pache.investments.server.springboot.repository.financemarket;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pache.investments.server.springboot.model.financemarket.Index;

/**
 * @author lpache
 *
 */
public interface IndexRepository extends MongoRepository<Index, ObjectId> {

}
