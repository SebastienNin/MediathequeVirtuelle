package mediatheque.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@DiscriminatorValue(value = "board_game")
public class BoardGame extends Media {

	@Column(name = "player_number", nullable = false)
	private String playerNumber;
//	private String type;
	@Column(name = "recommend_age", nullable = false)
	private int recommendendAge;
	@Column(nullable = false)
	private int duration;

	@Transient
	@OneToMany
	private GameTheme gameTheme;

	

//	public BoardGame(String name, String publishingHouse, String language, String image, String description,
//			boolean dematerialized, LocalDate parutionDate, String playerNumber, String type, int recommendendAge,
//			int duration, GameTheme gameTheme) {
//		super(name, publishingHouse, language, image, description, dematerialized, parutionDate);
//		this.playerNumber = playerNumber;
//		this.type = type;
//		this.recommendendAge = recommendendAge;
//		this.duration = duration;
//		this.gameTheme = gameTheme;
//	}

	public BoardGame() {
		super();
	}

	public BoardGame(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			String playerNumber, int recommendendAge, int duration, GameTheme gameTheme) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.playerNumber = playerNumber;
		this.recommendendAge = recommendendAge;
		this.duration = duration;
		this.gameTheme = gameTheme;
	}

	public BoardGame(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			String playerNumber, int recommendendAge, int duration, GameTheme gameTheme) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.playerNumber = playerNumber;
		this.recommendendAge = recommendendAge;
		this.duration = duration;
		this.gameTheme = gameTheme;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}

//	public String getType() {
//		return type;
//	}

	public int getRecommendendAge() {
		return recommendendAge;
	}

	public int getDuration() {
		return duration;
	}

	public GameTheme getGameTheme() {
		return gameTheme;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

//	public void setType(String type) {
//		this.type = type;
//	}

	public void setRecommendendAge(int recommendendAge) {
		this.recommendendAge = recommendendAge;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setGameTheme(GameTheme gameTheme) {
		this.gameTheme = gameTheme;
	}

	@Override
	public String toString() {
		return "BoardGame [playerNumber=" + playerNumber + ", recommendendAge=" + recommendendAge + ", duration="
				+ duration + ", gameTheme=" + gameTheme + "]";
	}

//	@Override
//	public String toString() {
//		return "BoardGame [playerNumber=" + playerNumber + ", type=" + type + ", recommendendAge=" + recommendendAge
//				+ ", duration=" + duration + ", gameTheme=" + gameTheme + "]";
//	}

}