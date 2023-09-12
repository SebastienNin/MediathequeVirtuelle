package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.BoardGame;
import mediatheque.model.Media;

public interface IDAOBoardGame extends JpaRepository<BoardGame, Integer>{

	List<BoardGame> findByName(String name);

}
