package mediatheque.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import mediatheque.dao.IDAOPersoListJoinMedia;
import mediatheque.model.PersoListJoinMedia;

@RestController
@RequestMapping("/api/persoListJoinMedia")
public class PersoListJoinMediaApiController {

	private IDAOPersoListJoinMedia daoPersoListJoinMedia;
	
	public PersoListJoinMediaApiController(IDAOPersoListJoinMedia daoPersoListJoinMedia) {
		super();
		this.daoPersoListJoinMedia = daoPersoListJoinMedia;
	}
	

    @GetMapping("")
    public List<PersoListJoinMedia> findAll() {
    	return daoPersoListJoinMedia.findAll();
    }
    

    @GetMapping("/{id}")
    public PersoListJoinMedia findById(@PathVariable Integer id) {
        return daoPersoListJoinMedia.findById(id).get();
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

