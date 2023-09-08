package mediatheque.model;

import java.time.LocalDate;
import java.util.List;

public class Music extends Media {

	private List<String> tracks;
	private String artist;

	private int duration;
	private int trackNumber;

	private MusicSupport musicSupport;
	private MusicTheme musicType;

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
