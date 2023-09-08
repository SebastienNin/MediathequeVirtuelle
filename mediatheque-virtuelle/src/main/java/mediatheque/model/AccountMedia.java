package mediatheque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class AccountMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="account")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name="media")
	private Media media;

	
	public AccountMedia() {
	}
	
	public AccountMedia(Integer id, Account account, Media media) {
		this.id = id;
		this.account = account;
		this.media = media;
	}
	
	public AccountMedia( Account account, Media media) {
		this.account = account;
		this.media = media;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "AccountMedia [id=" + id + ", account=" + account + ", media=" + media + "]";
	}

}
