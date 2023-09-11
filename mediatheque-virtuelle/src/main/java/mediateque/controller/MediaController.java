package mediateque.controller;

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

import jakarta.validation.Valid;
import mediatheque.dao.IDAOMedia;
import mediatheque.model.Media;

@RestController
@RequestMapping("/media")
public class MediaController {
	
	private IDAOMedia daoMedia;

	public MediaController(IDAOMedia daoMedia) {
		this.daoMedia = daoMedia;
	}

	@GetMapping("/")
	//@JsonView(Views.Media.class)
	public List<Media> findAllMedia() {
		return daoMedia.findAll();
	}

	@GetMapping("/{id}")
	//@JsonView(Views.Media.class)
	public Media findMediaById(@PathVariable Integer id) {
		return daoMedia.findById(id).get();
	}

	@PostMapping("/")
	//@JsonView(Views.Media.class)
	public Media createMedia(@Valid @RequestBody Media media, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Media invalide");
		}
		media = daoMedia.save(media);
		return media;
	}

	@PutMapping("/{id}")
	//@JsonView(Views.Media.class)
	public Media updateMedia(@RequestBody Media media, @PathVariable Integer id) {
		media = daoMedia.save(media);
		return media;
	}


	@DeleteMapping("/{id}")
	public void removeMedia(@PathVariable Integer id) {
		if(!daoMedia.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoMedia.deleteById(id);
	}
}
