package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Media;


public interface IDAOMedia extends JpaRepository<Media,Integer> {

	List<Media> findByName(String name);
}
