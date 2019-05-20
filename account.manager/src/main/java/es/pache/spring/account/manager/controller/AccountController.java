/**
 * 
 */
package es.pache.spring.account.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.pache.spring.account.manager.controller.requests.RegisterFormRequest;
import es.pache.spring.account.manager.controller.response.ProfileResponse;
import es.pache.spring.account.manager.model.Profile;
import es.pache.spring.account.manager.repository.ProfileRepository;
import es.pache.spring.account.manager.services.social.FacebookService;

/**
 * @author lpache
 *
 */
@RestController
public class AccountController {

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	FacebookService fbService;

	@RequestMapping(value="/fbAutho")
	public String createFacebookAuthorization() {
		//redirect to url generated!!
		return fbService.createFacebookAuthorizationURL();
	}
	
	@RequestMapping(value="/register-facebook")
	public void registerWithFacebook(@RequestParam("code") String code) {
		Facebook fbProfile = fbService.createFacebookAccessToken(code);
		
		String[] fields = {"id"};
		String str = fbProfile.fetchObject("me", String.class, fields);
		
		fbProfile.getBaseGraphApiUrl();
		
		
//		fbProfile.userOperations().PROFILE_FIELDSgetUserProfile();
		// Profile p = new Profile();
		// p.setFirstName(details.get("given_name"));
		// p.setLastName(details.get("family_name"));
		// p.setEmail(details.get("email"));
		// p.setAvatar(details.get("picture"));
		// p = profileRepository.save(p);
		// return ProfileResponse.toResponse(p);
	}

	// @RequestMapping(value = "/home")
	// public String home(OAuth2Authentication authentication) {
	// LinkedHashMap<String, String> details = (LinkedHashMap<String, String>)
	// authentication.getUserAuthentication().getDetails();
	// return details.toString();
	// }

	@RequestMapping(method = { RequestMethod.POST }, value = "/register-form")
	public @ResponseBody ProfileResponse registerForm(@RequestBody RegisterFormRequest registerForm) {
		Profile p = registerForm.responseToObject();
		p = profileRepository.save(p);
		return ProfileResponse.toResponse(p);
	}

	// @RequestMapping(method = {RequestMethod.GET}, value = "/register-google")
	// public @ResponseBody ProfileResponse registerGoogle(OAuth2Authentication
	// authentication) {
	// LinkedHashMap<String, String> details = (LinkedHashMap<String, String>)
	// authentication.getUserAuthentication().getDetails();
	// Profile p = new Profile();
	// p.setFirstName(details.get("given_name"));
	// p.setLastName(details.get("family_name"));
	// p.setEmail(details.get("email"));
	// p.setAvatar(details.get("picture"));
	// p = profileRepository.save(p);
	// return ProfileResponse.toResponse(p);
	// }
}
