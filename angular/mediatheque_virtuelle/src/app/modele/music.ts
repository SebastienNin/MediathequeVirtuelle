import { Media } from "./media";
import { MusicSupport } from "./musicSupport";
export class Music extends Media {

    tracks: string[]
    artist: string
    duration: number
    tracksNumber: number
    support: MusicSupport

    constructor(tracks?: string[], artist?: string, duration?: number, tracksNumber?: number, support?: MusicSupport) {

        super()
        this.tracks = tracks
        this.artist = artist
        this.duration = duration
        this.tracksNumber = tracksNumber
        this.support = support
    }
}