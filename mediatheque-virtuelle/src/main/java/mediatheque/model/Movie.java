package mediatheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;

@Entity
@DiscriminatorValue("movie")
@JsonView(Views.MovieView.class)
public class Movie extends Media {

    @ElementCollection
    @CollectionTable(name = "movie_directors", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "director")	
	private List<String> directors = new ArrayList<String>();
    @ElementCollection
    @CollectionTable(name = "movie_actors", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "actor")
	private List<String> actors = new ArrayList<String>();

	private int duration;

	@Enumerated(EnumType.STRING)
	@Column(name = "movie_support")
	private MovieSupport movieSupport;

	public Movie() {
		// TODO Auto-generated constructor stub
	}
	
	public Movie(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate, int duration, MovieSupport movieSupport) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.duration = duration;
		this.movieSupport = movieSupport;
		}

	public Movie(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, int duration, MovieSupport movieSupport) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.duration = duration;
		this.movieSupport = movieSupport;	
		}



	public List<String> getDirectors() {
		return directors;
	}

	public List<String> getActors() {
		return actors;
	}

	public int getDuration() {
		return duration;
	}

	public MovieSupport getMovieSupport() {
		return movieSupport;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setMovieSupport(MovieSupport movieSupport) {
		this.movieSupport = movieSupport;
	}

	@Override
	public String toString() {
		return "Movie [directors=" + directors + ", actors=" + actors + ", duration=" + duration + ", movieSupport="
				+ movieSupport + "]";
	}

}
