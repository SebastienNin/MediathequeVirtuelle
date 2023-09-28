package mediatheque.controller.response;


import mediatheque.model.PersonnalizedList;

public class PersoListJoinMediaResponse {
	
	private Integer id;
	private PersonnalizedList persoList;
	private MediaResponse media;
	
	public MediaResponse getMedia() {
		return media;
	}
	public void setMedia(MediaResponse media) {
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
	
	
	
	

}
