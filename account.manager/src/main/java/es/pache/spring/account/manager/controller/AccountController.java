/**
 * 
 */
package es.pache.spring.account.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.pache.spring.account.manager.controller.requests.RegisterFormRequest;
import es.pache.spring.account.manager.controller.response.ProfileResponse;
import es.pache.spring.account.manager.model.Profile;
import es.pache.spring.account.manager.repository.ProfileRepository;

/**
 * Rest controller responsible for internal account manager services.
 * 
 * @author lpache
 *
 */
@RestController
public class AccountController {

	@Autowired
	protected ProfileRepository profileRepository;

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

}
