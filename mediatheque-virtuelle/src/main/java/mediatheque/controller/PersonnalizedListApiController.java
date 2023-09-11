package mediatheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import mediatheque.dao.IDAOAccount;
import mediatheque.dao.IDAOPersoListJoinMedia;
import mediatheque.dao.IDAOPersonnalizedList;
import mediatheque.model.Account;
import mediatheque.model.PersonnalizedList;
import mediatheque.model.Views;

@RestController
@RequestMapping("/api/persolist")
public class PersonnalizedListApiController {
	
	@Autowired
	private IDAOPersonnalizedList daoPersoList;
	
	@Autowired
	private IDAOPersoListJoinMedia daoPersoListJoinMedia;
	
	@Autowired
	private IDAOAccount daoAccount;
	
	@GetMapping
	@JsonView(Views.PersoList.class)
	public List<PersonnalizedList> findAll() {
		return daoPersoList.findAll();
	}
	
	@GetMapping("/{accountId}")
	@JsonView(Views.PersoList.class)
	public List<PersonnalizedList> findListByAccount(@PathVariable Integer accountId) {
		Account account = daoAccount.findById(accountId).get();
		return daoPersoList.findByAccount(account);
	}
	
	@GetMapping("/{accountId}/{name}")
	@JsonView(Views.PersoList.class)
	public List<PersonnalizedList> findListByNameAndAccount(@PathVariable Integer accountId, @PathVariable String name) {
		Account account = daoAccount.findById(accountId).get();
		
		return daoPersoList.findByNameAndAccount(name, account);
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.PersoList.class)
	public PersonnalizedList findById(@PathVariable Integer id) {
		return daoPersoList.findById(id).get();
	}
	
	@PostMapping
	@JsonView(Views.PersoList.class)
	public PersonnalizedList add(@RequestBody PersonnalizedList persoList) {
		return daoPersoList.save(persoList);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.PersoList.class)
	public PersonnalizedList edit(@PathVariable Integer id, @RequestBody PersonnalizedList persoList) {
		persoList.setId(id);
		return this.add(persoList);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		this.daoPersoList.deleteById(id);
	}
}
