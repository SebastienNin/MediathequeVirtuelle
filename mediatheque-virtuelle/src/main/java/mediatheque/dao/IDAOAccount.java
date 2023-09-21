package mediatheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import mediatheque.model.Account;
import mediatheque.model.PersonnalizedList;

public interface IDAOAccount extends JpaRepository<Account, Integer>{

	public List<Account> findByName(String name);

	public Optional<Account> findByLoginAndPassword(String login, String password);

}
