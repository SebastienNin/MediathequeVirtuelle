package mediatheque.model;

import java.time.LocalDate;

public class Magazine extends Media {

	private String ISSN;
	private int number;

	private MagazinePeriodicity magazinePrediodicity;
	private MagazineTheme magazineTheme;

	public Magazine(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String iSSN, int number,
			MagazinePeriodicity magazinePrediodicity, MagazineTheme magazineTheme) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		ISSN = iSSN;
		this.number = number;
		this.magazinePrediodicity = magazinePrediodicity;
		this.magazineTheme = magazineTheme;
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

	public MagazineTheme getMagazineTheme() {
		return magazineTheme;
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

	public void setMagazineTheme(MagazineTheme magazineTheme) {
		this.magazineTheme = magazineTheme;
	}

	@Override
	public String toString() {
		return "Magazine [ISSN=" + ISSN + ", number=" + number + ", magazinePrediodicity=" + magazinePrediodicity
				+ ", magazineTheme=" + magazineTheme + "]";
	}

}
