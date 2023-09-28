package mediatheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mediatheque.model.Account;
import mediatheque.model.AccountMedia;
import mediatheque.model.Media;

public interface IDAOAccountMedia extends JpaRepository<AccountMedia, Integer>{
	
	public List<AccountMedia> findByAccount(Account account);
	
	@Query("SELECT am.media FROM AccountMedia am WHERE am.account.id = :id")
	public List<Media> findMediaByAccountId(@Param("id") Integer id);
	
    @Modifying
    @Query("DELETE FROM AccountMedia am WHERE am.media.id = :mediaId")
    void deleteByMediaId(@Param("mediaId") Integer mediaId);

}
