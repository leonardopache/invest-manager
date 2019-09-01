package es.pache.spring.account.manager.controller.requests;

import org.modelmapper.ModelMapper;

import es.pache.spring.account.manager.model.Profile;

/**
 * request profile representation.
 * 
 * @author lmarquespache
 */
public class ProfileRequest {

	private String firstName;
	private String midleName;
	private String lastName;
	private String email;
	private String password;
	private String avatar;

	private String hometown;
	private String location;
	private String gender;
	private String languages;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidleName() {
		return midleName;
	}

	public void setMidleName(String midleName) {
		this.midleName = midleName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public Profile responseToObject() {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(this, Profile.class);
	}

}
