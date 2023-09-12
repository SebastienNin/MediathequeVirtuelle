package mediatheque.model;

public interface Views {
	
	public interface Common {}
	
	public interface PersoList extends Common {}
	
	public interface Media extends Common {}
	
	public interface MovieView extends Media {}
	
	public interface MusicView extends Media {}
	
	public interface VideoGameView extends Media {}
	
	public interface Book extends Media {}
	
	public interface BoardGame extends Media {}
	
	public interface Magazine extends Media {}

}
