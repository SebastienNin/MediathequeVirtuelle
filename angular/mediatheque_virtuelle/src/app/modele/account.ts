export class Account{
    id: number;
    version: number;
    login: string;
    password: string;
    name: string;
    firstName: string;
    mail: string;
    isAdmin: boolean;

    constructor(id?: number, version?: number, login?: string, password?: string, name?: string, firstName?: string, email?: string, isAdmin?: boolean){
        this.id = id;
        this.version = version;
        this.login = login;
        this.password = password;
        this.name = name;
        this.firstName = firstName;
        this.mail = email;
        this.isAdmin = isAdmin;
    }
}