package mediatheque.controller;

import java.util.List;

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
import mediatheque.dao.IDAOAccount;
import mediatheque.dao.IDAOPersoListJoinMedia;
import mediatheque.dao.IDAOPersonnalizedList;
import mediatheque.model.Account;
import mediatheque.model.PersoListJoinMedia;
import mediatheque.model.PersonnalizedList;

@RestController
@CrossOrigin
@RequestMapping("/api/persoListJoinMedia")
public class PersoListJoinMediaApiController {
	@Autowired
	private IDAOPersoListJoinMedia daoPersoListJoinMedia;
	@Autowired
	private IDAOPersonnalizedList daoPersonnalizedList;
	@Autowired
	private IDAOAccount daoAccount;
	
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
    
    @GetMapping("/persoList/{persoListId}")
	@Transactional 
	public List<PersoListJoinMedia> findByPersoListId(@PathVariable Integer persoListId) {
		PersonnalizedList persoList = this.daoPersonnalizedList.findById(persoListId).get();
		return this.daoPersoListJoinMedia.findByPersoList(persoList);
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

