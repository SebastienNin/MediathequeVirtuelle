package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.MediaTheme;

public interface IDAOMediaTheme extends JpaRepository<MediaTheme, Integer>{

}
