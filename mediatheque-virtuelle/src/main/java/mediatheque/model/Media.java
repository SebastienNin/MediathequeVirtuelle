package mediatheque.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

@Entity
@Table(name = "media")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "media_type")
@JsonView(Views.Media.class)
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Version
	protected Integer version;
	@Column(nullable = false)
	protected String name;
	protected String publishingHouse;
	protected String language;
	protected String image;
	@Column(columnDefinition = "TEXT")
	protected String description;
	protected boolean dematerialized;
	protected LocalDate parutionDate;
	@Column(name = "add_date", nullable = false)
	protected LocalDate addDate;
	
	@OneToMany(mappedBy = "media")
	@JsonIgnore
	protected List<AccountMedia> accountMediaList = new ArrayList<AccountMedia>();
	
	@OneToMany(mappedBy = "media")
	@JsonIgnore
	protected List<MediaTheme> mediaThemeList = new ArrayList<MediaTheme>();
	
	@OneToMany(mappedBy = "media")
	@JsonIgnore
	protected List<PersoListJoinMedia> persoList = new ArrayList<PersoListJoinMedia>();

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public Media(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
		this.publishingHouse = publishingHouse;
		this.language = language;
		this.image = image;
		this.description = description;
		this.dematerialized = dematerialized;
		this.parutionDate = parutionDate;
		this.addDate = addDate;
	}

	public Media(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate) {
		super();
		this.name = name;
		this.publishingHouse = publishingHouse;
		this.language = language;
		this.image = image;
		this.description = description;
		this.dematerialized = dematerialized;
		this.parutionDate = parutionDate;
		this.addDate = addDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDematerialized() {
		return dematerialized;
	}

	public void setDematerialized(boolean dematerialized) {
		this.dematerialized = dematerialized;
	}

	public LocalDate getParutionDate() {
		return parutionDate;
	}

	public void setParutionDate(LocalDate parutionDate) {
		this.parutionDate = parutionDate;
	}

	public LocalDate getAddDate() {
		return addDate;
	}

	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}


	public List<AccountMedia> getAccountMediaList() {
		return accountMediaList;
	}

	public void setAccountMediaList(List<AccountMedia> accountMediaList) {
		this.accountMediaList = accountMediaList;
	}
	

	public List<MediaTheme> getMediaThemeList() {
		return mediaThemeList;
	}

	public void setMediaThemeList(List<MediaTheme> mediaThemeList) {
		this.mediaThemeList = mediaThemeList;
	}

	
	public List<PersoListJoinMedia> getPersoList() {
		return persoList;
	}

	public void setPersoList(List<PersoListJoinMedia> persoList) {
		this.persoList = persoList;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", version=" + version + ", name=" + name + ", publishingHouse=" + publishingHouse
				+ ", language=" + language + ", image=" + image + ", description=" + description + ", dematerialized="
				+ dematerialized + ", parutionDate=" + parutionDate + ", addDate=" + addDate + "]";
	}

	
	
}