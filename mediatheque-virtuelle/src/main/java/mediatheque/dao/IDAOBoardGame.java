package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.BoardGame;

public interface IDAOBoardGame extends JpaRepository<BoardGame, Integer>{

}
