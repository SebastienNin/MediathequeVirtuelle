package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import mediatheque.model.Book;
import mediatheque.model.Media;


public interface IDAOMedia extends JpaRepository<Media,Integer> {

	List<Media> findByName(String name);
	
	@Query("select b from Book b")
	List<Book> findAllBook();

	List<Media> findByNameContaining(String name);
}
