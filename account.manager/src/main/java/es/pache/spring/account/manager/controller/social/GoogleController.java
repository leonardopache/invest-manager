/**
 * 
 */
package es.pache.spring.account.manager.controller.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.pache.spring.account.manager.controller.response.ProfileResponse;
import es.pache.spring.account.manager.services.social.GoogleService;
import es.pache.spring.account.manager.services.social.SocialService;

/**
 * Google Social controller responsible for connect and request account
 * information to register an user.
 * 
 * @author lmarquespache
 *
 */
@RestController
public class GoogleController extends AbstractSocialRegisterAccount {
	
	@Autowired
	protected GoogleService googleService;

	@Override
	@RequestMapping(method = { RequestMethod.GET }, value = "/googleAutho")
	public ModelAndView createRegisterInformation() {
		return super.createRegisterInformation();
	}

	@Override
	@RequestMapping(method = { RequestMethod.GET }, value = "/register-google")
	public ProfileResponse registerWith(@RequestParam("code") String code) {
		return super.registerWith(code);
	}

	@Override
	protected SocialService getService() {
		return googleService;
	}

}
