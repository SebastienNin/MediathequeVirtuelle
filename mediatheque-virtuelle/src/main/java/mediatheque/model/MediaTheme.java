package mediatheque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MediaTheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="media")
	private Media media;
	@ManyToOne
	@JoinColumn(name="theme")
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
