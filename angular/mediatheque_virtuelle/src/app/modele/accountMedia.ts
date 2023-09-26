export class AccountMedia {
    id: number;
    account: number;
    media: number;

    constructor (
        id?: number,
        account?: number,
        media?: number
    ) {
        this.id = id
        this.account = account
        this.media = media
    }
}