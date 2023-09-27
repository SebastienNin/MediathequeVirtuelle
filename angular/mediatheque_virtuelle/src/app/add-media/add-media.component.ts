import { Component } from '@angular/core';
import { MediaService } from './media.service';
import { Media } from '../modele/media';
import { TypeMedia } from '../modele/typeMedia';
import { BookType } from '../modele/bookType';
import { MagazinePeriodicity } from '../modele/magazinePeriodicity';
import { MovieSupport } from '../modele/movieSupport';
import { MusicSupport } from '../modele/musicSupport';
import { HttpMediaService } from '../http-media.service';
import { ThemeService } from '../theme.service';
import { Theme } from '../modele/theme';
import { EnumTheme } from '../modele/enumTheme';
import { FileService } from '../file.service';

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
  themeId: number;
  imagePath: string;

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

  //liste des thèmes disponibles
  listTheme: Theme[] = new Array<Theme>;

  selectedFile: File | null = null; // Variable pour stocker le fichier sélectionné

  constructor(private mediaServiceHttp: HttpMediaService, private themeService: ThemeService, private fileService: FileService) {
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
        this.themeService.findByEnumTheme(EnumTheme.BOARDGAME).subscribe(resp => this.listTheme = resp);
        this.showBoardGameForm = true;
        break;
      case (TypeMedia.Book):
        this.themeService.findByEnumTheme(EnumTheme.BOOK).subscribe(resp => this.listTheme = resp);
        this.showBookForm = true;
        break;
      case (TypeMedia.Magazine):
        this.themeService.findByEnumTheme(EnumTheme.MAGAZINE).subscribe(resp => this.listTheme = resp);
        this.showMagazineForm = true;
        break;
      case (TypeMedia.Movie):
        this.mediaForm.directors.push("");
        this.mediaForm.actors.push("");
        this.themeService.findByEnumTheme(EnumTheme.MOVIE).subscribe(resp => this.listTheme = resp);
        this.showMovieForm = true;
        break;
      case (TypeMedia.Music):
        this.mediaForm.tracks.push("");
        this.themeService.findByEnumTheme(EnumTheme.MUSIC).subscribe(resp => this.listTheme = resp);
        this.showMusicForm = true;
        break;
      case (TypeMedia.VideoGame):
        this.themeService.findByEnumTheme(EnumTheme.VIDEOGAME).subscribe(resp => this.listTheme = resp);
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

  addTheme() {
    this.mediaForm.themes.push(new Theme());
  }

  addNewMedia() {
    // ... (autres traitements)

    // Envoyer le fichier seulement lors de la validation du formulaire
    if (this.selectedFile) {
      this.fileService.uploadFile(this.selectedFile).subscribe(resp => {
        this.imagePath = resp.fileName;

        // Après avoir reçu la réponse, continuez le traitement du formulaire
        // Récupérer les thèmes et les ajouter au mediaForm
        this.themeService.findById(this.themeId).subscribe(resp => {
          this.mediaForm.themes.push(resp);
          this.mediaForm.image = this.imagePath; // Ajoutez le chemin de l'image
          this.mediaServiceHttp.save(this.mediaForm);
          this.resetForm();
        });
      });
    } else {
      // Si aucun fichier n'a été sélectionné, continuez sans envoyer de fichier
      this.themeService.findById(this.themeId).subscribe(resp => {
        this.mediaForm.themes.push(resp);
        this.mediaServiceHttp.save(this.mediaForm);
        this.resetForm();
      });
    }
  }

  resetForm() {
    //Vide les variables pour pouvoir ajouter un nouveau média
    this.mediaForm = new Media();
    this.mediaForm.addDate = this.currentDate;
    this.themeId = null;

    //Rétablit le premier formulaire
    this.showFirstForm = true;
    this.showBoardGameForm = false;
    this.showBookForm = false;
    this.showMagazineForm = false;
    this.showMovieForm = false;
    this.showMusicForm = false;
    this.showVideoGameForm = false;
  }

  onFileChange(event: any) {
    this.selectedFile = event.target.files[0];
  }
}
