package mediatheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mediatheque.model.Magazine;

public interface IDAOMagazine extends JpaRepository<Magazine, Integer>{

}
