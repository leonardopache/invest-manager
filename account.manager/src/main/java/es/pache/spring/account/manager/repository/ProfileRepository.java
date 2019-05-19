/**
 * 
 */
package es.pache.spring.account.manager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.pache.spring.account.manager.model.Profile;

/**
 * @author lpache
 *
 */
public interface ProfileRepository extends MongoRepository<Profile, String>{
	
}