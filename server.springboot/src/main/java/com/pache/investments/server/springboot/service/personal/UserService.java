package com.pache.investments.server.springboot.service.personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pache.investments.server.springboot.controller.request.JoinRequest;
import com.pache.investments.server.springboot.exception.EmailError;
import com.pache.investments.server.springboot.model.personal.User;
import com.pache.investments.server.springboot.repository.personal.UserRepository;
import com.pache.investments.server.springboot.util.SendMailUtil;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createAccount(JoinRequest join) {
		User user = join.toEntity();
		userRepository.save(user);
		try {
			SendMailUtil.sendByTLS(user.getUsername(), "Welcome to the new world!!", user.toString(), null);
		} catch (EmailError e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
