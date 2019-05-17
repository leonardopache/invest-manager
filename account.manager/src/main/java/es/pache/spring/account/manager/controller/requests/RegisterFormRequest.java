package es.pache.spring.account.manager.controller.requests;
/**
 * Request body to register an user in the application. 
 * 
 * @author lmarquespache
 */
public class RegisterFormRequest {

	private String name;
	private String mail;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
