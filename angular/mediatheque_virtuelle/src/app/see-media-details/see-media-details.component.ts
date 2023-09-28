import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { HttpMediaService } from '../http-media.service';
import { ActivatedRoute } from '@angular/router';
import { TypeMedia } from '../modele/typeMedia';
import { FileService } from '../file.service';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-see-media-details',
  templateUrl: './see-media-details.component.html',
  styleUrls: ['./see-media-details.component.scss']
})
export class SeeMediaDetailsComponent {

  id: number;
  media: Media = new Media();
  themes: string = "";

  selectedMenu: string;
  editInfoMediaFormGroup: FormGroup;
  // editGlobalMediaFormGroup: FormGroup;
  // boardGameFormGroup: FormGroup;
  // bookFormGroup: FormGroup;
  // magazineFormGroup: FormGroup;
  // movieFormGroup: FormGroup;
  // musicFormGroup: FormGroup;
  // videoGameFormGroup: FormGroup;

  showBoardGameCard: boolean = false;
  showBookCard: boolean = false;
  showMagazineCard: boolean = false;
  showMovieCard: boolean = false;
  showMusicCard: boolean = false;
  showVideoGameCard: boolean = false;

  imageSrc: any; // Propriété pour stocker l'URL de l'image

  constructor(private formBuilder: FormBuilder, private mediaServiceHttp: HttpMediaService, private route: ActivatedRoute, private fileService: FileService) {
    this.route.params.subscribe(param => this.id = param['id']);
    this.mediaServiceHttp.findById(this.id).subscribe(resp => {
      this.media = resp;
      this.load();

      console.log(this.media);

      this.editInfoMediaFormGroup = this.formBuilder.group({
        //Général
        name: [this.media.name,],
        publishingHouse: [this.media.publishingHouse],
        language: [this.media.language],
        //Ajouter Modif Image
        description: [this.media.description],
        dematerialized: [this.media.dematerialized],
        parutionDate: [this.media.parutionDate],
        themes: [this.themes],

        //Jeu de plateau
        playerNumber: [this.media.playerNumber],
        recommendedAge: [this.media.recommendedAge],
        duration: [this.media.duration],

        //Livre
        author: [this.media.author],
        ISBN: [this.media.isbn],
        pagesNb: [this.media.pageNb],
        chaptersNb: [this.media.chapterNb],
        bookType: [this.media.bookType],

        //Magazine
        ISSN: [this.media.issn],
        number: [this.media.number],
        magazinePeriodicity: [this.media.magazinePeriodicity],

        //Film
        directors: [this.media.directors],
        actors: [this.media.actors],
        movieSupport: [this.media.movieSupport],

        //Musique
        tracks: [this.media.tracks],
        artist: [this.media.artist],
        trackNumber: [this.media.trackNumber],
        musicSupport: [this.media.musicSupport],

        //Jeux Vidéos
        pegi: [this.media.pegi],
        multiPlayer: [this.media.multiPlayer]

      })

      // this.editGlobalMediaFormGroup = this.formBuilder.group({
      //   //Général
      //   name: [this.media.name,],
      //   publishingHouse: [this.media.publishingHouse],
      //   language: [this.media.language],
      //   //Ajouter Modif Image
      //   description: [this.media.description],
      //   dematerialized: [this.media.dematerialized],
      //   parutionDate: [this.media.parutionDate],
      //   themes: [this.themes],
      // })
      // this.boardGameFormGroup = this.formBuilder.group({
      //   //Jeu de plateau
      //   playerNumber: [this.media.playerNumber],
      //   recommendedAge: [this.media.recommendedAge],
      //   duration: [this.media.duration],
      // })
      // this.bookFormGroup = this.formBuilder.group({
      //   //Livre
      //   author: [this.media.author],
      //   ISBN: [this.media.ISBN],
      //   pagesNb: [this.media.pagesNb],
      //   chaptersNb: [this.media.chaptersNb],
      //   bookType: [this.media.bookType],
      // })
      // this.magazineFormGroup = this.formBuilder.group({
      //   //Magazine
      //   ISSN: [this.media.ISSN],
      //   number: [this.media.number],
      //   magazinePeriodicity: [this.media.magazinePeriodicity],
      // })
      // this.movieFormGroup = this.formBuilder.group({
      //   //Film
      //   directors: [this.media.directors],
      //   actors: [this.media.actors],
      //   movieSupport: [this.media.movieSupport],
      // })
      // this.musicFormGroup = this.formBuilder.group({
      //   //Musique
      //   tracks: [this.media.tracks],
      //   artist: [this.media.artist],
      //   trackNumber: [this.media.trackNumber],
      //   musicSupport: [this.media.musicSupport],
      // })
      // this.videoGameFormGroup = this.formBuilder.group({
      //   //Jeux Vidéos
      //   pegi: [this.media.pegi],
      //   multiPlayer: [this.media.multiPlayer]
      // })

    });
    this.selectedMenu = 'info';
  }

  //Choix entre affichage et modification des infos
  selectMenu(menu: string) {
    this.selectedMenu = menu;
  }

  //Modification des infos
  updateMediaInfo() {
    const updateInfoMedia = this.editInfoMediaFormGroup.value;
    let media = { ...this.media, ...updateInfoMedia };
    this.mediaServiceHttp.saveModif(media).subscribe((resp) => {
      alert("Informations de " + this.media.name + " mises à jour avec succès.");
      this.media = resp;
    })
  }

  load() {
    let i: number = 0;
    for (let theme of this.media.themes) {
      if (i == this.media.themes.length - 1) {
        this.themes = this.themes + theme.label;
      } else {
        this.themes = this.themes + theme.label + ", ";
      }
      i++;
    }
    switch (this.media.typeMedia) {
      case (TypeMedia.BoardGame):
        this.showBoardGameCard = true;
        break;
      case (TypeMedia.Book):
        this.showBookCard = true;
        break;
      case (TypeMedia.Magazine):
        this.showMagazineCard = true;
        break;
      case (TypeMedia.Movie):
        this.showMovieCard = true;
        break;
      case (TypeMedia.Music):
        this.showMusicCard = true;
        break;
      case (TypeMedia.VideoGame):
        this.showVideoGameCard = true;
        break;
      case (null):
        console.log("Erreur sur typeMedia");
        break;
    }
    // Chargez l'image au moment du chargement des données
    this.loadImage();
  }

  loadImage(): void {
    const fileName = this.media.image; // Remplacez par le nom de fichier souhaité
    this.fileService.downloadFile(fileName).subscribe(response => {
      // Extrayez le corps de la réponse en tant que Blob
      const blob = response.body;
      // Créez une URL sûre à partir du Blob de l'image
      this.imageSrc = window.URL.createObjectURL(blob);
    });
  }

  addToMyMedias() {

  }

  addToWishlist() {

  }

  addToPersoList() {

  }

  deleteFromMyMedias() {

  }

  downloadFile() {
    const fileName = this.media.image; // Remplacez par le nom de fichier souhaité
    this.fileService.downloadFile(fileName).subscribe(response => {
      const blob = new Blob([response.body], { type: 'image/jpeg' });
      const url = window.URL.createObjectURL(blob);
      const a = document.createElement('a');
      a.href = url;
      a.download = fileName;
      document.body.appendChild(a);
      a.click();
      window.URL.revokeObjectURL(url);
    });
  }

}
