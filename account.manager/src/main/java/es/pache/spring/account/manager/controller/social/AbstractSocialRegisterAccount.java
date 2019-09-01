package es.pache.spring.account.manager.controller.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import es.pache.spring.account.manager.controller.response.ProfileResponse;
import es.pache.spring.account.manager.controller.social.response.SocialProfileResponse;
import es.pache.spring.account.manager.model.Profile;
import es.pache.spring.account.manager.repository.ProfileRepository;
import es.pache.spring.account.manager.services.social.SocialService;

/**
 * Abstract implementation for social token and profile information requests.
 * 
 * @author lmarquespache
 */
public abstract class AbstractSocialRegisterAccount {

	@Autowired
	protected ProfileRepository profileRepository;

	protected abstract SocialService getService();

	/*
	 * generate the url to ask for permission to access profile information.
	 */
	protected ModelAndView createRegisterInformation() throws RuntimeException {
		return new ModelAndView("redirect:" + getService().createAuthorizationURL());
	}

	/*
	 * endpoint callback from social media authorization with token authorization.
	 */
	protected ProfileResponse registerWith(String code) throws RuntimeException {
		SocialProfileResponse response = getService().createAccessToken(code);
		
		Profile profile = insertNewAccount(response);
		return ProfileResponse.toResponse(profile);
	}

	private Profile insertNewAccount(SocialProfileResponse response) {
		Profile p = new Profile();
		p.setFirstName(response.getFirstName());
		p.setLastName(response.getLastName());
		p.setEmail(response.getEmail());
		p.setAvatar(response.getCover());
		return profileRepository.save(p);
	}

}
