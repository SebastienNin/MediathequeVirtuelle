package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Media;


public interface IDAOMedia extends JpaRepository<Media,Integer> {

}
