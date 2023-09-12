package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Book;

public interface IDAOBook extends JpaRepository<Book, Integer>{

}
