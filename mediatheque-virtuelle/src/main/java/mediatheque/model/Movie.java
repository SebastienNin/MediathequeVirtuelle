package mediatheque.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("movie")
public class Movie extends Media {

    @ElementCollection
    @CollectionTable(name = "movie_directors", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "director")	
	private List<String> directors;
    @ElementCollection
    @CollectionTable(name = "movie_actors", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "actor")
	private List<String> actors;

	private int duration;

	@OneToOne
	@Enumerated(EnumType.STRING)
	@Column(name = "movie_support", nullable = false)
	private MovieSupport movieSupport;
	@ManyToOne
	@Transient
	@Column(name = "movie_theme", nullable = false)
	private MovieTheme movieTheme;

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

	public MovieTheme getMovieTheme() {
		return movieTheme;
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

	public void setMovieTheme(MovieTheme movieTheme) {
		this.movieTheme = movieTheme;
	}

	@Override
	public String toString() {
		return "Movie [directors=" + directors + ", actors=" + actors + ", duration=" + duration + ", movieSupport="
				+ movieSupport + ", movieTheme=" + movieTheme + "]";
	}

}
