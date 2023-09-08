package mediatheque.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@DiscriminatorValue(value = "magazine")
public class Magazine extends Media {
	@Column(nullable = false)
	private String ISSN;
	@Column(nullable = false)
	private int number;
	
	@Enumerated(EnumType.STRING)
	private MagazinePeriodicity magazinePrediodicity;

	public Magazine() {
		super();
	}

	public Magazine(Integer id, Integer version, String name, String publishingHouse, String language, String image,
			String description, boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			String iSSN, int number, MagazinePeriodicity magazinePrediodicity) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.ISSN = iSSN;
		this.number = number;
		this.magazinePrediodicity = magazinePrediodicity;
	}

	public Magazine(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, 
			String iSSN, int number, MagazinePeriodicity magazinePrediodicity) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.ISSN = iSSN;
		this.number = number;
		this.magazinePrediodicity = magazinePrediodicity;
	}

	public String getISSN() {
		return ISSN;
	}

	public int getNumber() {
		return number;
	}

	public MagazinePeriodicity getMagazinePrediodicity() {
		return magazinePrediodicity;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setMagazinePrediodicity(MagazinePeriodicity magazinePrediodicity) {
		this.magazinePrediodicity = magazinePrediodicity;
	}

	@Override
	public String toString() {
		return "Magazine [ISSN=" + ISSN + ", number=" + number + ", magazinePrediodicity=" + magazinePrediodicity
				+ "]";
	}

}
