import { Media } from "./media";

export class Movie extends Media {
    directors: string[];
    actors: string[];
    duration: number;

    constructor(directors?: string[], actors?: string[], duration?: number) {
       super();
        this.directors = directors
        this.actors = actors
        this.duration = duration
    }
}
