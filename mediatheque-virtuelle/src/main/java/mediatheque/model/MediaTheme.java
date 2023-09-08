package mediatheque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class MediaTheme {

	@ManyToOne
	@Transient
	private Media media;
	@ManyToOne
	@Transient
	private Theme theme;
	
	public MediaTheme() {
		// TODO Auto-generated constructor stub
	}

	public MediaTheme(Media media, Theme theme) {
		super();
		this.media = media;
		this.theme = theme;
	}

	public Media getMedia() {
		return media;
	}

	public void setMedia(Media media) {
		this.media = media;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "MediaTheme [media=" + media + ", theme=" + theme + "]";
	}
	
}
