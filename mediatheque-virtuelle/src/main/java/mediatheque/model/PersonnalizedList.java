package mediatheque.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonView(Views.Common.class)
public class PersonnalizedList {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column(nullable = false)
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="account")
	@JsonView(Views.PersonnalizedList.class)
	private Account account;
	
	@OneToMany(mappedBy = "persoList")
	@JsonIgnore //pour le moment après @JsonView(Views.PersoListWithMedia.class) probablement 
	private List<PersoListJoinMedia> mediaList = new ArrayList<PersoListJoinMedia>();
	
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
	public List<PersoListJoinMedia> getMediaList() {
		return mediaList;
	}
	public void setMediaList(List<PersoListJoinMedia> mediaList) {
		this.mediaList = mediaList;
	}
	public void setAccount(Optional<Account> account2) {
		// TODO Auto-generated method stub
		
	}

	
}
