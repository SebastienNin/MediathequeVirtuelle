import { BookType } from "./bookType";
import { Media } from "./media";

export class Book extends Media {
    author: string
    ISBN: string
    pagesNb: number
    chaptersNb: number
    type: BookType

    constructor(id?: number,
        name?: string,
        publishingHouse?: string,
        language?: string,
        image?: string,
        description?: string,
        dematerialized?: boolean,
        parutionDate?: string, 
        addDate?: string, 
        author?: string, 
        ISBN?: string, 
        pagesNb?: number, 
        chaptersNb?: number, 
        type?: BookType ) {
        super(id, name, publishingHouse, language, image, description, dematerialized, parutionDate, addDate)
        this.author = author
        this.ISBN = ISBN
        this.pagesNb = pagesNb
        this.chaptersNb = chaptersNb
        this.type = type
    }
}
