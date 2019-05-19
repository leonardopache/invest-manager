/**
 * 
 */
package es.pache.spring.account.manager.controller.response;

import es.pache.spring.account.manager.model.Profile;

/**
 * Response of only necessary information about the profile.
 * 
 * @author lpache
 */
public class ProfileResponse {

	private String firstName;
	private String lastName;
	private String email;
	private String avatar;
	
	public ProfileResponse(String firstName, String lastName, String email, String avatar) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.avatar = avatar;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public static ProfileResponse toResponse(Profile p) {
		return new ProfileResponse(p.getFirstName(), p.getLastName(), p.getEmail(), p.getAvatar());
	}

}
