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

		BoardGame bg1 = new BoardGame("Terraforming Mars", "Fryxgames", "Français", "c4e78e19-5d0b-4594-a751-35473505fad8.jpg",
				"L'ère de la domestication de Mars a commencé. Dans Terraforming Mars, de puissantes corporations travaillent pour rendre la Planète Rouge habitable. La température, l'oxygène et les océans sont les trois axes de développement principaux. Mais pour triompher, il faudra aussi construire des infrastructures pour les générations futures.",
				false, LocalDate.parse("2016-01-01"), LocalDate.now(), "1-5", 12, 60);
		BoardGame bg2 = new BoardGame("Les Colons de Catane", "Jeux Descartes", "Français", "9bffeddb-e7e7-4457-9dd9-6faaaa46656e.jpg",
				"Les Colons de Catane est un jeu de société qui se compose d’un certain nombre de composants. Ces composants comprennent des cartes de développement, des pièces de bois, des cartes et des dés. Ces composants sont essentiels à l’expérience de jeu et permettent aux joueurs de développer une stratégie et des tactiques complexes.",
				false, LocalDate.parse("1995-01-01"), LocalDate.now(), "3-4", 10, 75);
		BoardGame bg3 = new BoardGame("Carcasonne", "Hans im Glück", "Allemand", "5a2e793c-48ff-4a23-b7cb-f679f9a260d2.jpg",
				"Carcassonne est un jeu de pose de tuiles, où l'on construit le plateau de jeu au cours de la partie. Des points sont attribués en fonction de la taille des combinaisons créées — villes, champs, routes, abbayes.",
				false, LocalDate.parse("2000-01-01"), LocalDate.now(), "2-5", 8, 60);

		VideoGame vg1 = new VideoGame("Zelda : Tears of the Kingdom", "Nintendo", "Français", "42ab4900-2227-4b5a-9b47-3f6ff630436b.jpg",
				"Link fait joujou avec des armes et oublie zelda encore une fois", false, LocalDate.parse("2023-05-12"),
				LocalDate.now(), 12, false);
		VideoGame vg2 = new VideoGame("Assassin's Creed Unity", "Ubisoft", "Français", "73c1a24f-8a20-43b4-82d1-5fbb49fc7b56.jpg",
				"La confrérie des Assassins se trouve à Paris avec Arno Dorian",
				false, LocalDate.parse("2014-11-13"), LocalDate.now(), 18, false);
		VideoGame vg3 = new VideoGame("Fifa 23", "Electronic Arts", "Anglais", "5acff163-5930-42aa-85fd-2b7f4661edc6.jpg",
				"FIFA 23 est un jeu vidéo de simulation de football développé par EA Vancouver et édité par Electronic Arts. Il s'agit du 30e volet de la série FIFA. Il est sorti sur Microsoft Windows, Nintendo Switch, PlayStation 4, PlayStation 5, Xbox One, Xbox Series et Google Stadia le 30 septembre 2022.",
				true, LocalDate.parse("2022-09-22"), LocalDate.now(), 3, false);

		Book book1 = new Book("Tintin en Amérique", "Casterman", "Français", "7ba05483-2ef8-4f7f-8b13-eb55c639ea82.png", "Tintin va en amérique",
				false, LocalDate.parse("1946-07-01"), LocalDate.now(), "Hergé", "2-203-00102-X", 62, 0, BookType.BD);
		Book book2 = new Book("One Piece : Romance Dawn", "Shūeisha", "Japonais", "e5bb72c5-88bf-4bd1-a420-e8cb8be4d867.jpg",
				"L'histoire de One Piece se déroule dans un monde fictif dominé par les océans, où certains pirates aspirent à une ère de liberté et d'aventure connue comme « l'âge d'or de la piraterie ». Cette époque fut inaugurée à la suite des derniers mots prononcés par le roi des pirates, Gol D. Roger, surnommé Gold Roger avant son exécution. Roger annonce au monde que ses habitants étaient libres de chercher toutes les richesses qu'il avait accumulées durant sa vie entière, le « One Piece. »",
				false, LocalDate.parse("1997-07-22"), LocalDate.now(), "Eiichirō Oda", "978-4-08-872509-3", 208, 8, BookType.MANGA);
		Book book3 = new Book("Les Misérables", "Albert Lacroix et Compagnie", "Français", "160995e0-2c8c-4559-90b9-920bb5bc37ce.jpg",
				"Les Misérables est un roman de Victor Hugo publié en 1862, l’un des plus vastes et des plus notables de la littérature du xixe siècle.\r\n"
				+ "\r\n"
				+ "Il décrit la vie de pauvres gens dans Paris et la France provinciale du premier tiers du xixe siècle, l’auteur s'attachant plus particulièrement au destin du bagnard Jean Valjean ; il a donné lieu à de nombreuses adaptations, au cinéma et sur d’autres supports.",
				false, LocalDate.parse("1862-01-01"), LocalDate.now(), "Victor Hugo", "978-2-401-07846-8", 2598, 48, BookType.ROMAN);
				
		Magazine magazine1 = new Magazine("Elle", "Défense de la France", "Français", "dfcad18d-dc61-47e3-b4da-c3c44bfec3f3.jpg", "Magazine féminin",
				false, LocalDate.parse("2023-04-20"), LocalDate.now(), "0013-6298", 4035,
				MagazinePeriodicity.HEBDOMADAIRE);
		Magazine magazine2 = new Magazine("Rolling Stone", "", "Français", "c66d9514-0553-436e-ba94-d70b4c0419f7.jpg", "Magazine musique",
				false, LocalDate.parse("2023-01-20"), LocalDate.now(), "0035-791X", 400,
				MagazinePeriodicity.MENSUEL);

		Music music1 = new Music("Truth is a beautiful thing", "Ministry of Sound Recordings", "Français",
				"eef8cc53-a35f-4e25-b760-b6a62a030b4a.jpg", "", true, LocalDate.parse("2017-01-01"), LocalDate.now(),
				"London Grammar", 79, 18, MusicSupport.NOSUPPORT);
		Music music2 = new Music("Tea for the Tillerman", "Island", "Anglais",
				"3ab05e07-b00b-441c-9b3e-8c4b5b2e5383.jpg", "", true, LocalDate.parse("1970-11-23"), LocalDate.now(),
				"Cat Stevens", 37, 11, MusicSupport.NOSUPPORT);
		Music music3 = new Music("Hot Space", "EMI Elektra", "Anglais",
				"9f0ab4c3-e08e-49fc-8c67-9bba8a5698b4.png", "", true, LocalDate.parse("1981-01-01"), LocalDate.now(),
				"Queen", 43, 6, MusicSupport.NOSUPPORT);
		
		List<String> movieDirectors2 = new ArrayList<String>();
		Collections.addAll(movieDirectors2, "Peter Jackson");
		List<String> movieActors2 = new ArrayList<String>();
		Collections.addAll(movieActors2, "Elijah Wood, Viggo Mortensen");
		Movie movie2 = new Movie("Le Seigneur des Anneaux - Le retour du Roi", "New Line Cinema", "Français", "90f79325-5e95-4e4a-83d7-eb521d40bf53.jpg",
				"A Barbie Land, vous êtes un être parfait dans un monde parfait. Sauf si vous êtes en crise existentielle, ou si vous êtes Ken.",
				false, LocalDate.parse("2023-07-19"), LocalDate.now(), 115, MovieSupport.NOSUPPORT);
		movie2.setActors(movieActors2);
		movie2.setDirectors(movieDirectors2);
		
		List<String> movieDirectors = new ArrayList<String>();
		Collections.addAll(movieDirectors, "Greta Gerwig");
		List<String> movieActors = new ArrayList<String>();
		Collections.addAll(movieActors, "Margot Robbie, Ryan Gosling");
		Movie movie1 = new Movie("Barbie", "Warner Bros. Pictures", "Français", "a6fb0a41-4299-47a4-bb39-3b20b9ccfd80.png",
				"La première scène du film montre les Hobbits Sméagol et Déagol qui pêchent sur le fleuve, quand Déagol, qui a fait une prise, est entrainé dans l'eau par le poisson. Sous l'eau, Déagol est attiré par l'Anneau unique qui gît au fond, le ramasse et revient à la surface. Sméagol le rejoint, voit l'Anneau que son ami a récupéré et lui demande de le lui donner. Mais devant le refus de Déagol, les deux amis se battent et Sméagol étrangle mortellement son ami. Il est désormais lié à l'anneau, mais cela aura pour conséquence son bannissement par sa tribu. Devenant Gollum, il se réfugie dans les Monts Brumeux, vivant seul à l'état sauvage pendant près de cinq cents ans. ",
				false, LocalDate.parse("2003-07-19"), LocalDate.now(), 263, MovieSupport.NOSUPPORT);
		movie1.setActors(movieActors);
		movie1.setDirectors(movieDirectors);
		// Create some objects | Stop

		// Try to insert in database
		user1 = daoAccount.save(user1);
		user2 = daoAccount.save(user2);
		bg1 = daoMedia.save(bg1);
		bg2 = daoMedia.save(bg2);
		bg3 = daoMedia.save(bg3);
		vg1 = daoMedia.save(vg1);
		vg2 = daoMedia.save(vg2);
		vg3 = daoMedia.save(vg3);
		book1 = daoMedia.save(book1);
		book2 = daoMedia.save(book2);
		book3 = daoMedia.save(book3);
		magazine1 = daoMedia.save(magazine1);
		magazine2 = daoMedia.save(magazine2);
		movie1 = daoMedia.save(movie1);
		movie2 = daoMedia.save(movie2);
		music1 = daoMedia.save(music1);
		music2 = daoMedia.save(music2);
		music3 = daoMedia.save(music3);

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
		Theme magazine1Theme2 = new Theme("Actualités-politique", EnumTheme.MAGAZINE);
		magazine1Theme2 = daoTheme.save(magazine1Theme2);
		MediaTheme magazine1MediaTheme2 = new MediaTheme(magazine2, magazine1Theme2);
		magazine1MediaTheme2 = daoMediaTheme.save(magazine1MediaTheme2);
		Collections.addAll(magazine2.getMediaThemeList(), magazine1MediaTheme2);
		magazine1Theme2.getMediaThemeList().add(magazine1MediaTheme2);
		magazine2 = daoMedia.save(magazine2);
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
		Theme movie1Theme3 = new Theme("Science-fiction", EnumTheme.MOVIE);
		movie1Theme3 = daoTheme.save(movie1Theme3);
		MediaTheme movie1MediaTheme3 = new MediaTheme(movie2, movie1Theme3);
		movie1MediaTheme3 = daoMediaTheme.save(movie1MediaTheme3);
		Collections.addAll(movie1.getMediaThemeList(), movie1MediaTheme3);
		movie1Theme3.getMediaThemeList().add(movie1MediaTheme3);
		movie2 = daoMedia.save(movie2);
		// Music
		Theme music1Theme1 = new Theme("Pop", EnumTheme.MUSIC);
		music1Theme1 = daoTheme.save(music1Theme1);
		MediaTheme music1MediaTheme1 = new MediaTheme(music1, music1Theme1);
		music1MediaTheme1 = daoMediaTheme.save(music1MediaTheme1);
		Collections.addAll(music1.getMediaThemeList(), music1MediaTheme1);
		music1Theme1.getMediaThemeList().add(music1MediaTheme1);
		music1 = daoMedia.save(music1);
		
		Theme music1Theme2 = new Theme("Rock-punk-métal", EnumTheme.MUSIC);
		music1Theme2 = daoTheme.save(music1Theme2);
		MediaTheme music1MediaTheme2 = new MediaTheme(music2, music1Theme2);
		music1MediaTheme2 = daoMediaTheme.save(music1MediaTheme2);
		Collections.addAll(music2.getMediaThemeList(), music1MediaTheme2);
		music1Theme2.getMediaThemeList().add(music1MediaTheme2);
		music1 = daoMedia.save(music2);
		
		Theme music1Theme3 = new Theme("Rock-punk-métal", EnumTheme.MUSIC);
		music1Theme3 = daoTheme.save(music1Theme3);
		MediaTheme music1MediaTheme3 = new MediaTheme(music3, music1Theme3);
		music1MediaTheme3 = daoMediaTheme.save(music1MediaTheme3);
		Collections.addAll(music3.getMediaThemeList(), music1MediaTheme3);
		music1Theme3.getMediaThemeList().add(music1MediaTheme3);
		music3 = daoMedia.save(music3);
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
