/**
 * 
 */
package es.pache.spring.account.manager.services.social;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

/**
 * @author lmarquespache
 *
 */
@Service
public class FacebookService {
	
	@Value("${spring.social.facebook.appId}")
	private String fbAppId;
	@Value("${spring.social.facebook.appSecret}")
	private String fbSecret;
	@Value("${spring.social.facebook.redirectUri}")
	private String fbRedirectUri;
	@Value("${spring.social.facebook.scope}")
	private String fbScope;
	
	
	public String createFacebookAuthorizationURL() {
		FacebookConnectionFactory connFactory = new FacebookConnectionFactory(fbAppId, fbSecret);
		OAuth2Operations oAuthOperations = connFactory.getOAuthOperations();
		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		oAuth2Parameters.setRedirectUri(fbRedirectUri);
		oAuth2Parameters.setScope(fbScope);
		return oAuthOperations.buildAuthenticateUrl(oAuth2Parameters);
	}


	public Facebook createFacebookAccessToken(String code) {
		FacebookConnectionFactory connFactory = new FacebookConnectionFactory(fbAppId, fbSecret);
		AccessGrant accessGrant = connFactory.getOAuthOperations().exchangeForAccess(code, fbRedirectUri, null);
	    String accessToken = accessGrant.getAccessToken();
		return new FacebookTemplate(accessToken);
	}

	
}
