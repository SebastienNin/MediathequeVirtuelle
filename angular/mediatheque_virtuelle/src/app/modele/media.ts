export class Media {
    id: number;
    name: string;
    publishingHouse: string;
    language: string;
    image: string;
    description: string;
    dematerialized: boolean;
    parutionDate: string; // 2023-09-20 {{parutionDate | date:''}}
    addDate: string;

    constructor(
        id?: number,
        name?: string,
        publishingHouse?: string,
        language?: string,
        image?: string,
        description?: string,
        dematerialized?: boolean,
        parutionDate?: string,
        addDate?: string
    ){
        this.id = id
        this.name = name
        this.publishingHouse= publishingHouse
        this.language = language
        this.image = image
        this.description = description
        this.dematerialized = dematerialized
        this.parutionDate = parutionDate
        this.addDate = addDate
    }


}