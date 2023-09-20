import { Media } from "./media";

export class Magazine extends Media {
    
    ISSN: string
    number: number

    constructor(ISSN: string, number: number) {
        super()
        this.ISSN = ISSN
        this.number = number
    }
}
