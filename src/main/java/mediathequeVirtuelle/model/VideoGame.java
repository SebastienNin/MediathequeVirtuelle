package mediathequeVirtuelle.model;

import java.time.LocalDate;

public class VideoGame extends Media {

//	private String type;

	private int pegi;

	private boolean multiPlayer;

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

	public VideoGame(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, int pegi, boolean multiPlayer, GameTheme gameTheme) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate);
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
