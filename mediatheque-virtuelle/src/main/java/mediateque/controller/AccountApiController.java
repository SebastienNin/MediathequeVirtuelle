package mediateque.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
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

import jakarta.validation.Valid;
import mediatheque.dao.IDAOAccount;
import mediatheque.model.Account;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {
	@Autowired
	private IDAOAccount daoAccount;

	public AccountApiController(IDAOAccount daoAccount) {
		super();
		this.daoAccount = daoAccount;
	}

	@GetMapping("")
	public List<Account> findAll() {
		return daoAccount.findAll();
	}

	@GetMapping("/{id}")
	public Account findById(@PathVariable Integer id) {
		return daoAccount.findById(id).get();
	}

	@PostMapping("")
	public Account create(@Valid @RequestBody Account account, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account invalide");
		}

		account = daoAccount.save(account);

		return account;
	}

	@PutMapping("/{id}")
	public Account update(@RequestBody Account account, @PathVariable Integer id) {
		account = daoAccount.save(account);

		return account;
	}

	@PatchMapping("/{id}")
	public Account partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id) {
		Account account = this.daoAccount.findById(id).get();
		
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Account.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, account, value);
		});
		
		Account accountReturn = daoAccount.save(account);
		
		return accountReturn;
	}

	@DeleteMapping("/{id}")
	public void remove(@PathVariable Integer id) {
		if(!daoAccount.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoAccount.deleteById(id);
	}
}

