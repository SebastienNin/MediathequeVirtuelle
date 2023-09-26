package mediatheque.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import mediatheque.dao.IDAOTheme;
import mediatheque.model.EnumTheme;
import mediatheque.model.Media;
import mediatheque.model.Theme;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/theme")
public class ThemeApiController {

	private IDAOTheme daoTheme;

	public ThemeApiController(IDAOTheme daoTheme) {
		this.daoTheme = daoTheme;
	}

	@GetMapping("/")
	@JsonView(Views.Theme.class)
	public List<Theme> findAllTheme() {
		return daoTheme.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Theme.class)
	public Theme findThemeById(@PathVariable Integer id) {
		return daoTheme.findById(id).get();
	}

	@GetMapping("/type/{type}")
	@JsonView(Views.Theme.class)
	public List<Theme> findThemeByEnumTheme(@PathVariable String type) {
		try {
			EnumTheme enumType = EnumTheme.valueOf(type); // Convertir la chaîne en Enum
			return daoTheme.findByEnumTheme(enumType);
		} catch (IllegalArgumentException e) {
			// Gérer le cas où la valeur de type n'est pas valide
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type de thème invalide");
		}
	}

	@GetMapping("/label/{label}")
	@JsonView(Views.Theme.class)
	public List<Theme> findThemeByLabel(@PathVariable String label) {
		try {
			return daoTheme.findByLabel(label);
		} catch (IllegalArgumentException e) {
			// Gérer le cas où la valeur de type n'est pas valide
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Label invalide");
		}
	}

	// Exemple : localhost:8080/api/theme/labelAndType/Action/VIDEOGAME
	@GetMapping("/labelAndType/{label}/{type}")
	@JsonView(Views.Theme.class)
	public List<Theme> findThemesByLabelAndType(@PathVariable String label, @PathVariable String type) {
		try {
			EnumTheme enumType = EnumTheme.valueOf(type); // Convertir la chaîne en Enum
			return daoTheme.findByLabelAndEnumTheme(label, enumType);
		} catch (IllegalArgumentException e) {
			// Gérer le cas où la valeur de type n'est pas valide
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type de thème invalide");
		}
	}

	@GetMapping("/mediaByLabel/{label}")
	public ResponseEntity<List<Media>> findMediaByLabel(@PathVariable String label) {
		try {
			List<Media> mediaList = daoTheme.findMediaByThemeLabel(label);
			return ResponseEntity.ok(mediaList);
		} catch (IllegalArgumentException e) {
			// Gérer le cas où le label n'est pas valide
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping("/")
	@JsonView(Views.Theme.class)
	public Theme createTheme(@Valid @RequestBody Theme Theme, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Theme invalide");
		}
		Theme = daoTheme.save(Theme);
		return Theme;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Theme.class)
	public Theme updateTheme(@RequestBody Theme Theme, @PathVariable Integer id) {
		Theme = daoTheme.save(Theme);
		return Theme;
	}

	@DeleteMapping("/{id}")
	public void removeTheme(@PathVariable Integer id) {
		if (!daoTheme.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		daoTheme.deleteById(id);
	}
}
