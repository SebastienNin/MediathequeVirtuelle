import { Media } from "./media";

export class Book extends Media {
    author: string;
    ISBN: string;
    pagesNb: number;
    chaptersNb: number;

    constructor(author?: string, ISBN?: string, pagesNb?: number, chaptersNb?: number) {
        super()
        this.author = author
        this.ISBN = ISBN
        this.pagesNb = pagesNb
        this.chaptersNb = chaptersNb
    }
}
