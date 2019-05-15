package es.pache.spring.account.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class Application extends WebSecurityConfigurerAdapter {
	
	@RequestMapping(value = "/home")
	public String home() {
		return "Home page!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf()
            .disable()
        .antMatcher("/**")
        .authorizeRequests()
        .antMatchers("/", "/login**", "/webjars/**", "/error**")
            .permitAll()
        .anyRequest()
            .authenticated();
	}
}
