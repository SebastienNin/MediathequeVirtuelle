import {Media} from "./media"

export class VideoGame extends Media {
    multiPlayer: boolean;
    pegi: number;

    constructor(id?: number,
        name?: string,
        publishingHouse?: string,
        language?: string,
        image?: string,
        description?: string,
        dematerialized?: boolean,
        parutionDate?: string, 
        addDate?: string, 
        multiPlayer? : boolean, 
        pegi?: number) {
            
        super(id, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate)
        this.multiPlayer = multiPlayer;
        this.pegi = pegi;


    }

}