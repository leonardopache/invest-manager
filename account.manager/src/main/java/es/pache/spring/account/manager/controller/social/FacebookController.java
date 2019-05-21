/**
 * 
 */
package es.pache.spring.account.manager.controller.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.pache.spring.account.manager.controller.AbstractRegisterAccount;
import es.pache.spring.account.manager.controller.response.ProfileResponse;
import es.pache.spring.account.manager.controller.social.response.SocialProfileResponse;
import es.pache.spring.account.manager.services.social.FacebookService;
import es.pache.spring.account.manager.services.social.SocialService;

/**
 * Facebook Social controller responsible for connect and request account
 * information to register an user.
 * 
 * @author lmarquespache
 *
 */
@RestController
public class FacebookController extends AbstractRegisterAccount {

	@Autowired
	protected FacebookService fbService;

	@Override
	@RequestMapping(value = "/fbAutho")
	public ModelAndView createRegisterInformation() {
		return super.createRegisterInformation();
	}

	@RequestMapping(value = "/register-facebook")
	public ProfileResponse registerWith(@RequestParam("code") String code) {
		return super.registerWith(code);
	}

	@Override
	protected SocialService getService() {
		return fbService;
	}

}
