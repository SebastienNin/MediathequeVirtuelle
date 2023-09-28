package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.PersoListJoinMedia;
import mediatheque.model.PersonnalizedList;


public interface IDAOPersoListJoinMedia extends JpaRepository<PersoListJoinMedia, Integer>{

	public List<PersoListJoinMedia> findByPersoList(PersonnalizedList persoList);

}
