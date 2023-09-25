import { Injectable } from '@angular/core';
import { Media } from '../modele/media';
import { BookType } from '../modele/bookType';
import { TypeMedia } from '../modele/typeMedia';

@Injectable({
  providedIn: 'root'
})
export class WatchMediaService {

  medias: Array<Media> = new Array<Media>();
  typesMedia: Array<string> = ["boardGame", "book","magazine","movie","music","videoGame"];

  typeMedia: string;


  constructor() {
    this.medias.push(new Media(1, "Terraforming Mars", "Fryxgames", "Français", "image_boite",
				"L'ère de la domestication de Mars a commencé. Dans Terraforming Mars, de puissantes corporations travaillent pour rendre la Planète Rouge habitable. La température, l'oxygène et les océans sont les trois axes de développement principaux. Mais pour triompher, il faudra aussi construire des infrastructures pour les générations futures.",
				false, "2016-01-01", "2023-09-20", TypeMedia.BoardGame,"1-5", 12, 60));
    this.medias.push(new Media(2, "Tintin en Amérique", "Casterman", "français", "Image Tintin", "Tintin va en amérique",
				false, "1946-07-01", "2023-09-20",TypeMedia.Book, null,null,null,"Hergé", "2-203-00102-X", 62, 0, BookType.Comic));
    this.medias.push(new Media(3, "Zelda : Tears of the Kingdom", "Nintendo", "Français", "Jaquette_totk", "Link fait joujou avec des armes et oublie zelda encore une fois", 
        false, "2023-05-12", "2023-09-22", TypeMedia.VideoGame, null,null,null,null,null,null,null,null,null,null,null,null,null,null,null, false, 12))
   }

   findAll() : Array<Media> {
    return this.medias;
   }

   findById(id: number) {
    return this.medias.find(m => m.id ==id);
   }
   
}
