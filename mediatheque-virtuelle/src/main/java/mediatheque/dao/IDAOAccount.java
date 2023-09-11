package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Account;

public interface IDAOAccount extends JpaRepository<Account, Integer>{

}
