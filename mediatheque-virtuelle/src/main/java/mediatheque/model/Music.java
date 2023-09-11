package mediatheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;

@Entity
@DiscriminatorValue("music")
public class Music extends Media {

    @ElementCollection
    @CollectionTable(name = "track_list", joinColumns = @JoinColumn(name = "music_id"))
    @Column(name = "track")	
	private List<String> tracks = new ArrayList<String>();
	private String artist;

	private int duration;
	@Column(name="track_number")
	private int trackNumber;

	@Enumerated(EnumType.STRING)
	@Column(name = "music_support")
	private MusicSupport musicSupport;

	public Music() {
		// TODO Auto-generated constructor stub
	}
	
	public Music(Integer id, Integer version, String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String artist, int duration,
			int trackNumber, MusicSupport musicSupport) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.artist = artist;
		this.duration = duration;
		this.trackNumber = trackNumber;
		this.musicSupport = musicSupport;
	}

	
	public Music(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String artist, int duration,
			int trackNumber, MusicSupport musicSupport) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.artist = artist;
		this.duration = duration;
		this.trackNumber = trackNumber;
		this.musicSupport = musicSupport;
	}

	public List<String> getTracks() {
		return tracks;
	}

	public String getArtist() {
		return artist;
	}

	public int getDuration() {
		return duration;
	}

	public int getTrackNumber() {
		return trackNumber;
	}

	public MusicSupport getMusicSupport() {
		return musicSupport;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public void setMusicSupport(MusicSupport musicSupport) {
		this.musicSupport = musicSupport;
	}

	@Override
	public String toString() {
		return "Music [tracks=" + tracks + ", artist=" + artist + ", duration=" + duration + ", trackNumber="
				+ trackNumber + ", musicSupport=" + musicSupport + "]";
	}

}
