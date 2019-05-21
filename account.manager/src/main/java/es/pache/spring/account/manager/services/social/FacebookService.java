/**
 * 
 */
package es.pache.spring.account.manager.services.social;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.pache.spring.account.manager.controller.social.response.FbProfileResponse;
import es.pache.spring.account.manager.controller.social.response.SocialProfileResponse;

/**
 * @author lmarquespache
 *
 */
@Service
public class FacebookService implements SocialService{
	
	@Value("${spring.social.facebook.appId}")
	private String fbAppId;
	@Value("${spring.social.facebook.appSecret}")
	private String fbSecret;
	@Value("${spring.social.facebook.redirectUri}")
	private String fbRedirectUri;
	@Value("${spring.social.facebook.scope}")
	private String fbScope;
	
	private FacebookConnectionFactory connFactory;
	
	public String createAuthorizationURL() {
		connFactory = new FacebookConnectionFactory(fbAppId, fbSecret);
		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		oAuth2Parameters.setRedirectUri(fbRedirectUri);
		oAuth2Parameters.setScope(fbScope);
		return connFactory.getOAuthOperations().buildAuthenticateUrl(oAuth2Parameters);
	}


	public SocialProfileResponse createAccessToken(String code) {
		AccessGrant accessGrant = connFactory.getOAuthOperations().exchangeForAccess(code, fbRedirectUri, null);
	    String accessToken = accessGrant.getAccessToken();
	    FacebookTemplate facebookTemplate = new FacebookTemplate(accessToken);
	    

		String[] fields = { "first_name", "last_name", "middle_name", "cover", "email" };
		String fbJson = facebookTemplate.fetchObject("me", String.class, fields);

		ObjectMapper objectMapper = new ObjectMapper();
		SocialProfileResponse response;
		FbProfileResponse profileResponse = new FbProfileResponse();
		
		try {
			response = objectMapper.readValue(fbJson, FbProfileResponse.class);
			profileResponse.setFirstName(response.getFirstName());
			profileResponse.setLastName(response.getLastName());
			profileResponse.setEmail(response.getEmail());
			profileResponse.setCover(response.getCover());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return profileResponse;
	}

	
}
