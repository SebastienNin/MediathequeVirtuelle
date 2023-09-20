export class Media {
    id: number;
    name: string;
    publishingHouse: string;
    language: string;
    image: string;
    description: string;
    dematerialized: boolean;
    parutionDate: number;

    constructor(
        id?: number,
        name?: string,
        publishingHouse?: string,
        language?: string,
        image?: string,
        description?: string,
        dematerialized?: boolean,
        parutionDate?: number
    ){
        this.id = id
        this.name = name
        this.publishingHouse= publishingHouse
        this.language = language
        this.image = image
        this.description = description
        this.dematerialized = dematerialized
        this.parutionDate = parutionDate
    }


}