package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mediatheque.model.EnumTheme;
import mediatheque.model.Media;
import mediatheque.model.Theme;

public interface IDAOTheme extends JpaRepository<Theme, Integer>{
	
	List<Theme> findByEnumTheme(EnumTheme type);
	
	List<Theme> findByLabel(String label);
	
	Theme findByLabelAndEnumTheme(String label, EnumTheme type);

//	List<MediaTheme> findByMediaThemeList(String label);
	@Query("SELECT mt.media FROM MediaTheme mt WHERE mt.theme.label = :label")
	List<Media> findMediaByThemeLabel(@Param("label") String label);

}
