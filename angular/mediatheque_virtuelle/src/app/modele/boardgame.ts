import {Media} from "./media"

export class BoardGame extends Media {
    playerNumber: string;
    recommendedAge: number;
    duration : number;

    constructor(id?: number,
        name?: string,
        publishingHouse?: string,
        language?: string,
        image?: string,
        description?: string,
        dematerialized?: boolean,
        parutionDate?: string, 
        addDate?: string, 
        playerNumber?: string, 
        recommendedAge? : number, 
        duration? : number) {
            
        super(id, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate)
        this.playerNumber = playerNumber;
        this.recommendedAge = recommendedAge;
        this.duration = duration;


    }


}