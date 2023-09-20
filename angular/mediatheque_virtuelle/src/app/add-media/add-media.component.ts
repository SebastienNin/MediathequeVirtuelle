import { Component } from '@angular/core';
import { MediaService } from './media.service';
import { Media } from '../modele/media';

@Component({
  selector: 'app-add-media',
  templateUrl: './add-media.component.html',
  styleUrls: ['./add-media.component.scss']
})
export class AddMediaComponent {

  mediaForm : Media = new Media();
  typesMedia: Array<string>;
  typeMedia : string;

  constructor(private mediaService : MediaService) {
    this.typesMedia=mediaService.typesMedia;
  }

  addNewMedia() {
    this.mediaService.addNewMedia(this.mediaForm, this.typeMedia);
    this.mediaForm = new Media();
    this.typeMedia = null;
  }

}
