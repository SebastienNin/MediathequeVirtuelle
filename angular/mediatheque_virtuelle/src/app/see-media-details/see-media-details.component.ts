import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { HttpMediaService } from '../http-media.service';
import { ActivatedRoute } from '@angular/router';
import { TypeMedia } from '../modele/typeMedia';

@Component({
  selector: 'app-see-media-details',
  templateUrl: './see-media-details.component.html',
  styleUrls: ['./see-media-details.component.scss']
})
export class SeeMediaDetailsComponent {

  id: number;
  media: Media = new Media();
  themes: string = "";

  showBoardGameCard: boolean = false;
  showBookCard: boolean = false;
  showMagazineCard: boolean = false;
  showMovieCard: boolean = false;
  showMusicCard: boolean = false;
  showVideoGameCard: boolean = false;


  constructor(private mediaServiceHttp: HttpMediaService, private route: ActivatedRoute) {
    this.route.params.subscribe(param => this.id = param['id']);
    this.mediaServiceHttp.findById(this.id).subscribe(resp => {
      this.media = resp;
      this.load();
    });
  }

  load() {
    let i : number = 0;
    for(let theme of this.media.themes){
      if(i == this.media.themes.length - 1){
        this.themes = this.themes + theme.label;
      }else{
        this.themes = this.themes + theme.label + ", ";
      }
      i ++;
    }
    switch (this.media.typeMedia) {
      case (TypeMedia.BoardGame):
        this.showBoardGameCard = true;
        break;
      case (TypeMedia.Book):
        this.showBookCard = true;
        console.log(this.media);
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
  }

  addToMyMedias() {

  }

  addToWishlist() {

  }

  addToPersoList() {

  }

  deleteFromMyMedias() {

  }

}
