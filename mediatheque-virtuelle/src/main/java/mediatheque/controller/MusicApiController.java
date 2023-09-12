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
import mediatheque.dao.IDAOMusic;
import mediatheque.model.Music;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/music")
public class MusicApiController {

	private IDAOMusic daoMusic;

	public MusicApiController(IDAOMusic daoMusic) {
		this.daoMusic = daoMusic;
	}

	@GetMapping("/")
	@JsonView(Views.MusicView.class)
	public List<Music> findAllMusic() {
		return daoMusic.findAll();
	}
	

	@GetMapping("/{id}")
	@JsonView(Views.MusicView.class)
	public Music findMusicById(@PathVariable Integer id) {
		return daoMusic.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.MusicView.class)
	public Music createMusic(@Valid @RequestBody Music music, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Music invalide");
		}
		music = daoMusic.save(music);
		return music;
	}

	@PutMapping("/{id}")
	@JsonView(Views.MusicView.class)
	public Music updateMusic(@RequestBody Music music, @PathVariable Integer id) {
		music = daoMusic.save(music);
		return music;
	}


	@DeleteMapping("/{id}")
	public void removeMusic(@PathVariable Integer id) {
		if(!daoMusic.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoMusic.deleteById(id);
	}
}
