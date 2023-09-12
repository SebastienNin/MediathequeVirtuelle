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
import mediatheque.dao.IDAOMovie;
import mediatheque.model.Movie;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/movie")
public class MovieApiController {

	private IDAOMovie daoMovie;

	public MovieApiController(IDAOMovie daoMovie) {
		this.daoMovie = daoMovie;
	}

	@GetMapping("/")
	@JsonView(Views.MovieView.class)
	public List<Movie> findAllMovie() {
		return daoMovie.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.MovieView.class)
	public Movie findMovieById(@PathVariable Integer id) {
		return daoMovie.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.MovieView.class)
	public Movie createMovie(@Valid @RequestBody Movie movie, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie invalide");
		}
		movie = daoMovie.save(movie);
		return movie;
	}

	@PutMapping("/{id}")
	@JsonView(Views.MovieView.class)
	public Movie updateMovie(@RequestBody Movie movie, @PathVariable Integer id) {
		movie = daoMovie.save(movie);
		return movie;
	}


	@DeleteMapping("/{id}")
	public void removeMovie(@PathVariable Integer id) {
		if(!daoMovie.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoMovie.deleteById(id);
	}
}
