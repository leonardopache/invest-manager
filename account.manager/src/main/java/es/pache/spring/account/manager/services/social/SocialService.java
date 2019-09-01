/**
 * 
 */
package es.pache.spring.account.manager.services.social;

import es.pache.spring.account.manager.controller.social.response.SocialProfileResponse;

/**
 * @author lmarquespache
 *
 */
public interface SocialService {
	public String createAuthorizationURL();
	public SocialProfileResponse createAccessToken(String code);
}
