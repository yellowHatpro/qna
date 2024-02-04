import {StaticImport} from "next/dist/shared/lib/get-img-props";
import {Question} from "@/ types/question";
import {Answer} from "@/ types/answer";

export type User = {
    id?: string | null;
    firstName?: string | null;
    secondName?: string | null;
    name?: string| null| undefined;
    username?: string | null;
    address?: string | null;
    email?: string | null| undefined;
    phoneNumber?: string | null;
    questionsAsked?: Question[];
    answers?: Answer[];
    image?: string | StaticImport;
}
