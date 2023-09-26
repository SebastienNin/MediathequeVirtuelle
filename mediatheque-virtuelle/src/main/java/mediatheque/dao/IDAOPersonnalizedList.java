package mediatheque.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Account;
import mediatheque.model.PersonnalizedList;

public interface IDAOPersonnalizedList extends JpaRepository<PersonnalizedList, Integer>{
	
	public List<PersonnalizedList> findByAccount(Account account);


}
