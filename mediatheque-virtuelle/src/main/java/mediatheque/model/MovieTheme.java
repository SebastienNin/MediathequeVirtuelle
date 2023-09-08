package mediatheque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("movie")
public class MovieTheme extends Theme{
public MovieTheme() {
	// TODO Auto-generated constructor stub
}

public MovieTheme(String label, Integer id) {
	super(label, id);
	// TODO Auto-generated constructor stub
}

public MovieTheme(String label) {
	super(label);
	// TODO Auto-generated constructor stub
}


}
