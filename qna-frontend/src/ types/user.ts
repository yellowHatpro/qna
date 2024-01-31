import {StaticImport} from "next/dist/shared/lib/get-img-props";
import {Question} from "@/ types/question";
import {Answer} from "@/ types/answer";

export type User = {
    id: string;
    firstName: string;
    secondName: string;
    name?: string| null| undefined;
    username: string;
    address: string;
    email?: string | null| undefined;
    phoneNumber: string;
    questionsAsked: Question[];
    answers: Answer[];
    image: string | StaticImport;
}
