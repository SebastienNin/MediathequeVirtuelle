package mediatheque.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

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
import mediatheque.dao.IDAOAccountMedia;
import mediatheque.model.AccountMedia;

@RestController
@RequestMapping("/api/accountmedia")
public class AccountMediaApiController {

	private IDAOAccountMedia daoAccountMedia;

	public AccountMediaApiController(IDAOAccountMedia daoAccountMedia) {
		super();
		this.daoAccountMedia = daoAccountMedia;
	}

	@GetMapping("/")
	public List<AccountMedia> findAll() {
		return daoAccountMedia.findAll();
	}

	@GetMapping("/{id}")
	public AccountMedia findById(@PathVariable Integer id) {
		return daoAccountMedia.findById(id).get();
	}

	@PostMapping("/")
	public AccountMedia create(@Valid @RequestBody AccountMedia accountmedia, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "AccountMedia invalide");
		}

		accountmedia = daoAccountMedia.save(accountmedia);

		return accountmedia;
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

