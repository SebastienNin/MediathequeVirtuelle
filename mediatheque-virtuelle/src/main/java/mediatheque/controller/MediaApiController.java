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

	public MediaApiController(IDAOMedia daoMedia, IDAOBook daoBook) {
		super();
		this.daoMedia = daoMedia;
		this.daoBook = daoBook;
	}

	@GetMapping("/")
	//@JsonView(Views.Media.class)
	public List<MediaResponse> findAllMedia() {
		List<Media> medias =daoMedia.findAll();
		List<MediaResponse> mediaResponses = new ArrayList<MediaResponse>();
//		List<Theme> themes = new ArrayList<Theme>();

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
//	        for(MediaTheme mediaTheme : mediaThemes) {
//	            themes.add(mediaTheme.getTheme());
//	        }
//	        response.setThemes(themes);
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

	@GetMapping("/name/{name}")
	@JsonView(Views.Media.class)
	public List<Media> findByName(@PathVariable String name) {
		return daoMedia.findByName(name);
	}

//	@GetMapping("/{id}")
//	@JsonView(Views.Media.class)
//	public Media findMediaById(@PathVariable Integer id) {
//		return daoMedia.findById(id).get();
//	}
	
	@GetMapping("/{id}")
	@Transactional
	public MediaResponse findMediaById(@PathVariable Integer id) {
		Media media = this.daoMedia.findById(id).orElseThrow(MediaNotFoundException::new);
		MediaResponse response = new MediaResponse();
		
		BeanUtils.copyProperties(media, response);
		
		//A changer et adapter
		//response.setNbProduits(fournisseur.getProduits().size());
		response.setNbAccountMedia(media.getAccountMediaList().size());
		
		return response;
	}

	@PostMapping("/")
	@JsonView(Views.Media.class)
	public Media createMedia(@Valid @RequestBody MediaRequest mediaRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Media invalide");
		}
	//Le mediaRequest récupéré est un type général qui possède un attribut typeMedia qui permet de faire la distinction sur le type réel du média,
	//en fonction, on récupre les propriétés spécifiques au type de média concerné
		switch (mediaRequest.getTypeMedia()){
		case BoardGame: {
			BoardGame boardGame = new BoardGame();
			BeanUtils.copyProperties(mediaRequest, boardGame);
			return daoMedia.save(boardGame);
		} case Book: {
			Book book = new Book();
			BeanUtils.copyProperties(mediaRequest, book);
			return daoMedia.save(book);
		} case Magazine: {
			Magazine magazine = new Magazine();
			BeanUtils.copyProperties(mediaRequest, magazine);
			return daoMedia.save(magazine);
		} case Movie: {
			Movie movie = new Movie();
			BeanUtils.copyProperties(mediaRequest, movie);
			return daoMedia.save(movie);
		} case Music: {
			Music music = new Music();
			BeanUtils.copyProperties(mediaRequest, music);
			return daoMedia.save(music);
		} case VideoGame: {
			VideoGame videoGame = new VideoGame();
			BeanUtils.copyProperties(mediaRequest, videoGame);
			return daoMedia.save(videoGame);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + mediaRequest.getTypeMedia());
		}
		
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
}
