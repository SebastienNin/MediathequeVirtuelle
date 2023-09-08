package mediatheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import mediatheque.model.Account;
import mediatheque.model.BoardGame;
import mediatheque.model.Book;
import mediatheque.model.BookType;
import mediatheque.model.Magazine;
import mediatheque.model.MagazinePeriodicity;
import mediatheque.model.Movie;
import mediatheque.model.MovieSupport;
import mediatheque.model.Music;
import mediatheque.model.MusicSupport;
import mediatheque.model.VideoGame;

@SpringBootTest
class MediathequeVirtuelleApplicationTests {

	@Test
	void contextLoads() {
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

	}

}
