import { EnumTheme } from "./enumTheme";

export class Theme {
    id: number;
    label: string;
    enumTheme: EnumTheme;

    constructor(id? : number, label?: string, enumTheme? : EnumTheme) {
        this.id=id;
        this.label=label;
        this.enumTheme=enumTheme;
    }
}