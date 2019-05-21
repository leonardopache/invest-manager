package es.pache.spring.account.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.pache.spring.account.manager.controller.response.ProfileResponse;
import es.pache.spring.account.manager.controller.social.response.SocialProfileResponse;
import es.pache.spring.account.manager.model.Profile;
import es.pache.spring.account.manager.repository.ProfileRepository;
import es.pache.spring.account.manager.services.social.SocialService;

public abstract class AbstractRegisterAccount {
	
	@Autowired
	private ProfileRepository profileRepository;

	protected abstract SocialService getService();
	/*
	 * generate the url to ask for permission to access profile information.
	 */
	//	protected abstract ModelAndView createRegisterInformation();
	protected ModelAndView createRegisterInformation() {
		return new ModelAndView("redirect:" + getService().createAuthorizationURL());
	}

	/*
	 * endpoint callback from social media authorization with token authorization.
	 */
	protected ProfileResponse registerWith(String code) {
		SocialProfileResponse response = getService().createAccessToken(code);
		return ProfileResponse.toResponse(insertNewAccount(response));
	}
	
	protected Profile insertNewAccount(SocialProfileResponse response) {
		Profile p = new Profile();
		p.setFirstName(response.getFirstName());
		p.setLastName(response.getLastName());
		p.setEmail(response.getEmail());
		p.setAvatar(response.getCover());
		return profileRepository.save(p);
	}

}
