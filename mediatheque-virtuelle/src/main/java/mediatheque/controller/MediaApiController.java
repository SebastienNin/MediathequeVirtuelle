package mediatheque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mediatheque.controller.request.MediaRequest;
import mediatheque.controller.response.MediaResponse;
import mediatheque.dao.IDAOBook;
import mediatheque.dao.IDAOMedia;
import mediatheque.dao.IDAOMediaTheme;
import mediatheque.dao.IDAOTheme;
import mediatheque.exception.MediaNotFoundException;
import mediatheque.model.BoardGame;
import mediatheque.model.Book;
import mediatheque.model.Magazine;
import mediatheque.model.Media;
import mediatheque.model.MediaTheme;
import mediatheque.model.Movie;
import mediatheque.model.Music;
import mediatheque.model.Theme;
import mediatheque.model.TypeMedia;
import mediatheque.model.VideoGame;
import mediatheque.model.Views;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/media")
public class MediaApiController {

	private IDAOMedia daoMedia;

	private IDAOBook daoBook;
	
	private IDAOTheme daoTheme;
	
	private IDAOMediaTheme daoMediaTheme;

	public MediaApiController(IDAOMedia daoMedia, IDAOBook daoBook, IDAOTheme daoTheme, IDAOMediaTheme daoMediaTheme) {
		super();
		this.daoMedia = daoMedia;
		this.daoBook = daoBook;
		this.daoTheme = daoTheme;
		this.daoMediaTheme = daoMediaTheme;
	}

	@GetMapping("/")
	// @JsonView(Views.Media.class)
	public List<MediaResponse> findAllMedia() {
        List<Media> medias =daoMedia.findAll();
        List<MediaResponse> mediaResponses = new ArrayList<MediaResponse>();
//        List<Theme> themes = new ArrayList<Theme>();

        for (Media media : medias) {
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
            // Récupération des thèmes du média
//            for(MediaTheme mediaTheme : mediaThemes) {
//                themes.add(mediaTheme.getTheme());
//            }
//            response.setThemes(themes);
            mediaResponses.add(response);

        }
        return mediaResponses;
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
	
	@GetMapping("/type/{type}/nameContaining/{name}")
	// @JsonView(Views.Media.class)
	public List<Media> findMediaByType(@PathVariable String type, @PathVariable String name) {
		// return daoMedia.findMediaByMediaType();
		return daoMedia.findMediaByMediaTypeAndNameContaining(type, name);
	}

	@GetMapping("/{id}")
	@Transactional
	public MediaResponse findMediaById(@PathVariable Integer id) {
		Media media = this.daoMedia.findById(id).orElseThrow(MediaNotFoundException::new);
		List<MediaTheme> mediaThemes = this.daoMediaTheme.findByMedia(media);
		List<Theme> themes = new ArrayList<Theme>();
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
		// Récupération des thèmes du média
		for(MediaTheme mediaTheme : mediaThemes) {
			themes.add(mediaTheme.getTheme());
		}
		response.setThemes(themes);
		
		// A changer et adapter
		// response.setNbProduits(fournisseur.getProduits().size());
		response.setNbAccountMedia(media.getAccountMediaList().size());

		return response;
	}

	// Version avec insertion d'un chemin d'image
	@PostMapping("/")
	@JsonView(Views.Media.class)
	public Media createMedia(@Valid @RequestBody MediaRequest mediaRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Media invalide");
		}
		// Le mediaRequest récupéré est un type général qui possède un attribut
		// typeMedia qui permet de faire la distinction sur le type réel du média,
		// en fonction, on récupère les propriétés spécifiques au type de média concerné

		// Étape 1 : Téléchargez l'image et générez un chemin temporaire
//		String temporaryImagePath = "/temp_media_pictures/" + UUID.randomUUID().toString() + ".jpg";

		//Etape 2 : On enregistre le média selon son type
		
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
		
		//Etape 3 : On enregistre les thèmes et le lien média-thème
		for(Theme theme : mediaRequest.getThemes()) {
			System.out.println(theme);
			if (theme.getId()!=null) {
				MediaTheme mediaTheme = new MediaTheme(media, theme);
				mediaTheme = daoMediaTheme.save(mediaTheme);
			} else {
				theme = daoTheme.save(theme);
			}
		}

		// Étape 4 : Maintenant que l'objet Media a été enregistré, obtenez son ID
//		Integer mediaId = media.getId();
		// Créez le chemin final de l'image basé sur l'ID
//		String baseImagePath = "/assets/media_pictures/";
//		String imagePath = baseImagePath + mediaId + ".jpg";

		// Étape 5 : Mettez à jour la propriété d'image de l'objet Media avec le chemin
		// final
//		media.setImage(imagePath);
		// Enregistrez à nouveau l'objet Media pour mettre à jour la propriété d'image
		daoMedia.save(media);
		
		

		// Étape 6 : Stockage de l'image depuis le chemin temporaire vers le chemin
		// final
		// moveImageToFinalPath(imageFile, temporaryImagePath, imagePath);

		// Retournez l'objet Media mis à jour
		return media;
	}

	@PutMapping("/{id}")
	@JsonView(Views.Media.class)
	public Media updateMedia(@RequestBody MediaRequest mediaRequest, @PathVariable Integer id) {
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
