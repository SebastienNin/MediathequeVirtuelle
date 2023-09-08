package mediatheque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("music")
public class MusicTheme extends Theme{
	
	public MusicTheme() {
		// TODO Auto-generated constructor stub
	}

	public MusicTheme(String label, Integer id) {
		super(label, id);
		// TODO Auto-generated constructor stub
	}

	public MusicTheme(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}



}
