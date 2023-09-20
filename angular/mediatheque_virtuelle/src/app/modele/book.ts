import { BookType } from "./bookType";
import { Media } from "./media";

export class Book extends Media {
    author: string
    ISBN: string
    pagesNb: number
    chaptersNb: number
    type: BookType

    constructor(author?: string, ISBN?: string, pagesNb?: number, chaptersNb?: number, type?: BookType ) {
        super()
        this.author = author
        this.ISBN = ISBN
        this.pagesNb = pagesNb
        this.chaptersNb = chaptersNb
        this.type = type
    }
}
