package mediatheque.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Theme {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	protected Integer id;


	protected String label;
	
	public Theme() {
		// TODO Auto-generated constructor stub
	}
	public Theme(String label, Integer id) {
		this.label = label;
		this.id = id;
	}
	public Theme(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public Integer getId() {
		return id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Theme [label=" + label + ", id=" + id + "]";
	}
	
}
