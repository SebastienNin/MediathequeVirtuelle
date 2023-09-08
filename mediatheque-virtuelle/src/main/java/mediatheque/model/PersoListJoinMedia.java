package mediatheque.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PersoListJoinMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="persoList")
	private PersonnalizedList persoList;
	
	@ManyToOne
	@JoinColumn(name="media")
	private Media media;
	
	public PersoListJoinMedia() {
		// TODO Auto-generated constructor stub
	}

	public PersoListJoinMedia(Integer id, PersonnalizedList persoList, Media media) {
		this.id = id;
		this.persoList = persoList;
		this.media = media;
	}

	public PersoListJoinMedia(PersonnalizedList persoList, Media media) {
		this.persoList = persoList;
		this.media = media;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PersonnalizedList getPersoList() {
		return persoList;
	}

	public void setPersoList(PersonnalizedList persoList) {
		this.persoList = persoList;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}
	
	

}
