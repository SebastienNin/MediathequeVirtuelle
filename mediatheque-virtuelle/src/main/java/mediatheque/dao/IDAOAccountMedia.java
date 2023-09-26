package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.AccountMedia;

public interface IDAOAccountMedia extends JpaRepository<AccountMedia, Integer>{
	
	List<AccountMedia> findByAccount(Integer idAccount);

}
