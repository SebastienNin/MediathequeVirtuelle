import { Component } from '@angular/core';
import { MediaService } from './media.service';
import { Media } from '../modele/media';
import { TypeMedia } from '../modele/typeMedia';

@Component({
  selector: 'app-add-media',
  templateUrl: './add-media.component.html',
  styleUrls: ['./add-media.component.scss']
})
export class AddMediaComponent {

  mediaForm : Media = new Media();

  //un peu dégueu, à changer si je trouve une solution pour boucler sur l'énum... Diane
  typesMedia : TypeMedia[]= [TypeMedia.BoardGame, TypeMedia.Book, TypeMedia.Magazine, TypeMedia.Movie, TypeMedia.Music, TypeMedia.VideoGame];

  constructor(private mediaService : MediaService) {
  }

  addNewMedia() {
    console.log(this.mediaService.medias);
    
    this.mediaService.addNewMedia(this.mediaForm);
    this.mediaForm = new Media();
    console.log(this.mediaService.medias);
  }



}
