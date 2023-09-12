package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.VideoGame;

public interface IDAOVideoGame extends JpaRepository<VideoGame,Integer>{

}
