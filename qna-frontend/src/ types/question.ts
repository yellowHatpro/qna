import {User} from "@/ types/user";

export type Question = {
	id: string;
	title: string;
	description: string;
	dateAsked: string;
	isResolved: boolean;
	topics: any[];
	answers: any[];
	questioner: User;
}
