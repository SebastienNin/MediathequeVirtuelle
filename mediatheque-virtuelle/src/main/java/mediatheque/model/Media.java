package mediatheque.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;

@Entity
@Table(name = "media")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_media")
public class Media {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Version
	protected Integer version;
	@Column(nullable=false)
	protected String name;
	@Column(nullable=false)
	protected String publishingHouse;
	@Column(nullable=false)
	protected String language;
	protected String image;
	@Column(columnDefinition = "TEXT")
	protected String description;
	protected boolean dematerialized;
	@Column(nullable=false)
	protected LocalDate parutionDate;
	@Column(nullable=false)
	protected LocalDate addDate;
	@Transient
	@ManyToMany
	protected List<Account> accountList;

	public Media(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate) {
		this.name = name;
		this.publishingHouse = publishingHouse;
		this.language = language;
		this.image = image;
		this.description = description;
		this.dematerialized = dematerialized;
		this.parutionDate = parutionDate;
		this.addDate = addDate;
	}

	public String getName() {
		return name;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public String getLanguage() {
		return language;
	}

	public String getImage() {
		return image;
	}

	public String getDescription() {
		return description;
	}

	public boolean isDematerialized() {
		return dematerialized;
	}

	public LocalDate getParutionDate() {
		return parutionDate;
	}
	
	public LocalDate getAddDate() {
		return addDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDematerialized(boolean dematerialized) {
		this.dematerialized = dematerialized;
	}

	public void setParutionDate(LocalDate parutionDate) {
		this.parutionDate = parutionDate;
	}
	
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}

	@Override
	public String toString() {
		return "Media [name=" + name + ", publishingHouse=" + publishingHouse + ", language=" + language + ", image="
				+ image + ", description=" + description + ", dematerialized=" + dematerialized + ", parutionDate="
				+ parutionDate + ", addDate=" + addDate + "]";
	}

}
