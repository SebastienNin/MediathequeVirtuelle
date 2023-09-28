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
import { FormBuilder, FormGroup, FormArray, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

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

  // Variable pour stocker le fichier sélectionné
  selectedFile: File | null = null;

  //Passage en reacForm
  addMediaFormGroup: FormGroup;
  hasFormErrors: boolean = false;

  // List to speed up validator addition process
  bookFields = ['author', 'ISBN', 'pagesNb', 'chaptersNb', 'bookType', 'themeId'];
  boardGameFields = ['playerNumber', 'recommendedAge', 'duration', 'themeId'];
  magazineFields = ['ISSN', 'number', 'magazinePeriodicity', 'themeId'];
  movieFields = ['durationMovie', 'movieSupport', 'themeId'];
  musicFields = ['artist', 'durationMusic', 'trackNumber', 'musicSupport', 'themeId'];
  videoGameFields = ['pegi', 'themeId'];
  allOptionnalFields = ['author', 'ISBN', 'pagesNb', 'chaptersNb', 'bookType',
    'playerNumber', 'recommendedAge', 'duration', 'ISSN', 'number', 'magazinePeriodicity',
    'durationMovie', 'movieSupport', 'artist', 'durationMusic', 'trackNumber', 'musicSupport',
    'pegi', 'themeId'];

  media: Media = new Media();
  directorsFormArray: FormControl[] = [];
  directorsString: string[] = [];
  actorsFormArray: FormControl[] = [];
  actorsString: string[] = [];
  tracksFormArray: FormControl[] = [];
  tracksString: string[] = [];

  constructor(private mediaServiceHttp: HttpMediaService, private themeService: ThemeService,
    private fileService: FileService, private formBuilder: FormBuilder, private router: Router) {
    const today = new Date();
    const year = today.getFullYear();
    const month = String(today.getMonth() + 1).padStart(2, '0'); // Month is zero-based
    const day = String(today.getDate()).padStart(2, '0');
    this.currentDate = `${year}-${month}-${day}`;
    this.mediaForm.addDate = this.currentDate;

    this.addMediaFormGroup = this.formBuilder.group({
      name: ['', Validators.required],
      typeMedia: ['', Validators.required],
      publishingHouse: ['', Validators.required],
      language: ['', Validators.required],
      description: ['', Validators.required],
      dematerialized: [''],
      parutionDate: ['', Validators.required],
      themeId: [''],
      addDate: [this.currentDate],
      //Section Boardgame
      playerNumber: [''],
      recommendedAge: [''],
      durationBG: [''],
      themeBoardGame: [null],
      //Section Book
      author: [''],
      ISBN: [''],
      pagesNb: [''],
      chaptersNb: [''],
      bookType: [null],
      //Section Magazine
      ISSN: [''],
      number: [''],
      magazinePeriodicity: [null],
      //Section Movie
      durationMovie: [''],
      movieSupport: [null],
      actors: this.formBuilder.array([]),
      directors: this.formBuilder.array([]),
      //Section Music
      artist: [''],
      durationMusic: [''],
      trackNumber: [''],
      musicSupport: [null],
      tracks: this.formBuilder.array([]),
      //Section VideoGame
      multiPlayer: [''],
      pegi: ['']
    })

    // Create the FormArray for directors
    // this.directorsFormArray = this.formBuilder.array([]);
    // this.addMediaFormGroup.addControl('directors', this.directorsFormArray);
  }

  showSecondPartOfForm() {
    if (this.addMediaFormGroup.valid) {
      this.showFirstForm = false;
      switch (this.addMediaFormGroup.get("typeMedia").value) {
        case (TypeMedia.BoardGame):
          this.themeService.findByEnumTheme(EnumTheme.BOARDGAME).subscribe(resp => this.listTheme = resp);
          for (var field of this.boardGameFields) {
            this.addRequiredValidators(field);
          }
          this.showBoardGameForm = true;
          break;
        case (TypeMedia.Book):
          this.themeService.findByEnumTheme(EnumTheme.BOOK).subscribe(resp => this.listTheme = resp);
          for (var field of this.bookFields) {
            this.addRequiredValidators(field);
          }
          this.showBookForm = true;
          break;
        case (TypeMedia.Magazine):
          this.themeService.findByEnumTheme(EnumTheme.MAGAZINE).subscribe(resp => this.listTheme = resp);
          for (var field of this.magazineFields) {
            this.addRequiredValidators(field);
          }
          this.showMagazineForm = true;
          break;
        case (TypeMedia.Movie):
          this.addDirector();
          this.addActor();
          this.themeService.findByEnumTheme(EnumTheme.MOVIE).subscribe(resp => this.listTheme = resp);
          for (var field of this.movieFields) {
            this.addRequiredValidators(field);
          }
          this.showMovieForm = true;
          break;
        case (TypeMedia.Music):
          this.addTrack();
          this.themeService.findByEnumTheme(EnumTheme.MUSIC).subscribe(resp => this.listTheme = resp);
          for (var field of this.musicFields) {
            this.addRequiredValidators(field);
          }
          this.showMusicForm = true;
          break;
        case (TypeMedia.VideoGame):
          this.themeService.findByEnumTheme(EnumTheme.VIDEOGAME).subscribe(resp => this.listTheme = resp);
          for (var field of this.videoGameFields) {
            this.addRequiredValidators(field);
          }
          this.showVideoGameForm = true;
          break;
        case (null):
          console.log("Erreur sur typeMedia");
          break;
      }
      this.hasFormErrors = false;
    } else {
      this.hasFormErrors = true;
    }
  }

  addRequiredValidators(fieldName: string) {
    // Vérifiez d'abord si le champ existe dans le formulaire
    if (this.addMediaFormGroup.contains(fieldName)) {
      // Récupérez le contrôle du champ
      const fieldControl = this.addMediaFormGroup.get(fieldName);

      // Ajoutez le validateur requis s'il n'est pas déjà présent
      if (!fieldControl.hasValidator(Validators.required)) {
        fieldControl.setValidators([Validators.required]);
        fieldControl.updateValueAndValidity();
      }
    }
  }

  removeAllRequiredValidators() {
    for (var field of this.allOptionnalFields) {
      // Vérifiez d'abord si le champ existe dans le formulaire
      if (this.addMediaFormGroup.contains(field)) {
        // Récupérez le contrôle du champ
        const fieldControl = this.addMediaFormGroup.get(field);
        // Ajoutez le validateur requis s'il n'est pas déjà présent
        if (fieldControl.hasValidator(Validators.required)) {
          fieldControl.clearAsyncValidators();
          fieldControl.updateValueAndValidity();
        }
      }
    }
  }

  addDirector() {
    const directorControl = new FormControl('', Validators.required);
    this.directorsFormArray.push(directorControl);
  }

  removeDirector(index: number) {
    this.directorsFormArray.splice(index, 1);
  }

  addActor() {
    const actorControl = new FormControl('', Validators.required);
    this.actorsFormArray.push(actorControl);
  }

  removeActor(index: number) {
    this.actorsFormArray.splice(index, 1);
  }

  addTrack() {
    const trackControl = new FormControl('', Validators.required);
    this.tracksFormArray.push(trackControl);
  }

  removeTrack(index: number) {
    this.tracksFormArray.splice(index, 1);
  }

  addTheme() {
    this.mediaForm.themes.push(new Theme());
  }

  addNewMedia() {
    const addMediaInfo = this.addMediaFormGroup.value;
    let media = { ...this.media, ...addMediaInfo };
    // Envoyer le fichier seulement lors de la validation du formulaire
    if (this.selectedFile) {
      this.fileService.uploadFile(this.selectedFile).subscribe(resp => {
        this.imagePath = resp.fileName;

        // Après avoir reçu la réponse, continuez le traitement du formulaire
        // Récupérer les thèmes et les ajouter au mediaForm
        this.themeService.findById(this.addMediaFormGroup.get("themeId").value).subscribe(resp => {
          media.themes.push(resp);
          media.image = this.imagePath; // Ajoutez le chemin de l'image
          this.mediaServiceHttp.save(media);
          this.removeAllRequiredValidators();
          this.resetForm();
          this.router.navigate(['/watchMedia']);
        });
      });
    } else {
      // Si aucun fichier n'a été sélectionné, continuez sans envoyer de fichier
      this.themeService.findById(this.addMediaFormGroup.get("themeId").value).subscribe(resp => {
        media.themes.push(resp);
        // Utilisez this.directorsFormArray.value pour obtenir les noms des réalisateurs
        // Créer un array de string ici et enlevver director forarray
        this.directorsFormArray.forEach((ctrl, index) => {
          media.directors.push(ctrl.value);
        })
        this.actorsFormArray.forEach((ctrl, index) => {
          media.actors.push(ctrl.value);
        })
        this.tracksFormArray.forEach((ctrl, index) => {
          media.tracks.push(ctrl.value);
        })
        this.mediaServiceHttp.save(media);
        this.removeAllRequiredValidators();
        this.resetForm();
        this.router.navigate(['/watchMedia']);
      });
    }
  }

  resetForm() {
    //Vide les variables pour pouvoir ajouter un nouveau média
    this.addMediaFormGroup.reset();
    this.mediaForm = new Media();
    this.media = new Media();
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

  //redirige vers la liste des médias
  returnToWatchMedia() {
    this.router.navigate(['/watchMedia']);
  }

  onFileChange(event: any) {
    this.selectedFile = event.target.files[0];
  }
}
