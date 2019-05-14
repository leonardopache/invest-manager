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
 * All test related with register a new account.
 * 
 * tutorial: https://www.callicoder.com/spring-boot-security-oauth2-social-login-part-1/
 * 
 * @author lmarquespache
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterAccountTest {
	
	public void create_new_account_by_form() {
		fail();
	}
	
	public void create_new_account_by_google() {
		fail();
	}	
	
	public void create_new_account_by_fb() {
		fail();
	}
	
	//TODO[register] test to register errors.
	
}
