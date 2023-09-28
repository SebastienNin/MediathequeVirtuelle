import { PersonnalizedList } from "./personnalizedList"; 
import { Media } from './media';

export class PersoListJoinMedia {
  id: number;
  persoList: PersonnalizedList;
  media: Media;

  constructor(id: number, persoList: PersonnalizedList, media: Media) {
    this.id = id;
    this.persoList = persoList;
    this.media = media;
  }
}
