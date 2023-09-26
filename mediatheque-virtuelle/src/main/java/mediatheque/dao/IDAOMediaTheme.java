package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Media;
import mediatheque.model.MediaTheme;

public interface IDAOMediaTheme extends JpaRepository<MediaTheme, Integer>{

	List<MediaTheme> findByMedia(Media media);
	
}
