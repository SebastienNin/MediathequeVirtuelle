import { Component } from '@angular/core';
import { MediaService } from './media.service';
import { Media } from '../modele/media';
import { TypeMedia } from '../modele/typeMedia';
import { BookType } from '../modele/bookType';
import { MagazinePeriodicity } from '../modele/magazinePeriodicity';
import { MovieSupport } from '../modele/movieSupport';
import { MusicSupport } from '../modele/musicSupport';
import { HttpMediaService } from '../http-media.service';

@Component({
  selector: 'app-add-media',
  templateUrl: './add-media.component.html',
  styleUrls: ['./add-media.component.scss']
})
export class AddMediaComponent {

  //variable associée au ngModel
  mediaForm: Media = new Media();
  currentDate: string;
  mediaTest: Media;

  //boolean pour l'affichage des différents formulaires
  showFirstForm: boolean = true;
  showBoardGameForm: boolean = false;
  showBookForm: boolean = false;
  showMagazineForm: boolean = false;
  showMovieForm: boolean = false;
  showMusicForm: boolean = false;
  showVideoGameForm: boolean = false

  //enums
  bookTypes: string[] = Object.values(BookType)
  typesMedia: TypeMedia[] = Object.values(TypeMedia);
  magPeriodicities: MagazinePeriodicity[] = Object.values(MagazinePeriodicity);
  movieSupports: MovieSupport[] = Object.values(MovieSupport);
  musicSupports: MusicSupport[] = Object.values(MusicSupport);


  constructor(private mediaServiceHttp: HttpMediaService) {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0'); // Month is zero-based
    const day = String(today.getDate()).padStart(2, '0');
    this.currentDate = `${year}-${month}-${day}`;
    this.mediaForm.addDate = this.currentDate;

  }

  showSecondPartOfForm() {
    this.showFirstForm = false;
    switch (this.mediaForm.typeMedia) {
      case (TypeMedia.BoardGame):
        this.showBoardGameForm = true;
        break;
      case (TypeMedia.Book):
        this.showBookForm = true;
        break;
      case (TypeMedia.Magazine):
        this.showMagazineForm = true;
        break;
      case (TypeMedia.Movie):
        this.mediaForm.directors.push("");
        this.mediaForm.actors.push("");
        this.showMovieForm = true;
        break;
      case (TypeMedia.Music):
        this.mediaForm.tracks.push("");
        this.showMusicForm = true;
        break;
      case (TypeMedia.VideoGame):
        this.showVideoGameForm = true;
        break;
      case (null):
        console.log("Erreur sur typeMedia");
        break;
    }
  }

  addDirector() {
    this.mediaForm.directors.push("");
  }

  addActor() {
    this.mediaForm.actors.push("");
  }

  addTrack() {
    this.mediaForm.tracks.push("");
  }

  addNewMedia() {

    this.mediaServiceHttp.save(this.mediaForm);

    //Vide les variables pour pouvoir ajouter un nouveau média
    this.mediaForm = new Media();
    this.mediaForm.addDate = this.currentDate;

    //Rétablit le premier formulaire
    this.showFirstForm = true;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = false;

  }

}
