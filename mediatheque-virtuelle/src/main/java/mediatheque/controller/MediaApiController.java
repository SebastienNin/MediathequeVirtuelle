package mediatheque.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.nio.file.Path;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mediatheque.controller.request.MediaRequest;
import mediatheque.controller.response.MediaResponse;
import mediatheque.dao.IDAOBook;
import mediatheque.dao.IDAOMedia;
import mediatheque.exception.MediaNotFoundException;
import mediatheque.model.BoardGame;
import mediatheque.model.Book;
import mediatheque.model.Magazine;
import mediatheque.model.Media;
import mediatheque.model.Movie;
import mediatheque.model.Music;
import mediatheque.model.TypeMedia;
import mediatheque.model.VideoGame;
import mediatheque.model.Views;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	// @JsonView(Views.Media.class)
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

	@GetMapping("/movie")
	@JsonView(Views.Media.class)
	public List<Movie> findAllMovie() {
		return daoMedia.findAllMovie();
	}

	@GetMapping("/name/{name}")
	@JsonView(Views.Media.class)
	public List<Media> findByName(@PathVariable String name) {
		return daoMedia.findByName(name);
	}

	// @GetMapping("/{id}")
	// @JsonView(Views.Media.class)
	// public Media findMediaById(@PathVariable Integer id) {
	// return daoMedia.findById(id).get();
	// }

	@GetMapping("/nameContaining/{name}")
	// To set back if needed | Seb
	// @JsonView(Views.Media.class)
	public List<Media> findByNameContaining(@PathVariable String name) {
		return daoMedia.findByNameContaining(name);
	}

	@GetMapping("/type/{type}")
	// @JsonView(Views.Media.class)
	public List<Media> findMediaByType(@PathVariable String type) {
		// return daoMedia.findMediaByMediaType();
		return daoMedia.findMediaByMediaType(type);
	}

	@GetMapping("/{id}")
	@Transactional
	public MediaResponse findMediaById(@PathVariable Integer id) {
		Media media = this.daoMedia.findById(id).orElseThrow(MediaNotFoundException::new);
		MediaResponse response = new MediaResponse();

		BeanUtils.copyProperties(media, response);
		
		if (media instanceof BoardGame) {
			response.setTypeMedia(TypeMedia.BoardGame);
		} else if (media instanceof Book) {
			response.setTypeMedia(TypeMedia.Book);
		} else if (media instanceof Magazine) {
			response.setTypeMedia(TypeMedia.Magazine);
		} else if (media instanceof Movie) {
			response.setTypeMedia(TypeMedia.Movie);
		} else if (media instanceof Music) {
			response.setTypeMedia(TypeMedia.Music);
		}else if (media instanceof VideoGame) {
			response.setTypeMedia(TypeMedia.VideoGame);
		} else {
			
		}
		

		// A changer et adapter
		// response.setNbProduits(fournisseur.getProduits().size());
		response.setNbAccountMedia(media.getAccountMediaList().size());

		return response;
	}

	// Version avec insertion d'un chemin d'image
	@PostMapping("/")
	@JsonView(Views.Media.class)
	public Media createMedia(@Valid @RequestBody MediaRequest mediaRequest, BindingResult result,
			@RequestPart("imageFile") MultipartFile imageFile) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Media invalide");
		}
		// Le mediaRequest récupéré est un type général qui possède un attribut
		// typeMedia qui permet de faire la distinction sur le type réel du média,
		// en fonction, on récupre les propriétés spécifiques au type de média concerné

		// Étape 1 : Téléchargez l'image et générez un chemin temporaire
		String temporaryImagePath = "/temp_media_pictures/" + UUID.randomUUID().toString() + ".jpg";

		Media media;
		switch (mediaRequest.getTypeMedia()) {
			case BoardGame: {
				BoardGame boardGame = new BoardGame();
				BeanUtils.copyProperties(mediaRequest, boardGame);
				media = daoMedia.save(boardGame);
				break;
			}
			case Book: {
				Book book = new Book();
				BeanUtils.copyProperties(mediaRequest, book);
				media = daoMedia.save(book);
				break;
			}
			case Magazine: {
				Magazine magazine = new Magazine();
				BeanUtils.copyProperties(mediaRequest, magazine);
				media = daoMedia.save(magazine);
				break;
			}
			case Movie: {
				Movie movie = new Movie();
				BeanUtils.copyProperties(mediaRequest, movie);
				media = daoMedia.save(movie);
				break;
			}
			case Music: {
				Music music = new Music();
				BeanUtils.copyProperties(mediaRequest, music);
				media = daoMedia.save(music);
				break;
			}
			case VideoGame: {
				VideoGame videoGame = new VideoGame();
				BeanUtils.copyProperties(mediaRequest, videoGame);
				media = daoMedia.save(videoGame);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + mediaRequest.getTypeMedia());
		}

		// Étape 3 : Maintenant que l'objet Media a été enregistré, obtenez son ID
		Integer mediaId = media.getId();
		// Créez le chemin final de l'image basé sur l'ID
		String baseImagePath = "/assets/media_pictures/";
		String imagePath = baseImagePath + mediaId + ".jpg";

		// Étape 4 : Mettez à jour la propriété d'image de l'objet Media avec le chemin
		// final
		media.setImage(imagePath);
		// Enregistrez à nouveau l'objet Media pour mettre à jour la propriété d'image
		daoMedia.save(media);

		// Étape 5 : Stockage de l'image depuis le chemin temporaire vers le chemin
		// final
		// moveImageToFinalPath(imageFile, temporaryImagePath, imagePath);

		// Retournez l'objet Media mis à jour
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

	// @PostMapping("/upload-image")
	// public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile
	// file) {
	// try {
	// // Générez un nom de fichier unique basé sur l'UUID
	// String uniqueFileName = UUID.randomUUID().toString() + ".jpg";

	// // Chemin complet du fichier image
	// Path filePath = Path.of("/assets/media_pictures/" + uniqueFileName);

	// // Assurez-vous que le répertoire d'upload existe, sinon créez-le
	// Path uploadPath = filePath.getParent();
	// if (!Files.exists(uploadPath)) {
	// Files.createDirectories(uploadPath);
	// }

	// // Copiez le fichier image vers le chemin spécifié
	// Files.copy(file.getInputStream(), filePath,
	// StandardCopyOption.REPLACE_EXISTING);

	// // Retournez le chemin de stockage de l'image
	// return ResponseEntity.ok(uniqueFileName);
	// } catch (IOException e) {
	// // Gérez les erreurs d'E/S ici, par exemple, en renvoyant une ResponseEntity
	// // avec un code d'erreur
	// return ResponseEntity.status(500).body("Erreur lors de l'enregistrement de
	// l'image.");
	// }
	// }

	// private void moveImageToFinalPath(MultipartFile imageFile, String
	// temporaryImagePath, String finalImagePath) {
	// try {
	// // Chemin complet du fichier image temporaire
	// Path temporaryImageFilePath = Path.of(temporaryImagePath);

	// // Chemin complet du fichier image final
	// Path finalImageFilePath = Path.of(finalImagePath);

	// // Assurez-vous que le répertoire final existe, sinon créez-le
	// Path finalImageDirectory = finalImageFilePath.getParent();
	// if (!Files.exists(finalImageDirectory)) {
	// Files.createDirectories(finalImageDirectory);
	// }

	// // Copiez le fichier image depuis l'emplacement temporaire vers l'emplacement
	// // final
	// Files.copy(imageFile.getInputStream(), finalImageFilePath,
	// StandardCopyOption.REPLACE_EXISTING);

	// // Supprimez le fichier image temporaire s'il est nécessaire
	// if (Files.exists(temporaryImageFilePath)) {
	// Files.delete(temporaryImageFilePath);
	// }
	// } catch (IOException e) {
	// // Gérez les erreurs d'E/S ici, par exemple, en lançant une exception
	// // personnalisée
	// throw new RuntimeException("Erreur lors du déplacement de l'image vers
	// l'emplacement final", e);
	// }
	// }

}
