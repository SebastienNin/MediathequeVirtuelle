package mediatheque.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "board_game")
@JsonView(Views.BoardGame.class)
@JsonTypeName("boardGame")
public class BoardGame extends Media {

	@Column(name = "player_number")
	private String playerNumber;

	@Column(name = "recommend_age")
	private int recommendendAge;
	private int duration;

	public BoardGame() {
		super();
	}

	public BoardGame(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			String playerNumber, int recommendendAge, int duration) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.playerNumber = playerNumber;
		this.recommendendAge = recommendendAge;
		this.duration = duration;
	}

	public BoardGame(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			String playerNumber, int recommendendAge, int duration) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.playerNumber = playerNumber;
		this.recommendendAge = recommendendAge;
		this.duration = duration;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}


	public int getRecommendendAge() {
		return recommendendAge;
	}

	public int getDuration() {
		return duration;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	public void setRecommendendAge(int recommendendAge) {
		this.recommendendAge = recommendendAge;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "BoardGame [playerNumber=" + playerNumber + ", recommendendAge=" + recommendendAge + ", duration="
				+ duration + "]";
	}


}
