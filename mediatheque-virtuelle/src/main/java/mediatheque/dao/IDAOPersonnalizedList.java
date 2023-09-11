package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mediatheque.model.Account;
import mediatheque.model.PersonnalizedList;

public interface IDAOPersonnalizedList extends JpaRepository<PersonnalizedList, Integer>{

	public List<PersonnalizedList> findByAccount(Account account);
	
	public List<PersonnalizedList> findByNameAndAccount(String name, Account account);
}
