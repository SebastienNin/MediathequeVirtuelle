package mediatheque.controller;

import java.util.List;

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
import mediatheque.dao.IDAOMedia;
import mediatheque.model.Book;
import mediatheque.model.Media;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/media")
public class MediaApiController {

	private IDAOMedia daoMedia;

	private IDAOBook daoBook;

	public MediaApiController(IDAOMedia daoMedia, IDAOBook daoBook) {
		super();
		this.daoMedia = daoMedia;
		this.daoBook = daoBook;
	}

	@GetMapping("/")
	//@JsonView(Views.Media.class)
	public List<Media> findAllMedia() {
		return daoMedia.findAll();
	}

	@GetMapping("/book")
	@JsonView(Views.Media.class)
	public List<Book> findAllBook() {
		return daoMedia.findAllBook();
	}
	
	@GetMapping("/bookBis")
	@JsonView(Views.Media.class)
	public List<Book> findAllBookBis() {
		return daoBook.findAll();
	}

	@GetMapping("/name/{name}")
	@JsonView(Views.Media.class)
	public List<Media> findByName(@PathVariable String name) {
		return daoMedia.findByName(name);
	}

	@GetMapping("/{id}")
	@JsonView(Views.Media.class)
	public Media findMediaById(@PathVariable Integer id) {
		return daoMedia.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.Media.class)
	public Media createMedia(@Valid @RequestBody Media media, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Media invalide");
		}
		media = daoMedia.save(media);
		return media;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Media.class)
	public Media updateMedia(@RequestBody Media media, @PathVariable Integer id) {
		media = daoMedia.save(media);
		return media;
	}

	@DeleteMapping("/{id}")
	public void removeMedia(@PathVariable Integer id) {
		if (!daoMedia.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoMedia.deleteById(id);
	}
}
