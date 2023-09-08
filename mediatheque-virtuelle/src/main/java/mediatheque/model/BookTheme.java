package mediatheque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class BookTheme extends Theme{
public BookTheme() {
	// TODO Auto-generated constructor stub
}

public BookTheme(String label, Integer id) {
	super(label, id);
	// TODO Auto-generated constructor stub
}

public BookTheme(String label) {
	super(label);
	// TODO Auto-generated constructor stub
}


}
