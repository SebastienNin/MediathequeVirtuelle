package mediathequeVirtuelle.model;

import java.time.LocalDate;

public class Media {

	protected String name;
	protected String publishingHouse;
	protected String language;
	protected String image;
	protected String description;
	protected boolean dematerialized;
	protected LocalDate parutionDate;

	public Media(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate) {
		this.name = name;
		this.publishingHouse = publishingHouse;
		this.language = language;
		this.image = image;
		this.description = description;
		this.dematerialized = dematerialized;
		this.parutionDate = parutionDate;
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

	@Override
	public String toString() {
		return "Media [name=" + name + ", publishingHouse=" + publishingHouse + ", language=" + language + ", image="
				+ image + ", description=" + description + ", dematerialized=" + dematerialized + ", parutionDate="
				+ parutionDate + "]";
	}

}
