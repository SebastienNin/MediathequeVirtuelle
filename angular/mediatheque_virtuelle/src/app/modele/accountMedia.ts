import { Account } from "./account";
import { Media } from "./media";

export class AccountMedia {
    id: number;
    account: Account;
    media: Media;

    constructor (
        id?: number,
        account?: Account,
        media?: Media
    ) {
        this.id = id
        this.account = account
        this.media = media
    }
}