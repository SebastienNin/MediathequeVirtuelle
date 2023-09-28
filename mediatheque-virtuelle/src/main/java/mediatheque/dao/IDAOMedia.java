package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mediatheque.model.Book;
import mediatheque.model.Media;
import mediatheque.model.Movie;


public interface IDAOMedia extends JpaRepository<Media,Integer> {

	List<Media> findByName(String name);
	
	@Query("select b from Book b")
	List<Book> findAllBook();
	
	@Query("select m from Movie m")
	List<Movie> findAllMovie();

	List<Media> findByNameContaining(String name);

	List<Media> findMediaByMediaType(@Param("type") String type);

	List<Media> findMediaByMediaTypeAndNameContaining(String type, String name);
}
