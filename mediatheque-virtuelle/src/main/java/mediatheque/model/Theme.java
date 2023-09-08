package mediatheque.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Theme {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	protected Integer id;
	@Column(nullable = false)
	protected String label;
	@OneToOne
	@Enumerated(EnumType.STRING)
	@Column(name = "enum_theme", nullable = false)
	private EnumTheme enumTheme;
	@Transient
	@OneToMany
	protected List<Media> mediaList = new ArrayList<Media>();

	@Column(nullable = false)
	protected String label;
	@Transient
	@ManyToMany
	protected List<Media> mediaList = new ArrayList<Media>();
	
	public Theme() {
		// TODO Auto-generated constructor stub
	}

	public Theme(String label, Integer id, EnumTheme enumTheme) {
		this.label = label;
		this.id = id;
		this.enumTheme = enumTheme;
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

	public EnumTheme getEnumTheme() {
		return enumTheme;
	}

	public void setEnumTheme(EnumTheme enumTheme) {
		this.enumTheme = enumTheme;
	}

	public List<Media> getMediaList() {
		return mediaList;
	}

	public void setMediaList(List<Media> mediaList) {
		this.mediaList = mediaList;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", label=" + label + ", enumTheme=" + enumTheme + "]";
	}

}
