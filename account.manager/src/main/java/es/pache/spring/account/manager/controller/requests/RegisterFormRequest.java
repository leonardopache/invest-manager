package es.pache.spring.account.manager.controller.requests;

import es.pache.spring.account.manager.model.Profile;

/**
 * Request body to register an user in the application.
 * 
 * @author lmarquespache
 */
public class RegisterFormRequest {

	private String firstName;
	private String email;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile responseToObject() {
		Profile profile = new Profile();
		if (getFirstName() != null)
			profile.setFirstName(getFirstName());
		if (getEmail() != null)
			profile.setEmail(getEmail());
		if (getPassword() != null)
			profile.setPassword(getPassword());
		return profile;
	}
}
