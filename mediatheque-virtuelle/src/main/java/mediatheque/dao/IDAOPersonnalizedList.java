package mediatheque.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import mediatheque.model.PersonnalizedList;

public interface IDAOPersonnalizedList extends JpaRepository<PersonnalizedList, Integer>{


}
