/**
 * 
 */
package es.pache.spring.account.manager;

import static org.junit.Assert.fail;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * All test related with Login and Logout user.
 * 
 * tutorial: https://www.codementor.io/gtommee97/rest-authentication-with-spring-security-and-mongodb-j8wgh8kg7
 * 
 * @author lmarquespache
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationUserTest {
	
	public void login_success() {
		fail();
	}
	
	public void login_error() {
		fail();
	}	
	
	public void logout_success() {
		fail();
	}
	
	public void logout_error() {
		fail();
	}

	
}
