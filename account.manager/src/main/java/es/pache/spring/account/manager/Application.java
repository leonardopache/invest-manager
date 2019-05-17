package es.pache.spring.account.manager;

import java.util.LinkedHashMap;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.pache.spring.account.manager.controller.requests.RegisterFormRequest;
import es.pache.spring.account.manager.model.User;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class Application extends WebSecurityConfigurerAdapter {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping(value = "/home")
	public String home(OAuth2Authentication authentication) {
		LinkedHashMap<String, String> details = (LinkedHashMap<String, String>) authentication.getUserAuthentication().getDetails(); 
		return details.toString();
	}
	
	@RequestMapping(value = "/register-form")
	public User registerForm(@RequestBody RegisterFormRequest registerForm) {
		User user = new User();
		user.setMail(registerForm.getMail());
		user.setName(registerForm.getName());
		user.setPassword(registerForm.getPassword());
		return user;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf()
            .disable()
        .antMatcher("/**")
        .authorizeRequests()
        .antMatchers("/", "/login**", "/webjars/**", "/error**","/register-form**")
            .permitAll()
        .anyRequest()
            .authenticated().and().logout().logoutSuccessUrl("/").permitAll();
	}
	
}
