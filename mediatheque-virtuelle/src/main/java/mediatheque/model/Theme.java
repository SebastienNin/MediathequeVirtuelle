package mediatheque.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

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
import jakarta.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@JsonView(Views.Common.class)
public class Theme {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	protected Integer id;
	@Version
	protected Integer version;

	@Column(nullable = false)
	protected String label;

	@Enumerated(EnumType.STRING)
	@Column(name = "enum_theme", nullable = false)
	private EnumTheme enumTheme;
	
	
	@OneToMany(mappedBy = "theme")
//	@JsonView(Views.MediaTheme.class)
	@JsonIgnore
	protected List<MediaTheme> mediaThemeList = new ArrayList<MediaTheme>();

	public Theme() {
		// TODO Auto-generated constructor stub
	}

	public Theme(String label, Integer id, EnumTheme enumTheme) {
		this.label = label;
		this.id = id;
		this.enumTheme = enumTheme;
	}

	public Theme(String label, EnumTheme enumTheme) {
		this.label = label;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<MediaTheme> getMediaThemeList() {
		return mediaThemeList;
	}

	public void setMediaThemeList(List<MediaTheme> mediaThemeList) {
		this.mediaThemeList = mediaThemeList;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", label=" + label + ", enumTheme=" + enumTheme + "]";
	}

}
