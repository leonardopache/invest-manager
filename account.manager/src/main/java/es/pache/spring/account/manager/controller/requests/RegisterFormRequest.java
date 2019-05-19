package es.pache.spring.account.manager.controller.requests;

import es.pache.spring.account.manager.model.Profile;

/**
 * Request body to register an user in the application.
 * 
 * @author lmarquespache
 */
public class RegisterFormRequest {

	private String firstname;
	private String lastname;
	private String email;
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
		if(getFirstname() != null)
			profile.setFirstName(getFirstname());
		if(getLastname() != null)
			profile.setLastName(getLastname());
		if(getEmail() != null)
			profile.setEmail(getEmail());
		if(getPassword() != null)
			profile.setPassword(getPassword());
		return profile;
	}
}
