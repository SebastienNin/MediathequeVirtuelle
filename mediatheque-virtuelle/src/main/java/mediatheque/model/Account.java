package mediatheque.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Version;

@Entity
@JsonView(Views.Common.class)
public class Account {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Version
	private Integer version;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false, unique = true)
	private String password;
	private String name;
	private String firstName;
	private String mail;

	private boolean isAdmin;
	
	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<AccountMedia> accountMediaList = new ArrayList<AccountMedia>();
	
	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<PersonnalizedList> persoLists = new ArrayList<PersonnalizedList>();
	 @PrePersist
	    public void prePersist() {
	        if (version == null) {
	            version = 0; // Vous pouvez initialiser avec n'importe quelle valeur non nulle que vous préférez.
	        }
	    }
	public Account() {
	}

	public Account(Integer id, String login, String password, String name, String firstName, String mail,
			boolean isAdmin) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
		this.isAdmin = isAdmin;
	}

	public Account(String login, String password, String name, String firstName, String mail, boolean isAdmin) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
		this.isAdmin = isAdmin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@JsonProperty("isAdmin")
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<AccountMedia> getAccountMediaList() {
		return accountMediaList;
	}

	public void setAccountMediaList(List<AccountMedia> accountMediaList) {
		this.accountMediaList = accountMediaList;
	}

	public List<PersonnalizedList> getPersoLists() {
		return persoLists;
	}

	public void setPersoLists(List<PersonnalizedList> persoLists) {
		this.persoLists = persoLists;
	}

	@Override
	public String toString() {
		return "Account [login=" + login + ", password=" + password + ", name=" + name + ", firstName=" + firstName
				+ ", mail=" + mail + ", isAdmin=" + isAdmin + "]";
	}



}
