package mediatheque.controller.request;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mediatheque.model.BookType;
import mediatheque.model.MagazinePeriodicity;
import mediatheque.model.MovieSupport;
import mediatheque.model.MusicSupport;
import mediatheque.model.Theme;
import mediatheque.model.TypeMedia;

public class MediaRequest {
	
	//Attributs de Media
	private Integer id;
	private Integer version;
	private String name;
	private String publishingHouse;
	private String language;
	private String image;
	private String description;
	private boolean dematerialized;
	private LocalDate parutionDate;
	private LocalDate addDate;
	
	// Attribut pour récupérer les thèmes
	private List<Theme> themes;
	
	//Attribut supplémentaire pour disntinguer le type de média
	private TypeMedia typeMedia;
	
	//Attributs de BoardGame
	private String playerNumber;
	private int recommendedAge;
	private int duration; //mutualisé avec Movie et Music
	
	//Attributs de Book
	private String author;
	private String ISBN;
	private int pageNb;
	private int chapterNb;
	private BookType bookType;
	
	//Attributs de Magazine
	private String ISSN;
	private int number;
	private MagazinePeriodicity magazinePeriodicity;

	//Attributs de Movie
	private List<String> directors = new ArrayList<String>();
	private List<String> actors = new ArrayList<String>();
	//duration -> voir BoardGame
	private MovieSupport movieSupport;
	
	//Attributs de Music
	private List<String> tracks = new ArrayList<String>();
	private String artist;
	//duration -> voir BoardGame
	private int trackNumber;
	private MusicSupport musicSupport;
	
	//Attributs de VideoGame
	private int pegi;
	private boolean multiPlayer;
	
	//Getters & Setters
	
	public String getName() {
		return name;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDematerialized() {
		return dematerialized;
	}
	public void setDematerialized(boolean dematerialized) {
		this.dematerialized = dematerialized;
	}
	public LocalDate getParutionDate() {
		return parutionDate;
	}
	public void setParutionDate(LocalDate parutionDate) {
		this.parutionDate = parutionDate;
	}
	public LocalDate getAddDate() {
		return addDate;
	}
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}
	public TypeMedia getTypeMedia() {
		return typeMedia;
	}
	public void setTypeMedia(TypeMedia typeMedia) {
		this.typeMedia = typeMedia;
	}
	public String getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}
	public int getRecommendedAge() {
		return recommendedAge;
	}
	public void setRecommendedAge(int recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPageNb() {
		return pageNb;
	}
	public void setPageNb(int pageNb) {
		this.pageNb = pageNb;
	}
	public int getChapterNb() {
		return chapterNb;
	}
	public void setChapterNb(int chapterNb) {
		this.chapterNb = chapterNb;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public MagazinePeriodicity getmagazinePeriodicity() {
		return magazinePeriodicity;
	}
	public void setmagazinePeriodicity(MagazinePeriodicity periodicity) {
		this.magazinePeriodicity = periodicity;
	}
	public List<String> getDirectors() {
		return directors;
	}
	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}
	public List<String> getActors() {
		return actors;
	}
	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public MovieSupport getMovieSupport() {
		return movieSupport;
	}
	public void setMovieSupport(MovieSupport movieSupport) {
		this.movieSupport = movieSupport;
	}
	public List<String> getTracks() {
		return tracks;
	}
	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getTrackNumber() {
		return trackNumber;
	}
	public void setTracksNumber(int tracksNumber) {
		this.trackNumber = tracksNumber;
	}
	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}
	public MusicSupport getMusicSupport() {
		return musicSupport;
	}
	public void setMusicSupport(MusicSupport musicSupport) {
		this.musicSupport = musicSupport;
	}
	public int getPegi() {
		return pegi;
	}
	public void setPegi(int pegi) {
		this.pegi = pegi;
	}
	public boolean isMultiPlayer() {
		return multiPlayer;
	}
	public void setMultiPlayer(boolean multiPlayer) {
		this.multiPlayer = multiPlayer;
	}
	public List<Theme> getThemes() {
		return themes;
	}
	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}
}



