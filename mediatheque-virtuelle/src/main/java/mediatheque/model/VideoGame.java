package mediatheque.model;

import java.time.LocalDate;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "video_game")
public class VideoGame extends Media {
	
	private int pegi;
	private boolean multiPlayer;

	public VideoGame() {
		super();
	}

	public VideoGame(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			int pegi, boolean multiPlayer) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.pegi = pegi;
		this.multiPlayer = multiPlayer;
	}

	public VideoGame(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			int pegi, boolean multiPlayer) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.pegi = pegi;
		this.multiPlayer = multiPlayer;
	}
	
	public int getPegi() {
		return pegi;
	}

	public boolean isMultiPlayer() {
		return multiPlayer;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public void setMultiPlayer(boolean multiPlayer) {
		this.multiPlayer = multiPlayer;
	}

	@Override
	public String toString() {
		return "VideoGame [pegi=" + pegi + ", multiPlayer=" + multiPlayer + "]";
	}


	
}
