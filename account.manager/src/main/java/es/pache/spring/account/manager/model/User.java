/**
 * 
 */
package es.pache.spring.account.manager.model;

/**
 * @author lmarquespache
 *
 */
public class User {
	
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
