package mediatheque.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

public class Music extends Media {

    @ElementCollection
    @CollectionTable(name = "track_list", joinColumns = @JoinColumn(name = "music_id"))
    @Column(name = "track")	
	private List<String> tracks;
    @Column(nullable = false)
	private String artist;

	private int duration;
	private int trackNumber;

	@OneToOne
	@Enumerated(EnumType.STRING)
=======
	@Enumerated(EnumType.ORDINAL)
>>>>>>> master
	@Column(name = "music_support", nullable = false)
	private MusicSupport musicSupport;
	@ManyToOne
	@Transient
	@Column(name = "music_type", nullable = false)
	private MusicTheme musicType;

	public Music() {
		// TODO Auto-generated constructor stub
	}
	
	public Music(Integer id, Integer version, String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String artist, int duration,
			int trackNumber, MusicSupport musicSupport, MusicTheme musicType) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.artist = artist;
		this.duration = duration;
		this.trackNumber = trackNumber;
		this.musicSupport = musicSupport;
		this.musicType = musicType;
	}

	
	public Music(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String artist, int duration,
			int trackNumber, MusicSupport musicSupport, MusicTheme musicType) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.artist = artist;
		this.duration = duration;
		this.trackNumber = trackNumber;
		this.musicSupport = musicSupport;
		this.musicType = musicType;
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

	public MusicTheme getMusicType() {
		return musicType;
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

	public void setMusicType(MusicTheme musicType) {
		this.musicType = musicType;
	}

	@Override
	public String toString() {
		return "Music [tracks=" + tracks + ", artist=" + artist + ", duration=" + duration + ", trackNumber="
				+ trackNumber + ", musicSupport=" + musicSupport + ", musicType=" + musicType + "]";
	}

}
