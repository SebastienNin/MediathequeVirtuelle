import { Injectable } from '@angular/core';
import { Media } from '../modele/media';
import { BoardGame } from '../modele/boardgame';
import { Book } from '../modele/book';
import { BookType } from '../modele/bookType';
import { Magazine } from '../modele/magazine';
import { Movie } from '../modele/movie';
import { Music } from '../modele/music';
import { VideoGame } from '../modele/videogame';

@Injectable({
  providedIn: 'root'
})
export class MediaService {

  medias: Array<Media> = new Array<Media>();
  typesMedia: Array<string> = ["boardGame", "book","magazine","movie","music","videoGame"];

  mediaForm: Media;
  typeMedia: string;

  bookForm: Book;
  boardGameForm: BoardGame;
  magazineForm :Magazine;
  movieForm : Movie;
  musicForm : Music;
  videoGameForm : VideoGame;

  constructor() {
    this.medias.push(new BoardGame(1, "Terraforming Mars", "Fryxgames", "Français", "image_boite",
				"L'ère de la domestication de Mars a commencé. Dans Terraforming Mars, de puissantes corporations travaillent pour rendre la Planète Rouge habitable. La température, l'oxygène et les océans sont les trois axes de développement principaux. Mais pour triompher, il faudra aussi construire des infrastructures pour les générations futures.",
				false, "2016-01-01", "2023-09-20", "1-5", 12, 60));
    this.medias.push(new Book(2, "Tintin en Amérique", "Casterman", "français", "Image Tintin", "Tintin va en amérique",
				false, "1946-07-01", "2023-09-20", "Hergé", "2-203-00102-X", 62, 0, BookType.Comic))
   }

   findAll() : Array<Media> {
    return this.medias;
   }

   findById(id: number) {
    return this.medias.find(m => m.id ==id);
   }

  //  save(media : Media) {
  //   if(media.id) {
  //     let pos = this.medias.findIndex(m => m.id == media.id);
  //     this.medias[pos] = media;
  //   } else {
  //     let max = 0;
  //     this.medias.forEach(m => {
  //       if(m.id > max) {
  //         max = m.id;
  //       }
  //     });

  //     media.id = ++max;

  //     this.medias.push(media);
  //  }
  // }

  deleteById(id: number) {
    let pos = this.medias.findIndex(m => m.id == id);
    this.medias.splice(pos, 1);
  }

  addNewMedia(media: Media, typeMedia: string) {
    let max = 0;
    this.medias.forEach(m => {
    if(m.id > max) {
      max = m.id;
    }});
    media.id=++max;
    console.log(media);
    

    if (typeMedia=="boardGame") {
      this.medias.push(<BoardGame>media);
    } else if (typeMedia =="book") {
      this.medias.push(<Book>media);
    } else if (typeMedia =="magazine") {
      this.medias.push(<Magazine>media);
    } else if (typeMedia =="movie") {
      this.medias.push(<Movie>media);
    } else if (typeMedia =="music") {
      this.medias.push(<Music>media);
    } else if (typeMedia =="videoGame") {
      this.medias.push(<VideoGame>media);
    } else {
      console.log('Erreur avec le typeMedia');
    }

    console.log(this.medias);
    
  }

  editMedia() {

  }
}
