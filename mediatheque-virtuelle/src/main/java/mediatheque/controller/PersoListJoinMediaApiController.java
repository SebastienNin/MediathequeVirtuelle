package mediatheque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import jakarta.transaction.Transactional;
import mediatheque.controller.response.AccountMediaResponse;
import mediatheque.controller.response.PersoListJoinMediaResponse;
import mediatheque.dao.IDAOPersoListJoinMedia;
import mediatheque.dao.IDAOPersonnalizedList;
import mediatheque.model.AccountMedia;
import mediatheque.model.BoardGame;
import mediatheque.model.Book;
import mediatheque.model.Magazine;
import mediatheque.model.Movie;
import mediatheque.model.Music;
import mediatheque.model.PersoListJoinMedia;
import mediatheque.model.PersonnalizedList;
import mediatheque.model.TypeMedia;
import mediatheque.model.VideoGame;

@RestController
@CrossOrigin
@RequestMapping("/api/persoListJoinMedia")
public class PersoListJoinMediaApiController {
	
	private IDAOPersoListJoinMedia daoPersoListJoinMedia;
	
	private IDAOPersonnalizedList daoPersonnalizedList;
	
	private MediaApiController mediaApiController;


	
	public PersoListJoinMediaApiController(IDAOPersoListJoinMedia daoPersoListJoinMedia, IDAOPersonnalizedList daoPersonnalizedList, MediaApiController mediaApiController) {
		this.daoPersoListJoinMedia = daoPersoListJoinMedia;
		this.daoPersonnalizedList = daoPersonnalizedList;
		this.mediaApiController = mediaApiController;
	}
	

    @GetMapping("")
    public List<PersoListJoinMedia> findAll() {
    	return daoPersoListJoinMedia.findAll();
    }
    

    @GetMapping("/{id}")
    public PersoListJoinMedia findById(@PathVariable Integer id) {
        return daoPersoListJoinMedia.findById(id).get();
    }
    
    @GetMapping("/persoList/{persoListId}")
	@Transactional 
	public List<PersoListJoinMediaResponse> findByPersoListId(@PathVariable Integer persoListId) {
		PersonnalizedList persoList = this.daoPersonnalizedList.findById(persoListId).get();
		List<PersoListJoinMedia> persoLists = this.daoPersoListJoinMedia.findByPersoList(persoList);
        List<PersoListJoinMediaResponse> persoListJoinMediaResponses = new ArrayList<PersoListJoinMediaResponse>();

		for (PersoListJoinMedia persoJoin : persoLists) {
            PersoListJoinMediaResponse response = new PersoListJoinMediaResponse();
            response.setMedia(this.mediaApiController.findMediaById(persoJoin.getMedia().getId()));

            BeanUtils.copyProperties(persoJoin, response);
            if (persoJoin.getMedia() instanceof BoardGame) {
                response.getMedia().setTypeMedia(TypeMedia.BoardGame);
            } else if (persoJoin.getMedia() instanceof Book) {
                response.getMedia().setTypeMedia(TypeMedia.Book);
            } else if (persoJoin.getMedia() instanceof Magazine) {
                response.getMedia().setTypeMedia(TypeMedia.Magazine);
            } else if (persoJoin.getMedia() instanceof Movie) {
                response.getMedia().setTypeMedia(TypeMedia.Movie);
            } else if (persoJoin.getMedia() instanceof Music) {
                response.getMedia().setTypeMedia(TypeMedia.Music);
            }else if (persoJoin.getMedia() instanceof VideoGame) {
                response.getMedia().setTypeMedia(TypeMedia.VideoGame);
            } else {

            }

            persoListJoinMediaResponses.add(response);

        }
        return persoListJoinMediaResponses;
	}
    
    @PostMapping("")
    public PersoListJoinMedia create(@RequestBody PersoListJoinMedia persoListJoinMedia) {
    	persoListJoinMedia = daoPersoListJoinMedia.save(persoListJoinMedia);
        return persoListJoinMedia ;
    }
    
    
    @PutMapping("/{id}")
    public PersoListJoinMedia update(@PathVariable Integer id, @RequestBody PersoListJoinMedia persoListJoinMedia) {
        persoListJoinMedia = daoPersoListJoinMedia.save(persoListJoinMedia);
        return persoListJoinMedia;
    }

   
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!daoPersoListJoinMedia.existsById(id)) {
        	throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            daoPersoListJoinMedia.deleteById(id);
        }
    }
}	

