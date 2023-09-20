import { Media } from "./media";
import { MovieSupport } from "./movieSupport";

export class Movie extends Media {
    directors: string[]
    actors: string[]
    duration: number
    support: MovieSupport

    constructor(directors?: string[], actors?: string[], duration?: number, support?: MovieSupport) {
        super()
        this.directors = directors
        this.actors = actors
        this.duration = duration
        this.support = support
    }
}
