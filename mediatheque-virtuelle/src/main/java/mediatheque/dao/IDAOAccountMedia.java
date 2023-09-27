package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Account;
import mediatheque.model.AccountMedia;

public interface IDAOAccountMedia extends JpaRepository<AccountMedia, Integer>{
	
	public List<AccountMedia> findByAccount(Account account);

}
