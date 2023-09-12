package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Music;

public interface IDAOMusic extends JpaRepository<Music, Integer>{

}
