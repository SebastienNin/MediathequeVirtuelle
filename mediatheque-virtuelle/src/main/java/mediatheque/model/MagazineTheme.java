package mediatheque.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")

public class MagazineTheme extends Theme{
public MagazineTheme() {
	// TODO Auto-generated constructor stub
}

public MagazineTheme(String label, Integer id) {
	super(label, id);
	// TODO Auto-generated constructor stub
}

public MagazineTheme(String label) {
	super(label);
	// TODO Auto-generated constructor stub
}


}
