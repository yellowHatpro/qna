export type Question = {
	id: string;
	title: string;
	description: string;
	dateAsked: string;
	isResolved: boolean;
	topics: string[];
	answerIds: string[];
	questionerId: string;
}
