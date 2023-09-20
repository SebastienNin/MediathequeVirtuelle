import {Media} from "./media"

export class BoardGame extends Media {
    playerNumber: string;
    type: string;
    recommendedAge: number;
    duration : number;

    constructor(playerNumber?: string, type? : string, recommendedAge? : number, duration? : number) {
        super()
        this.playerNumber = playerNumber;
        this.type = type;
        this.recommendedAge = recommendedAge;
        this.duration = duration;
    }

}