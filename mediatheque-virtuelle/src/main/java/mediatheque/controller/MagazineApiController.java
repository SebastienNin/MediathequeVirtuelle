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
import mediatheque.dao.IDAOMagazine;
import mediatheque.model.Magazine;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/magazine")
public class MagazineApiController {
	
	@Autowired
	private IDAOMagazine daoMagazine;

	@GetMapping("/")
	@JsonView(Views.Magazine.class)
	public List<Magazine> findAllMagazine() {
		return daoMagazine.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Magazine.class)
	public Magazine findMagazineById(@PathVariable Integer id) {
		return daoMagazine.findById(id).get();
	}

	@PostMapping("/")
	@JsonView(Views.Magazine.class)
	public Magazine createMagazine(@Valid @RequestBody Magazine magazine, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Magazine invalide");
		}
		magazine = daoMagazine.save(magazine);
		return magazine;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Magazine.class)
	public Magazine updateMagazine(@RequestBody Magazine magazine, @PathVariable Integer id) {
		magazine = daoMagazine.save(magazine);
		return magazine;
	}


	@DeleteMapping("/{id}")
	public void removeMagazine(@PathVariable Integer id) {
		if(!daoMagazine.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoMagazine.deleteById(id);
	}
}
