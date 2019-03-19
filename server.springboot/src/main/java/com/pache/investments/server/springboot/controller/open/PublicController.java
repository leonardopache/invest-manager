/**
 * 
 */
package com.pache.investments.server.springboot.controller.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pache.investments.server.springboot.controller.request.JoinRequest;
import com.pache.investments.server.springboot.service.personal.UserService;

/**
 * @author lpache
 */
@RestController
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public void join(@RequestBody JoinRequest join) {
		userService.createAccount(join);
	}
	
}
