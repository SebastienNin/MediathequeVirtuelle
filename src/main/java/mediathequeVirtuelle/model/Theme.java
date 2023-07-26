package mediathequeVirtuelle.model;

public abstract class Theme {

	protected String label;
	
	protected int id;

	public Theme(String label, int id) {
		this.label = label;
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public int getId() {
		return id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Theme [label=" + label + ", id=" + id + "]";
	}
	
}
