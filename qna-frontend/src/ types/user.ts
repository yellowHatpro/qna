import {StaticImport} from "next/dist/shared/lib/get-img-props";

export type User = {
    id?: string | null;
    firstName?: string | null;
    secondName?: string | null;
    name?: string| null| undefined;
    username?: string | null;
    address?: string | null;
    email?: string | null| undefined;
    phoneNumber?: string | null;
    questionsAskedIds?: string[];
    answerIds?: string[];
    image?: string | StaticImport;
}
