import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { HttpMediaService } from '../http-media.service';
import { ActivatedRoute } from '@angular/router';
import { TypeMedia } from '../modele/typeMedia';
import { FileService } from '../file.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ThemeService } from '../theme.service';
import { AccountHttpService } from '../account-http.service';
import { WatchMyMediaHttpService } from '../watch-my-media/watch-my-media-http.service';
import { PersonnalizedListHttpService } from '../personnalizedList-http.service';
import { PersonnalizedList } from '../modele/personnalizedList';
import { AuthService } from '../auth.service';
import { PersoListJoinMediaHttpService } from '../perso-list-join-media/perso-list-join-media-http.service';
import { AccountMedia } from '../modele/accountMedia';

@Component({
  selector: 'app-see-media-details',
  templateUrl: './see-media-details.component.html',
  styleUrls: ['./see-media-details.component.scss']
})
export class SeeMediaDetailsComponent {

  id: number;
  media: Media = new Media();
  themes: string = "";
  myPersoLists: PersonnalizedList[] = [];
  myPersoListId: number;
  myAccountMedias: AccountMedia[] = [];
  isThisMediaInMyAccount: boolean;

  selectedMenu: string;
  editInfoMediaFormGroup: FormGroup;

  showBoardGameCard: boolean = false;
  showBookCard: boolean = false;
  showMagazineCard: boolean = false;
  showMovieCard: boolean = false;
  showMusicCard: boolean = false;
  showVideoGameCard: boolean = false;

  imageSrc: any; // Propriété pour stocker l'URL de l'image

  constructor(private formBuilder: FormBuilder, private mediaServiceHttp: HttpMediaService, private route: ActivatedRoute,
    private fileService: FileService, private themeService: ThemeService, private watchMyMediaHttpService: WatchMyMediaHttpService,
    private persoListService: PersonnalizedListHttpService, private authService: AuthService,
    private persoListJoinMediaService: PersoListJoinMediaHttpService) {
    this.route.params.subscribe(param => this.id = param['id']);
    this.mediaServiceHttp.findById(this.id).subscribe(resp => {
      this.media = resp;
      this.load();
      this.loadThemes();
      this.findMyPersoLists();
      this.findMyMedias();

      this.editInfoMediaFormGroup = this.formBuilder.group({
        //Général
        name: [this.media.name,],
        publishingHouse: [this.media.publishingHouse],
        language: [this.media.language],
        //Ajouter Modif Image
        description: [this.media.description],
        dematerialized: [this.media.dematerialized],
        parutionDate: [this.media.parutionDate],
        themes: [this.media.themes],

        //Jeu de plateau
        playerNumber: [this.media.playerNumber],
        recommendedAge: [this.media.recommendedAge],
        duration: [this.media.duration],

        //Livre
        author: [this.media.author],
        isbn: [this.media.isbn],
        pageNb: [this.media.pageNb],
        chapterNb: [this.media.chapterNb],
        bookType: [this.media.bookType],

        //Magazine
        issn: [this.media.issn],
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
    });
    this.selectedMenu = 'info';
  }

  //Choix entre affichage et modification des infos
  selectMenu(menu: string) {
    this.selectedMenu = menu;
  }

  //Modification des infos
  updateMediaInfo() {
    // Si aucun fichier n'a été sélectionné, continuez sans envoyer de fichier
    this.themeService.findById(this.editInfoMediaFormGroup.get("themes").value[0].id).subscribe(resp => {
      const updateInfoMedia = this.editInfoMediaFormGroup.value;
      let media = { ...this.media, ...updateInfoMedia };
      // media.themes.push(resp);
      this.mediaServiceHttp.save(media);
      this.load();
      this.selectMenu("info");
    });
  }

  loadThemes() {
    let i: number = 0;
    for (let theme of this.media.themes) {
      if (i == this.media.themes.length - 1) {
        this.themes = this.themes + theme.label;
      } else {
        this.themes = this.themes + theme.label + ", ";
      }
      i++;
    }
  }

  load() {
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
    this.mediaServiceHttp.findById(this.media.id).subscribe(resp => {
      this.media = resp;
    });
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

  findMyMedias() {
    this.watchMyMediaHttpService.findMediaByAccount(this.authService.getUser()).subscribe(resp => {
      this.myAccountMedias = resp;
      this.myAccountMedias.forEach(media => {
        if (media.id == this.media.id) {
          this.isThisMediaInMyAccount = true;
        }
      })
    });
  }

  addToMyMedias() {
    this.watchMyMediaHttpService.save(this.authService.getUser().id, this.media.id).subscribe(resp => {
      this.isThisMediaInMyAccount = true
    });
  }

  findMyPersoLists() {
    this.persoListService.findByAccount(this.authService.getUser()).subscribe(resp => {
      this.myPersoLists = resp;
    })
  }

  addToPersoList() {
    this.persoListJoinMediaService.save(this.media.id, this.myPersoListId).subscribe();
  }

  deleteFromMyMedias() {
    this.watchMyMediaHttpService.deleteByMediaId(this.media.id).subscribe(resp => {
      this.isThisMediaInMyAccount = false
    });
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
