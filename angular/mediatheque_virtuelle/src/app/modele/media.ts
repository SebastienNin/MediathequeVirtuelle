import { Type } from "@angular/core";
import { BookType } from "./bookType";
import { MagazinePeriodicity } from "./magazinePeriodicity";
import { MovieSupport } from "./movieSupport";
import { MusicSupport } from "./musicSupport";
import { TypeMedia } from "./typeMedia";

export class Media {

    //attributs de Media générique
    id: number;
    name: string;
    publishingHouse: string;
    language: string;
    image: string;
    description: string;
    dematerialized: boolean;
    parutionDate: string; // 2023-09-20 {{parutionDate | date:''}}
    addDate: string;

    //Attribut supplémentaire pour distinguer le type de media
    typeMedia : TypeMedia;

    //attributs de BoardGame
    playerNumber: string;
    recommendedAge: number;
    durationBoardGame : number;

    //attributs de Book
    author: string;
    ISBN: string;
    pagesNb: number;
    chaptersNb: number;
    type: BookType;

    //attributs de Magazine
    ISSN: string;
    number: number;
    periodicity: MagazinePeriodicity;

    //attributs de Movie
    directors: string[];
    actors: string[];
    durationMovie: number;
    supportMovie: MovieSupport;

    //attribut de Music
    tracks: string[];
    artist: string;
    durationMusic: number;
    tracksNumber: number;
    supportMusic: MusicSupport;

    //attributs de VideoGame
    multiPlayer: boolean;
    pegi: number;

    constructor(
        //Media
        id?: number,
        name?: string,
        publishingHouse?: string,
        language?: string,
        image?: string,
        description?: string,
        dematerialized?: boolean,
        parutionDate?: string,
        addDate?: string,
        //attribut supplémentaire
        typeMedia?: TypeMedia,
        //BoarGame
        playerNumber?: string, 
        recommendedAge? : number, 
        durationBoardGame? : number,
        //Book
        author?: string, 
        ISBN?: string, 
        pagesNb?: number, 
        chaptersNb?: number, 
        type?: BookType,
        //Magazine
        ISSN?: string, 
        number?: number, 
        periodicity?: MagazinePeriodicity,
        //Movie
        directors?: string[], 
        actors?: string[], 
        durationMovie?: number, 
        supportMovie?: MovieSupport,
        //Music
        tracks?: string[], 
        artist?: string,
        durationMusic?: number, 
        tracksNumber?: number, 
        supportMusic?: MusicSupport,
        //VideoGame
        multiPlayer? : boolean, 
        pegi?: number
    ){
        //Media
        this.id = id
        this.name = name
        this.publishingHouse= publishingHouse
        this.language = language
        this.image = image
        this.description = description
        this.dematerialized = dematerialized
        this.parutionDate = parutionDate
        this.addDate = addDate
        //attribut supplémentaire
        this.typeMedia=typeMedia;
        //BoardGame
        this.playerNumber = playerNumber;
        this.recommendedAge = recommendedAge;
        this.durationBoardGame = durationBoardGame;
        //Book
        this.author = author;
        this.ISBN = ISBN;
        this.pagesNb = pagesNb;
        this.chaptersNb = chaptersNb;
        this.type = type;
        //Magazine
        this.ISSN = ISSN;
        this.number = number;
        this.periodicity = periodicity;
        //Movie
        this.directors = directors;
        this.actors = actors;
        this.durationMovie = durationMovie;
        this.supportMovie = supportMovie;
        //Music
        this.tracks = tracks;
        this.artist = artist;
        this.durationMusic = durationMusic;
        this.tracksNumber = tracksNumber;
        this.supportMusic = supportMusic;
        //VideoGame
        this.multiPlayer = multiPlayer;
        this.pegi = pegi;
        
    }


}