package mediatheque.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mediatheque.controller.request.AccountMediaRequest;
import mediatheque.controller.response.AccountMediaResponse;
import mediatheque.controller.response.MediaResponse;
import mediatheque.dao.IDAOAccount;
import mediatheque.dao.IDAOAccountMedia;
import mediatheque.dao.IDAOMedia;
import mediatheque.model.Account;
import mediatheque.model.AccountMedia;
import mediatheque.model.BoardGame;
import mediatheque.model.Book;
import mediatheque.model.Magazine;
import mediatheque.model.Media;
import mediatheque.model.Movie;
import mediatheque.model.Music;
import mediatheque.model.TypeMedia;
import mediatheque.model.VideoGame;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/accountmedia")
public class AccountMediaApiController {

	private IDAOAccountMedia daoAccountMedia;
	
	private IDAOAccount daoAccount;
	
	private IDAOMedia daoMedia;

	public AccountMediaApiController(IDAOAccountMedia daoAccountMedia, IDAOAccount daoAccount, IDAOMedia daoMedia) {
		super();
		this.daoAccountMedia = daoAccountMedia;
		this.daoAccount = daoAccount;
		this.daoMedia = daoMedia;
	}

//	@GetMapping("/")
//	public List<AccountMedia> findAll() {
//		return daoAccountMedia.findAll();
//	}
	
	@GetMapping("/")
	// @JsonView(Views.Media.class)
	public List<AccountMediaResponse> findAllMedia() {
        List<AccountMedia> accountMedias =daoAccountMedia.findAll();
        List<AccountMediaResponse> accountMediaResponses = new ArrayList<AccountMediaResponse>();
//        List<Theme> themes = new ArrayList<Theme>();

        for (AccountMedia accountMedia : accountMedias) {
            AccountMediaResponse response = new AccountMediaResponse();

            System.out.println("---------------------------------------------------------");
            System.out.println(accountMedia);
            System.out.println("---------------------------------------------------------");
            BeanUtils.copyProperties(accountMedia, response);
            if (accountMedia.getMedia() instanceof BoardGame) {
                response.getMedia().setTypeMedia(TypeMedia.BoardGame);
            } else if (accountMedia.getMedia() instanceof Book) {
                response.getMedia().setTypeMedia(TypeMedia.Book);
            } else if (accountMedia.getMedia() instanceof Magazine) {
                response.getMedia().setTypeMedia(TypeMedia.Magazine);
            } else if (accountMedia.getMedia() instanceof Movie) {
                response.getMedia().setTypeMedia(TypeMedia.Movie);
            } else if (accountMedia.getMedia() instanceof Music) {
                response.getMedia().setTypeMedia(TypeMedia.Music);
            }else if (accountMedia.getMedia() instanceof VideoGame) {
                response.getMedia().setTypeMedia(TypeMedia.VideoGame);
            } else {

            }
            // Récupération des thèmes du média
//            for(MediaTheme mediaTheme : mediaThemes) {
//                themes.add(mediaTheme.getTheme());
//            }
//            response.setThemes(themes);
            accountMediaResponses.add(response);

        }
        return accountMediaResponses;
    }

	@GetMapping("/{id}")
	public AccountMedia findById(@PathVariable Integer id) {
		return daoAccountMedia.findById(id).get();
	}

//	@PostMapping("/")
//	public AccountMedia create(@Valid @RequestBody AccountMedia accountmedia, BindingResult result) {
//		if (result.hasErrors()) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "AccountMedia invalide");
//		}
//
//		accountmedia = daoAccountMedia.save(accountmedia);
//
//		return accountmedia;
//	}
	
	
	@PostMapping("/")
	public AccountMedia create(@RequestBody AccountMediaRequest accountMediaRequest) {
		Account account = daoAccount.findById(accountMediaRequest.getAccountId()).get();
		Media media = daoMedia.findById(accountMediaRequest.getMediaId()).get();
		
		AccountMedia accountMedia = new AccountMedia(account, media);
		
		accountMedia = daoAccountMedia.save(accountMedia);

		return accountMedia;
	}
	

	@PutMapping("/{id}")
	public AccountMedia update(@RequestBody AccountMedia accountmedia, @PathVariable Integer id) {
		accountmedia = daoAccountMedia.save(accountmedia);

		return accountmedia;
	}
	
	@PatchMapping("/{id}")
	public AccountMedia partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id) {
		AccountMedia accountmedia = this.daoAccountMedia.findById(id).get();
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(AccountMedia.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, accountmedia, value);
		});
		
		AccountMedia accountmediaReturn = daoAccountMedia.save(accountmedia);
		
		return accountmediaReturn;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		if(!daoAccountMedia.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoAccountMedia.deleteById(id);
	}
}

