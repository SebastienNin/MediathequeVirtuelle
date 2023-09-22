package mediatheque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/api/personnalizedList")
public class PersonnalizedListApiController {
	
	@Autowired
	private IDAOPersonnalizedList daoPersonnalizedList;
	
	@Autowired
	private IDAOAccount daoAccount;
	
	public PersonnalizedListApiController(IDAOPersonnalizedList daoPersonnalizedList) {
		super();
		this.daoPersonnalizedList = daoPersonnalizedList;
	}
	
	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<PersonnalizedList> findAll() {
		return daoPersonnalizedList.findAll();
	}
	
	@GetMapping("/account/{accountId}")
	@JsonView(Views.PersoList.class)
	public List<PersonnalizedList> findListByAccount(@PathVariable Integer accountId) {
		Account account = daoAccount.findById(accountId).get();
		return daoPersonnalizedList.findByAccount(account);
	}
	
	@GetMapping("/{accountId}/{name}")
	@JsonView(Views.PersoList.class)
	public List<PersonnalizedList> findListByNameAndAccount(@PathVariable Integer accountId, @PathVariable String name) {
		Account account = daoAccount.findById(accountId).get();
		
		return daoPersonnalizedList.findByNameAndAccount(name, account);
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public PersonnalizedList findById(@PathVariable Integer id) {
		return daoPersonnalizedList.findById(id).get();
	}
	
	@PostMapping
	@JsonView(Views.PersoList.class)
	public PersonnalizedList add(@RequestBody PersonnalizedList persoList) {
		return daoPersonnalizedList.save(persoList);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.PersoList.class)
	public PersonnalizedList edit(@PathVariable Integer id, @RequestBody PersonnalizedList persoList) {
		persoList.setId(id);
		return this.add(persoList);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		this.daoPersonnalizedList.deleteById(id);
	}
}
