package mediatheque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("game")
public class GameTheme extends Theme{
public GameTheme() {
	// TODO Auto-generated constructor stub
}

public GameTheme(String label, Integer id) {
	super(label, id);
	// TODO Auto-generated constructor stub
}

public GameTheme(String label) {
	super(label);
	// TODO Auto-generated constructor stub
}

	
	

}
