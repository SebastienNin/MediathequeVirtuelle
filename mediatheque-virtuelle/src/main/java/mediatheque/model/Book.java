package mediatheque.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("book")
@JsonView(Views.Book.class)
@JsonTypeName("book")
public class Book extends Media {

	private String author;
	private String ISBN;
	@Column(name = "page_nb")
	private int pageNb;
	@Column(name = "chapter_nb")
	private int chapterNb;

	@Enumerated(EnumType.STRING)
	@Column(name = "book_type")
	private BookType bookType;


	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer id, Integer version, String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String author, String iSBN, int pageNb,
			int chapterNb, BookType bookType) {
		super(id, version, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.author = author;
		ISBN = iSBN;
		this.pageNb = pageNb;
		this.chapterNb = chapterNb;
		this.bookType = bookType;
	}
	
	public Book(String name, String publishingHouse, String language, String image, String description,
			boolean dematerialized, LocalDate parutionDate, LocalDate addDate, String author, String iSBN, int pageNb,
			int chapterNb, BookType bookType) {
		super(name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate);
		this.author = author;
		ISBN = iSBN;
		this.pageNb = pageNb;
		this.chapterNb = chapterNb;
		this.bookType = bookType;
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

	@Override
	public String toString() {
		return "Book [author=" + author + ", ISBN=" + ISBN + ", pageNb=" + pageNb + ", chapterNb=" + chapterNb
				+ ", bookType=" + bookType + "]";
	}

}
