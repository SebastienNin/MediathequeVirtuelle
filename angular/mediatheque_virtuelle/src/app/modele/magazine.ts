import { MagazinePeriodicity } from "./magazinePeriodicity";
import { Media } from "./media";

export class Magazine extends Media {

    ISSN: string
    number: number
    periodicity: MagazinePeriodicity

    constructor(ISSN?: string, number?: number, periodicity?: MagazinePeriodicity) {
        super()
        this.ISSN = ISSN
        this.number = number
        this.periodicity = periodicity
    }
}
