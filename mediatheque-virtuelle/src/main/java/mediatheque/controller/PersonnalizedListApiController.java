package mediatheque.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.fasterxml.jackson.annotation.JsonView;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mediatheque.controller.request.PersonnalizedListRequest;
import mediatheque.controller.response.PersonnalizedListDetailResponse;
import mediatheque.dao.IDAOAccount;
import mediatheque.dao.IDAOPersonnalizedList;
import mediatheque.exception.PersonnalizedListNotFoundException;
import mediatheque.exception.PersonnalizedListNotValidException;
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
	
	
	@GetMapping("")
	
	public List<PersonnalizedList> findAll() {
		return daoPersonnalizedList.findAll();
	}
	
	@GetMapping("/{id}")
	@Transactional 
	public PersonnalizedListDetailResponse findById(@PathVariable Integer id) {
		PersonnalizedList personnalizedList = this.daoPersonnalizedList.findById(id)
			    .orElseThrow(PersonnalizedListNotFoundException::new);
		PersonnalizedListDetailResponse response = new PersonnalizedListDetailResponse();

		BeanUtils.copyProperties(personnalizedList, response);

		response.setAccount(personnalizedList.getAccount());
		System.out.println(response);

		return response;
	}
	
	@GetMapping("/account/{accountId}")
	@Transactional 
	public List<PersonnalizedList> findByAccountId(@PathVariable Integer accountId) {
		Account account = this.daoAccount.findById(accountId).get();
		return this.daoPersonnalizedList.findByAccount(account);
	}
	
	@PostMapping("")
	@JsonView(Views.PersonnalizedList.class)
	public PersonnalizedList add(@Valid @RequestBody PersonnalizedListRequest personnalizedListRequest, BindingResult result) throws PersonnalizedListNotValidException {
	    if (result.hasErrors()) {
	        throw new PersonnalizedListNotValidException();
	    }

	    PersonnalizedList personnalizedList = new PersonnalizedList();

	    BeanUtils.copyProperties(personnalizedListRequest, personnalizedList);

	    return this.daoPersonnalizedList.save(personnalizedList);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.PersonnalizedList.class)
	public PersonnalizedList edit(@PathVariable Integer id, @Valid @RequestBody PersonnalizedListRequest personnalizedListRequest,
	        BindingResult result) throws PersonnalizedListNotValidException {
	    if (result.hasErrors()) {
	        throw new PersonnalizedListNotValidException();
	    }

	    PersonnalizedList personnalizedList = this.daoPersonnalizedList.findById(id)
	            .orElseThrow(PersonnalizedListNotFoundException::new);

	    BeanUtils.copyProperties(personnalizedListRequest, personnalizedList);

	    return this.daoPersonnalizedList.save(personnalizedList);
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		this.daoPersonnalizedList.deleteById(id);
	}
}