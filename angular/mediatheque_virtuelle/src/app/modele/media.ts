import { Type } from "@angular/core";
import { BookType } from "./bookType";
import { MagazinePeriodicity } from "./magazinePeriodicity";
import { MovieSupport } from "./movieSupport";
import { MusicSupport } from "./musicSupport";
import { TypeMedia } from "./typeMedia";
import { Theme } from "./theme";

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
    typeMedia: TypeMedia;

    //Liste de thèmes
    themes: Array<Theme> = new Array<Theme>;

    //attributs de BoardGame
    playerNumber: string;
    recommendedAge: number;
    duration: number;

    //attributs de Book
    author: string;
    ISBN: string;
    pagesNb: number;
    chaptersNb: number;
    bookType: BookType;

    //attributs de Magazine
    ISSN: string;
    number: number;
    magazinePeriodicity: MagazinePeriodicity;

    //attributs de Movie
    directors: string[] = new Array<string>;
    actors: string[] = new Array<string>;
    //duration -> voir BoardGame
    movieSupport: MovieSupport;

    //attribut de Music
    tracks: string[] = new Array<string>;
    artist: string;
    //duration -> voir BoardGame
    trackNumber: number;
    musicSupport: MusicSupport;

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
        recommendedAge?: number,
        duration?: number,
        //Book
        author?: string,
        ISBN?: string,
        pagesNb?: number,
        chaptersNb?: number,
        bookType?: BookType,
        //Magazine
        ISSN?: string,
        number?: number,
        magazinePeriodicity?: MagazinePeriodicity,
        //Movie
        movieSupport?: MovieSupport,
        //Music
        artist?: string,
        trackNumber?: number,
        musicSupport?: MusicSupport,
        //VideoGame
        multiPlayer?: boolean,
        pegi?: number
    ) {
        //Media
        this.id = id
        this.name = name
        this.publishingHouse = publishingHouse
        this.language = language
        this.image = image
        this.description = description
        this.dematerialized = dematerialized
        this.parutionDate = parutionDate
        this.addDate = addDate
        //attribut supplémentaire
        this.typeMedia = typeMedia;
        //BoardGame
        this.playerNumber = playerNumber;
        this.recommendedAge = recommendedAge;
        this.duration = duration;
        //Book
        this.author = author;
        this.ISBN = ISBN;
        this.pagesNb = pagesNb;
        this.chaptersNb = chaptersNb;
        this.bookType = bookType;
        //Magazine
        this.ISSN = ISSN;
        this.number = number;
        this.magazinePeriodicity = magazinePeriodicity;
        //Movie;
        this.movieSupport = movieSupport;
        //Music
        this.artist = artist;
        this.trackNumber = trackNumber;
        this.musicSupport = musicSupport;
        //VideoGame
        this.multiPlayer = multiPlayer;
        this.pegi = pegi;

    }


}