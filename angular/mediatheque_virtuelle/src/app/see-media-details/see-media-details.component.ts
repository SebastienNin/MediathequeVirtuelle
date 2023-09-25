import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../modele/media';
import { HttpMediaService } from '../http-media.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-see-media-details',
  templateUrl: './see-media-details.component.html',
  styleUrls: ['./see-media-details.component.scss']
})
export class SeeMediaDetailsComponent {

  id: number;
  media$: Observable<Media>;

  constructor(private mediaServiceHttp: HttpMediaService, private route: ActivatedRoute) {
    this.route.params.subscribe(param => this.id = param['id']);
    this.media$ = this.mediaServiceHttp.findById(this.id);

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
