package mediatheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import mediatheque.dao.IDAOAccount;
import mediatheque.dao.IDAOAccountMedia;
import mediatheque.dao.IDAOMedia;
import mediatheque.dao.IDAOMediaTheme;
import mediatheque.dao.IDAOPersoListJoinMedia;
import mediatheque.dao.IDAOPersonnalizedList;
import mediatheque.dao.IDAOTheme;
import mediatheque.model.Account;
import mediatheque.model.AccountMedia;
import mediatheque.model.BoardGame;
import mediatheque.model.Book;
import mediatheque.model.BookType;
import mediatheque.model.EnumTheme;
import mediatheque.model.Magazine;
import mediatheque.model.MagazinePeriodicity;
import mediatheque.model.MediaTheme;
import mediatheque.model.Movie;
import mediatheque.model.MovieSupport;
import mediatheque.model.Music;
import mediatheque.model.MusicSupport;
import mediatheque.model.PersoListJoinMedia;
import mediatheque.model.PersonnalizedList;
import mediatheque.model.Theme;
import mediatheque.model.VideoGame;

@SpringBootTest
@Rollback
class MediathequeVirtuelleApplicationTests {

	@Autowired
	IDAOAccount daoAccount;
	@Autowired
	IDAOAccountMedia daoAccountMedia;
	@Autowired
	IDAOMedia daoMedia;
	@Autowired
	IDAOMediaTheme daoMediaTheme;
	@Autowired
	IDAOPersoListJoinMedia daoPersoListJoinMedia;
	@Autowired
	IDAOPersonnalizedList daoPersonnalizedList;
	@Autowired
	IDAOTheme daoTheme;

	@Test
	void contextLoads() {

		// Create some objects | Start
		Account user1 = new Account("user1", "user1", "Abid", "Jordan", "jordan.abid@jesaispas.fr", true);
		Account user2 = new Account("user2", "user2", "Doe", "John", "john.doe@jesaispas.fr", false);

		BoardGame bg1 = new BoardGame("Terraforming Mars", "Fryxgames", "Français", "image_boite",
				"L'ère de la domestication de Mars a commencé. Dans Terraforming Mars, de puissantes corporations travaillent pour rendre la Planète Rouge habitable. La température, l'oxygène et les océans sont les trois axes de développement principaux. Mais pour triompher, il faudra aussi construire des infrastructures pour les générations futures.",
				false, LocalDate.parse("2016-01-01"), LocalDate.now(), "1-5", 12, 60);

		VideoGame vg1 = new VideoGame("Zelda : Tears of the Kingdom", "Nintendo", "Français", "Jaquette_totk",
				"Link fait joujou avec des armes et oublie zelda encore une fois", false, LocalDate.parse("2023-05-12"),
				LocalDate.now(), 12, false);

		Book book1 = new Book("Tintin en Amérique", "Casterman", "français", "Image Tintin", "Tintin va en amérique",
				false, LocalDate.parse("1946-07-01"), LocalDate.now(), "Hergé", "2-203-00102-X", 62, 0, BookType.BD);

		Magazine magazine1 = new Magazine("Elle", "Défense de la France", "français", "Image Elle", "Magazine féminin",
				false, LocalDate.parse("2023-04-20"), LocalDate.now(), "0013-6298", 4035,
				MagazinePeriodicity.HEBDOMADAIRE);

		Music music1 = new Music("Truth is a beautiful thing", "Ministry of Sound Recordings", "français",
				"jaquette_truthIsABeautifulThing", "", true, LocalDate.parse("2017-01-01"), LocalDate.now(),
				"London Grammar", 79, 18, MusicSupport.NOSUPPORT);

		List<String> movieDirectors = new ArrayList();
		Collections.addAll(movieDirectors, "Greta Gerwig");
		List<String> movieActors = new ArrayList();
		Collections.addAll(movieActors, "Margot Robbie, Ryan Gosling");
		Movie movie1 = new Movie("Barbie", "Warner Bros. Pictures", "Français", "logo_film_barbie",
				"A Barbie Land, vous êtes un être parfait dans un monde parfait. Sauf si vous êtes en crise existentielle, ou si vous êtes Ken.",
				false, LocalDate.parse("2023-07-19"), LocalDate.now(), 115, MovieSupport.NOSUPPORT);
		movie1.setActors(movieActors);
		movie1.setDirectors(movieDirectors);
		// Create some objects | Stop

		// Try to insert in database
		user1 = daoAccount.save(user1);
		user2 = daoAccount.save(user2);
		bg1 = daoMedia.save(bg1);
		vg1 = daoMedia.save(vg1);
		book1 = daoMedia.save(book1);
		magazine1 = daoMedia.save(magazine1);
		movie1 = daoMedia.save(movie1);
		music1 = daoMedia.save(music1);

		// Create some Themes for each kind of Media | Start
		// BoardGame
		Theme bg1Theme1 = new Theme("Stratégie", EnumTheme.BOARDGAME);
		Theme bg1Theme2 = new Theme("Gestion", EnumTheme.BOARDGAME);
		bg1Theme1 = daoTheme.save(bg1Theme1);
		bg1Theme2 = daoTheme.save(bg1Theme2);
		MediaTheme bg1MediaTheme1 = new MediaTheme(bg1, bg1Theme1);
		MediaTheme bg1MediaTheme2 = new MediaTheme(bg1, bg1Theme2);
		bg1MediaTheme1 = daoMediaTheme.save(bg1MediaTheme1);
		bg1MediaTheme2 = daoMediaTheme.save(bg1MediaTheme2);
		Collections.addAll(bg1.getMediaThemeList(), bg1MediaTheme1, bg1MediaTheme2);
		bg1Theme1.getMediaThemeList().add(bg1MediaTheme1);
		bg1Theme2.getMediaThemeList().add(bg1MediaTheme2);
		bg1 = daoMedia.save(bg1);
		// VideoGame
		Theme vg1Theme1 = new Theme("Action-Aventure", EnumTheme.VIDEOGAME);
		Theme vg1Theme2 = new Theme("Monde ouvert", EnumTheme.VIDEOGAME);
		vg1Theme1 = daoTheme.save(vg1Theme1);
		vg1Theme2 = daoTheme.save(vg1Theme2);
		MediaTheme vg1MediaTheme1 = new MediaTheme(vg1, vg1Theme1);
		MediaTheme vg1MediaTheme2 = new MediaTheme(vg1, vg1Theme2);
		vg1MediaTheme1 = daoMediaTheme.save(vg1MediaTheme1);
		vg1MediaTheme2 = daoMediaTheme.save(vg1MediaTheme2);
		Collections.addAll(vg1.getMediaThemeList(), vg1MediaTheme1, vg1MediaTheme2);
		vg1Theme1.getMediaThemeList().add(vg1MediaTheme1);
		vg1Theme2.getMediaThemeList().add(vg1MediaTheme2);
		vg1 = daoMedia.save(vg1);
		// Book
		Theme book1Theme1 = new Theme("Exploration", EnumTheme.BOOK);
		Theme book1Theme2 = new Theme("Action-Aventure", EnumTheme.BOOK);
		book1Theme1 = daoTheme.save(book1Theme1);
		book1Theme2 = daoTheme.save(book1Theme2);
		MediaTheme book1MediaTheme1 = new MediaTheme(book1, book1Theme1);
		MediaTheme book1MediaTheme2 = new MediaTheme(book1, book1Theme2);
		book1MediaTheme1 = daoMediaTheme.save(book1MediaTheme1);
		book1MediaTheme2 = daoMediaTheme.save(book1MediaTheme2);
		Collections.addAll(book1.getMediaThemeList(), book1MediaTheme1, book1MediaTheme2);
		book1Theme1.getMediaThemeList().add(book1MediaTheme1);
		book1Theme2.getMediaThemeList().add(book1MediaTheme2);
		book1 = daoMedia.save(book1);
		// Magazine
		Theme magazine1Theme1 = new Theme("Mode", EnumTheme.MAGAZINE);
		magazine1Theme1 = daoTheme.save(magazine1Theme1);
		MediaTheme magazine1MediaTheme1 = new MediaTheme(magazine1, magazine1Theme1);
		magazine1MediaTheme1 = daoMediaTheme.save(magazine1MediaTheme1);
		Collections.addAll(magazine1.getMediaThemeList(), magazine1MediaTheme1);
		magazine1Theme1.getMediaThemeList().add(magazine1MediaTheme1);
		magazine1 = daoMedia.save(magazine1);
		// Movie
		Theme movie1Theme1 = new Theme("Comédie", EnumTheme.MOVIE);
		Theme movie1Theme2 = new Theme("Famille", EnumTheme.MOVIE);
		movie1Theme1 = daoTheme.save(movie1Theme1);
		movie1Theme2 = daoTheme.save(movie1Theme2);
		MediaTheme movie1MediaTheme1 = new MediaTheme(movie1, movie1Theme1);
		MediaTheme movie1MediaTheme2 = new MediaTheme(movie1, movie1Theme2);
		movie1MediaTheme1 = daoMediaTheme.save(movie1MediaTheme1);
		movie1MediaTheme2 = daoMediaTheme.save(movie1MediaTheme2);
		Collections.addAll(movie1.getMediaThemeList(), movie1MediaTheme1, movie1MediaTheme2);
		movie1Theme1.getMediaThemeList().add(movie1MediaTheme1);
		movie1Theme2.getMediaThemeList().add(movie1MediaTheme2);
		movie1 = daoMedia.save(movie1);
		// Music
		Theme music1Theme1 = new Theme("Pop", EnumTheme.MUSIC);
		music1Theme1 = daoTheme.save(music1Theme1);
		MediaTheme music1MediaTheme1 = new MediaTheme(music1, music1Theme1);
		music1MediaTheme1 = daoMediaTheme.save(music1MediaTheme1);
		Collections.addAll(music1.getMediaThemeList(), music1MediaTheme1);
		music1Theme1.getMediaThemeList().add(music1MediaTheme1);
		music1 = daoMedia.save(music1);
		// Create some Themes for each kind of Media | End

		// Create some AccountMedia to link Account and Media | Start
		AccountMedia am1 = new AccountMedia(user1, bg1);
		am1 = daoAccountMedia.save(am1);
		AccountMedia am2 = new AccountMedia(user1, vg1);
		am2 = daoAccountMedia.save(am2);
		AccountMedia am3 = new AccountMedia(user2, bg1);
		am3 = daoAccountMedia.save(am3);
		// Create some AccountMedia to link Account and Media | Stop

		// Create PersonnalizedList linked to an Account | Start
		PersonnalizedList pl1 = new PersonnalizedList("Liste user1", user1);
		pl1 = daoPersonnalizedList.save(pl1);
		// Create some PersoListJoinMedia to link a PersonnalizedList to a Media
		PersoListJoinMedia pljm1 = new PersoListJoinMedia(pl1, music1);
		PersoListJoinMedia pljm2 = new PersoListJoinMedia(pl1, vg1);
		PersoListJoinMedia pljm3 = new PersoListJoinMedia(pl1, bg1);
		pljm1 = daoPersoListJoinMedia.save(pljm1);
		pljm2 = daoPersoListJoinMedia.save(pljm2);
		pljm3 = daoPersoListJoinMedia.save(pljm3);
//		Collections.addAll(pl1.getMediaList(), pljm1, pljm2, pljm3);

		PersonnalizedList pl2 = new PersonnalizedList("Liste user2", user2);
		pl2 = daoPersonnalizedList.save(pl2);
		PersoListJoinMedia pljm4 = new PersoListJoinMedia(pl2, book1);
		PersoListJoinMedia pljm5 = new PersoListJoinMedia(pl2, movie1);
		PersoListJoinMedia pljm6 = new PersoListJoinMedia(pl2, magazine1);
		pljm4 = daoPersoListJoinMedia.save(pljm4);
		pljm5 = daoPersoListJoinMedia.save(pljm5);
		pljm6 = daoPersoListJoinMedia.save(pljm6);
		
		//Create Theme for all Types of Media |Start
		Theme bookTheme = new Theme("Romance", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Policier-polar", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Thriller", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Fantastique", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Historique", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Science-fiction", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Fantasy", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Contemporain", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		bookTheme = new Theme("Classique", EnumTheme.BOOK);
		bookTheme = daoTheme.save(bookTheme);
		
		Theme movieTheme = new Theme("Comédie Romantique", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Action-Aventure", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Drame", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Comédie", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Science-fiction", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Thriller", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Horreur", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		movieTheme = new Theme("Film d'animation", EnumTheme.MOVIE);
		movieTheme = daoTheme.save(movieTheme);
		
		Theme musicTheme = new Theme("Classique", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		musicTheme = new Theme("Variété française et internationale", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		musicTheme = new Theme("Rap-Hip-hop", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		musicTheme = new Theme("Jazz", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		musicTheme = new Theme("Rock-punk-métal", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		musicTheme = new Theme("Rock-punk-métal", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		musicTheme = new Theme("Bande originale film et animation", EnumTheme.MUSIC);
		musicTheme = daoTheme.save(musicTheme);
		
		Theme jvTheme = new Theme("Plateforme", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		jvTheme = new Theme("Simulation", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		jvTheme = new Theme("Gestion", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		jvTheme = new Theme("Sport", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		jvTheme = new Theme("RPG", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		jvTheme = new Theme("Exploration", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		jvTheme = new Theme("Sandbox", EnumTheme.VIDEOGAME);
		jvTheme = daoTheme.save(jvTheme);
		
		Theme bgTheme = new Theme("Plateau", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		bgTheme = new Theme("Cartes", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		bgTheme = new Theme("Ambiance", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		bgTheme = new Theme("Culture générale", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		bgTheme = new Theme("RPG", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		bgTheme = new Theme("Exploration", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		bgTheme = new Theme("Coopération", EnumTheme.BOARDGAME);
		bgTheme = daoTheme.save(bgTheme);
		
		Theme magTheme = new Theme("High-tech", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		magTheme = new Theme("Voitures", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		magTheme = new Theme("Actualités-politique", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		magTheme = new Theme("Sciences", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		magTheme = new Theme("Voyage-nature", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		magTheme = new Theme("Jeux", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		magTheme = new Theme("Enfants", EnumTheme.MAGAZINE);
		magTheme = daoTheme.save(magTheme);
		
	}

}
