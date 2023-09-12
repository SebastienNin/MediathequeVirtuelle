package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Movie;

public interface IDAOMovie extends JpaRepository<Movie, Integer>{

}
