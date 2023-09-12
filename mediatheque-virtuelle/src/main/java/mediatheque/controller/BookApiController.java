package mediatheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.validation.Valid;
import mediatheque.dao.IDAOBook;
import mediatheque.model.Book;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/book")
public class BookApiController {

	@Autowired
	private IDAOBook daoBook;
	
	@GetMapping("/")
	@JsonView(Views.Book.class)
	public List<Book> findAllBook() {
		return daoBook.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Book.class)
	public Book findBookById(@PathVariable Integer id) {
		return daoBook.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.Book.class)
	public Book createBook(@Valid @RequestBody Book book, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Book invalide");
		}
		book = daoBook.save(book);
		return book;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Book.class)
	public Book updateBook(@RequestBody Book book, @PathVariable Integer id) {
		book = daoBook.save(book);
		return book;
	}


	@DeleteMapping("/{id}")
	public void removeBook(@PathVariable Integer id) {
		if(!daoBook.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoBook.deleteById(id);
	}
}
