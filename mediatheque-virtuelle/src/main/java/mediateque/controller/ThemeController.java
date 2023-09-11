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
import mediatheque.dao.IDAOTheme;
import mediatheque.model.Theme;

@RestController
@RequestMapping("/theme")
public class ThemeController {

		private IDAOTheme daoTheme;

		public ThemeController(IDAOTheme daoTheme) {
			this.daoTheme = daoTheme;
		}
		@GetMapping("/")
		//@JsonView(Views.Theme.class)
		public List<Theme> findAllTheme() {
			return daoTheme.findAll();
		}

		@GetMapping("/{id}")
		//@JsonView(Views.Theme.class)
		public Theme findThemeById(@PathVariable Integer id) {
			return daoTheme.findById(id).get();
		}

		@PostMapping("/")
		//@JsonView(Views.Theme.class)
		public Theme createTheme(@Valid @RequestBody Theme Theme, BindingResult result) {
			if (result.hasErrors()) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Theme invalide");
			}
			Theme = daoTheme.save(Theme);
			return Theme;
		}

		@PutMapping("/{id}")
		//@JsonView(Views.Theme.class)
		public Theme updateTheme(@RequestBody Theme Theme, @PathVariable Integer id) {
			Theme = daoTheme.save(Theme);
			return Theme;
		}


		@DeleteMapping("/{id}")
		public void removeTheme(@PathVariable Integer id) {
			if(!daoTheme.existsById(id)) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			daoTheme.deleteById(id);
		}
	}
		

