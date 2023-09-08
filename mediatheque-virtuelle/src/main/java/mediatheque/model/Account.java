package mediatheque.model;

import java.util.List;

public class Account {

	private String login;
	private String password;
	private String name;
	private String firstName;
	private String mail;
	
	private boolean isAdmin;
	private List<Media> mediaList;

	public Account(String login, String password, String name, String firstName, String mail, boolean isAdmin) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
		this.isAdmin = isAdmin;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getNom() {
		return name;
	}

	public String getPrenom() {
		return firstName;
	}

	public String getMail() {
		return mail;
	}
	
	public List<Media> getMediaList() {
		return mediaList;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNom(String name) {
		this.name = name;
	}

	public void setPrenom(String firstName) {
		this.firstName = firstName;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setListeMedia(List<Media> mediaList) {
		this.mediaList = mediaList;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Account [login=" + login + ", password=" + password + ", name=" + name + ", firstName=" + firstName + ", mail="
				+ mail + ", isAdmin=" + isAdmin + ", mediaList=" + mediaList + "]";
	}
	
}
