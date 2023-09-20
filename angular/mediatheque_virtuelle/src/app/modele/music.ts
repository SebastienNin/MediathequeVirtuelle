import { Media } from "./media";
export class Music extends Media {
    tracks: string[];
    artist: string;
    duration: number;
    tracksNumber: number;
    constructor(tracks?: string[], artist?: string, duration?: number, tracksNumber?: number) {
        super()
        this.tracks = tracks
        this.artist = artist
        this.duration = duration
        this.tracksNumber = tracksNumber
    }

}
