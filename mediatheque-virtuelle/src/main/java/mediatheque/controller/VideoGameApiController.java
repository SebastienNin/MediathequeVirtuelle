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
import mediatheque.dao.IDAOVideoGame;
import mediatheque.model.VideoGame;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/videogame")
public class VideoGameApiController {
	private IDAOVideoGame daoVideoGame;

	public VideoGameApiController(IDAOVideoGame daoVideoGame) {
		this.daoVideoGame = daoVideoGame;
	}

	@GetMapping("/")
	@JsonView(Views.VideoGameView.class)
	public List<VideoGame> findAllVideoGame() {
		return daoVideoGame.findAll();
	}
	

	@GetMapping("/{id}")
	@JsonView(Views.VideoGameView.class)
	public VideoGame findVideoGameById(@PathVariable Integer id) {
		return daoVideoGame.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.VideoGameView.class)
	public VideoGame createVideoGame(@Valid @RequestBody VideoGame videogame, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "VideoGame invalide");
		}
		videogame = daoVideoGame.save(videogame);
		return videogame;
	}

	@PutMapping("/{id}")
	@JsonView(Views.VideoGameView.class)
	public VideoGame updateVideoGame(@RequestBody VideoGame videogame, @PathVariable Integer id) {
		videogame = daoVideoGame.save(videogame);
		return videogame;
	}


	@DeleteMapping("/{id}")
	public void removeVideoGame(@PathVariable Integer id) {
		if(!daoVideoGame.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoVideoGame.deleteById(id);
	}
}
