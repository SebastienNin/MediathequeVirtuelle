package mediatheque.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class PersonnalizedList {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String name;
	@Transient
	private Account account;
	@Transient
	List<Media> mediaList;
	
	public PersonnalizedList() {
		// TODO Auto-generated constructor stub
	}
	public PersonnalizedList(Integer id, String name, Account account) {
		this.id = id;
		this.name = name;
		this.account = account;
	
	}
	public PersonnalizedList(String name, Account account) {
	
		this.name = name;
		this.account = account;
	
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Media> getMediaList() {
		return mediaList;
	}
	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}
	
	
}
