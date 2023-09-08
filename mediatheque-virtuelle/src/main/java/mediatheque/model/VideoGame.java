package mediatheque.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@DiscriminatorValue(value = "video_game")
public class VideoGame extends Media {

//	private String type;

	@Column(nullable = false)
	private int pegi;
	@Column(nullable = false)
	private boolean multiPlayer;

	@Transient
	@OneToMany
	private GameTheme gameTheme;

//	public VideoGame(String name, String publishingHouse, String language, String image, String description,
//			boolean dematerialized, LocalDate parutionDate, String type, int pegi, boolean multiPlayer,
//			GameTheme gameTheme) {
//		super(name, publishingHouse, language, image, description, dematerialized, parutionDate);
//		this.type = type;
//		this.pegi = pegi;
//		this.multiPlayer = multiPlayer;
//		this.gameTheme = gameTheme;
//	}
//
//	public String getType() {
//		return type;
//	}

	public VideoGame() {
		super();
	}

	public VideoGame(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			int pegi, boolean multiPlayer, GameTheme gameTheme) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.pegi = pegi;
		this.multiPlayer = multiPlayer;
		this.gameTheme = gameTheme;
	}

	public VideoGame(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			int pegi, boolean multiPlayer, GameTheme gameTheme) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.pegi = pegi;
		this.multiPlayer = multiPlayer;
		this.gameTheme = gameTheme;
	}
	
	public int getPegi() {
		return pegi;
	}

	public boolean isMultiPlayer() {
		return multiPlayer;
	}

	public GameTheme getGameTheme() {
		return gameTheme;
	}

//	public void setType(String type) {
//		this.type = type;
//	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public void setMultiPlayer(boolean multiPlayer) {
		this.multiPlayer = multiPlayer;
	}

	public void setGameTheme(GameTheme gameTheme) {
		this.gameTheme = gameTheme;
	}

	@Override
	public String toString() {
		return "VideoGame [pegi=" + pegi + ", multiPlayer=" + multiPlayer + ", gameTheme=" + gameTheme + "]";
	}

//	@Override
//	public String toString() {
//		return "VideoGame [type=" + type + ", pegi=" + pegi + ", multiPlayer=" + multiPlayer + ", gameTheme="
//				+ gameTheme + "]";
//	}
	
}
