package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.AccountMedia;

public interface IDAOAccountMedia extends JpaRepository<AccountMedia, Integer>{

}
