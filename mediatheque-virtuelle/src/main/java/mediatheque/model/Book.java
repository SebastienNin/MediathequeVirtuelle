package mediatheque.model;

import java.time.LocalDate;

public class Book extends Media {

	private String author;
	private String ISBN;
	private int pageNb;
	private int chapterNb;

	private BookType bookType;
	private BookTheme bookTheme;

	public Book(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String author, String iSBN, int pageNb, int chapterNb,
			BookType bookType, BookTheme bookTheme) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.author = author;
		ISBN = iSBN;
		this.pageNb = pageNb;
		this.chapterNb = chapterNb;
		this.bookType = bookType;
		this.bookTheme = bookTheme;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public int getPageNb() {
		return pageNb;
	}

	public int getChapterNb() {
		return chapterNb;
	}

	public BookType getBookType() {
		return bookType;
	}

	public BookTheme getBookTheme() {
		return bookTheme;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public void setPageNb(int pageNb) {
		this.pageNb = pageNb;
	}

	public void setChapterNb(int chapterNb) {
		this.chapterNb = chapterNb;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}

	public void setBookTheme(BookTheme bookTheme) {
		this.bookTheme = bookTheme;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", ISBN=" + ISBN + ", pageNb=" + pageNb + ", chapterNb=" + chapterNb
				+ ", bookType=" + bookType + ", bookTheme=" + bookTheme + "]";
	}

}
