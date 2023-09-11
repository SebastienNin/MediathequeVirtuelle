package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Theme;

public interface IDAOTheme extends JpaRepository<Theme, Integer>{

}
