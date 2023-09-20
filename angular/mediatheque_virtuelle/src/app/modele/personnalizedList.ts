import { Account } from "./account";

export class PersonnalizedList {
    id: number;
    name: string;
    account: Account;

    constructor(id? : number, name?: string, account? : Account) {
        this.id = id;
        this.name = name;
        this.account = account;

    }

}