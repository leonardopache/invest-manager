/**
 * 
 */
package es.pache.spring.account.manager;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.pache.spring.account.manager.controller.requests.RegisterFormRequest;

/**
 * All test related with register a new account.
 * 
 * tutorial:
 * https://www.callicoder.com/spring-boot-security-oauth2-social-login-part-1/
 * 
 * @author lmarquespache
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegisterAccountTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void create_new_account_by_form() throws Exception {
		RegisterFormRequest filled_form = fill_register_form();
		String body = objectToJson(filled_form);

		MvcResult result = this.mockMvc
				.perform(post("/register-form").contentType(MediaType.APPLICATION_JSON).content(body)).andDo(print())
				.andExpect(status().isOk()).andReturn();
	}

	private String objectToJson(Object filled_form) throws IOException, JsonGenerationException, JsonMappingException {
		ObjectMapper obj = new ObjectMapper();
		return obj.writeValueAsString(filled_form);
	}

	private RegisterFormRequest fill_register_form() {
		RegisterFormRequest formRequest = new RegisterFormRequest();
		formRequest.setEmail("teste@test.com");
		formRequest.setFirstname("Unit Tes");
		formRequest.setPassword("MD5password");
		return formRequest;
	}

	public void create_new_account_by_google() {
	}

	public void create_new_account_by_fb() {
	}

	// TODO[register] test to register errors.

}
