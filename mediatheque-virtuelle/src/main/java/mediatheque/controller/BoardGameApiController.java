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
import mediatheque.dao.IDAOBoardGame;
import mediatheque.model.BoardGame;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/boardgame")
public class BoardGameApiController {
	
	@Autowired
	private IDAOBoardGame daoBoardGame;


	@GetMapping("/")
	@JsonView(Views.BoardGame.class)
	public List<BoardGame> findAllBoardGame() {
		return daoBoardGame.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.BoardGame.class)
	public BoardGame findBoardGameById(@PathVariable Integer id) {
		return daoBoardGame.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.BoardGame.class)
	public BoardGame createBoardGame(@Valid @RequestBody BoardGame boardGame, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "BoardGame invalide");
		}
		boardGame = daoBoardGame.save(boardGame);
		return boardGame;
	}

	@PutMapping("/{id}")
	@JsonView(Views.BoardGame.class)
	public BoardGame updateBoardGame(@RequestBody BoardGame boardGame, @PathVariable Integer id) {
		boardGame = daoBoardGame.save(boardGame);
		return boardGame;
	}


	@DeleteMapping("/{id}")
	public void removeBoardGame(@PathVariable Integer id) {
		if(!daoBoardGame.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoBoardGame.deleteById(id);
	}

}
