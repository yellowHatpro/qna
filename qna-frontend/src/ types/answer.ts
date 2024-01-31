import {User} from "@/ types/user";
import {Question} from "@/ types/question";

export type Answer = {
    id: string;
    title: string;
    body: string;
    totalUpvotes: number;
    user: User;
    question: Question;
}
