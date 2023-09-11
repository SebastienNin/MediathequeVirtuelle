package mediatheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
class MediathequeVirtuelleApplicationTests {
//
//	@Autowired
//	IDAOAccount daoAccount;
//	@Autowired
//	IDAOAccountMedia daoAccountMedia;
//	@Autowired
//	IDAOMedia daoMedia;
//	@Autowired
//	IDAOMediaTheme daoMediaTheme;
//	@Autowired
//	IDAOPersoListJoinMedia daoPersoListJoinMedia;
//	@Autowired
//	IDAOPersonnalizedList daoPersonnalizedList;
//	@Autowired
//	IDAOTheme daoTheme;

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
//		daoAccount.save(user1);
//		daoAccount.save(user2);
//		daoMedia.save(bg1);
//		daoMedia.save(vg1);
//		daoMedia.save(book1);
//		daoMedia.save(magazine1);
//		daoMedia.save(music1);
//		daoMedia.save(movie1);
		
		// Create some Themes for each kind of Media | Start
		// BoardGame
		Theme bg1Theme1 = new Theme("Stratégie", EnumTheme.BOARDGAME);
		Theme bg1Theme2 = new Theme("Gestion", EnumTheme.BOARDGAME);
		MediaTheme bg1MediaTheme1 = new MediaTheme(bg1, bg1Theme1);
		MediaTheme bg1MediaTheme2 = new MediaTheme(bg1, bg1Theme2);
		Collections.addAll(bg1.getMediaThemeList(), bg1MediaTheme1, bg1MediaTheme2);
		bg1Theme1.getMediaThemeList().add(bg1MediaTheme1);
		bg1Theme2.getMediaThemeList().add(bg1MediaTheme2);
		// VideoGame
		Theme vg1Theme1 = new Theme("Action", EnumTheme.VIDEOGAME);
		Theme vg1Theme2 = new Theme("Aventure", EnumTheme.VIDEOGAME);
		MediaTheme vg1MediaTheme1 = new MediaTheme(vg1, vg1Theme1);
		MediaTheme vg1MediaTheme2 = new MediaTheme(vg1, vg1Theme2);
		Collections.addAll(vg1.getMediaThemeList(), vg1MediaTheme1, vg1MediaTheme2);
		vg1Theme1.getMediaThemeList().add(vg1MediaTheme1);
		vg1Theme2.getMediaThemeList().add(vg1MediaTheme2);
		// Book
		Theme book1Theme1 = new Theme("Exploration", EnumTheme.BOOK);
		Theme book1Theme2 = new Theme("Aventure", EnumTheme.BOOK);
		MediaTheme book1MediaTheme1 = new MediaTheme(book1, book1Theme1);
		MediaTheme book1MediaTheme2 = new MediaTheme(book1, book1Theme2);
		Collections.addAll(book1.getMediaThemeList(), book1MediaTheme1, book1MediaTheme2);
		book1Theme1.getMediaThemeList().add(book1MediaTheme1);
		book1Theme2.getMediaThemeList().add(book1MediaTheme2);
		// Magazine
		Theme magazine1Theme1 = new Theme("Mode", EnumTheme.MAGAZINE);
		MediaTheme magazine1MediaTheme1 = new MediaTheme(magazine1, magazine1Theme1);
		Collections.addAll(book1.getMediaThemeList(), magazine1MediaTheme1);
		magazine1Theme1.getMediaThemeList().add(magazine1MediaTheme1);
		// Movie
		Theme movie1Theme1 = new Theme("Comédie", EnumTheme.MOVIE);
		Theme movie1Theme2 = new Theme("Famille", EnumTheme.MOVIE);
		MediaTheme movie1MediaTheme1 = new MediaTheme(movie1, movie1Theme1);
		MediaTheme movie1MediaTheme2 = new MediaTheme(movie1, movie1Theme2);
		Collections.addAll(movie1.getMediaThemeList(), movie1MediaTheme1, movie1MediaTheme2);
		movie1Theme1.getMediaThemeList().add(movie1MediaTheme1);
		movie1Theme2.getMediaThemeList().add(movie1MediaTheme2);
		// Music
		Theme music1Theme1 = new Theme("Pop", EnumTheme.MUSIC);
		MediaTheme music1MediaTheme1 = new MediaTheme(music1, music1Theme1);
		Collections.addAll(music1.getMediaThemeList(), music1MediaTheme1);
		music1Theme1.getMediaThemeList().add(music1MediaTheme1);
		// Create some Themes for each kind of Media | End

		// Create some AccountMedia to link Account and Media | Start
		AccountMedia am1 = new AccountMedia(user1, bg1);
		AccountMedia am2 = new AccountMedia(user1, vg1);
		AccountMedia am3 = new AccountMedia(user2, bg1);
		// Add the AccountMedia to the Media bg1
		Collections.addAll(bg1.getAccountMediaList(), am1, am3);
		vg1.getAccountMediaList().add(am2);
		// Create some AccountMedia to link Account and Media | Stop

		// Create PersonnalizedList linked to an Account | Start
		PersonnalizedList pl1 = new PersonnalizedList("Liste user1", user1);
		// Create some PersoListJoinMedia to link a PersonnalizedList to a Media
		PersoListJoinMedia pljm1 = new PersoListJoinMedia(pl1, music1);
		PersoListJoinMedia pljm2 = new PersoListJoinMedia(pl1, vg1);
		PersoListJoinMedia pljm3 = new PersoListJoinMedia(pl1, bg1);
		Collections.addAll(pl1.getMediaList(), pljm1, pljm2, pljm3);

		PersonnalizedList pl2 = new PersonnalizedList("Liste user2", user2);
		PersoListJoinMedia pljm4 = new PersoListJoinMedia(pl2, book1);
		PersoListJoinMedia pljm5 = new PersoListJoinMedia(pl2, movie1);
		PersoListJoinMedia pljm6 = new PersoListJoinMedia(pl2, magazine1);
		Collections.addAll(pl2.getMediaList(), pljm4, pljm5, pljm6);
		// Create PersonnalizedList linked to an Account | Start
		

		Collections.addAll(user1.getAccountMediaList(), am1, am2);
		Collections.addAll(user2.getAccountMediaList(), am3);

		user1.getPersoLists().add(pl1);
		user2.getPersoLists().add(pl2);
	}

}
