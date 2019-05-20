/**
 * 
 */
package es.pache.spring.account.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/fbAutho")
	public ModelAndView createFacebookAuthorization() {
		return new ModelAndView("redirect:" + fbService.createFacebookAuthorizationURL());
	}

	@RequestMapping(value = "/register-facebook")
	public String registerWithFacebook(@RequestParam("code") String code) {
		Facebook fbProfile = fbService.createFacebookAccessToken(code);

		String[] fields = { "locale", "location", "languages", "age_range", "hometown", "first_name", "last_name",
				"middle_name", "name", "picture", "email" };
		// "id", "about", , , "context", "cover", "currency", "devices", "education",
		// "email",
		// "favorite_athletes", "favorite_teams", "first_name", "gender",
		// "inspirational_people", "installed", "install_type",
		// "is_verified", "languages", "last_name", "link", "locale", "location",
		// "meeting_for", "middle_name", "name", "name_format",
		// "political", "quotes", "payment_pricepoints", "relationship_status",
		// "religion", "security_settings", "significant_other",
		// "sports", "test_group", "timezone", "third_party_id", "updated_time",
		// "verified", "video_upload_limits", "viewer_can_send_gift",
		// "website", "work"
		
		String str = fbProfile.fetchObject("me", String.class, fields);

		// fbProfile.userOperations().PROFILE_FIELDS
		// Profile p = new Profile();
		// p.setFirstName(details.get("given_name"));
		// p.setLastName(details.get("family_name"));
		// p.setEmail(details.get("email"));
		// p.setAvatar(details.get("picture"));
		// p = profileRepository.save(p);
		// return ProfileResponse.toResponse(p);
		return str;
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
