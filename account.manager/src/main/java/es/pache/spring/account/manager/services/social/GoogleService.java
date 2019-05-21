/**
 * 
 */
package es.pache.spring.account.manager.services.social;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import es.pache.spring.account.manager.controller.social.response.GoogleProfileResponse;
import es.pache.spring.account.manager.controller.social.response.SocialProfileResponse;

/**
 * @author lmarquespache
 *
 */
@Service
public class GoogleService implements SocialService{
	
	@Value("${spring.social.google.clientId}")
	private String googleClientId;
	@Value("${spring.social.google.clientSecret}")
	private String googleClientSecret;
	@Value("${spring.social.google.redirectUri}")
	private String googleRedirectUri;
	@Value("${spring.social.google.scope}")
	private String googleScope;
	
	private GoogleConnectionFactory connFactory;
	
	
	public String createAuthorizationURL() {
		connFactory = new GoogleConnectionFactory(googleClientId, googleClientSecret);
		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		oAuth2Parameters.setRedirectUri(googleRedirectUri);
		oAuth2Parameters.setScope(googleScope);
		return connFactory.getOAuthOperations().buildAuthenticateUrl(oAuth2Parameters);
	}


	public SocialProfileResponse createAccessToken(String code) {
		AccessGrant accessGrant = connFactory.getOAuthOperations().exchangeForAccess(code, googleRedirectUri, null);
		Connection<Google> conn = connFactory.createConnection(accessGrant);
		UserProfile user = conn.fetchUserProfile();
		
		GoogleProfileResponse profileResponse = new GoogleProfileResponse();
		profileResponse.setFirstName(user.getFirstName());
		profileResponse.setLastName(user.getLastName());
		profileResponse.setEmail(user.getEmail());
		profileResponse.setCover(conn.getImageUrl());
		return profileResponse;
	}

	
}
