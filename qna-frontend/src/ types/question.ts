export type question = {
	id: QuestionId;
	title: string;
	description: string;
	dateAsked: string;
	isResolved: boolean;
	topics: null;
	answerIds: QuestionAnswerIds[];
	authorId: string;
}
export type QuestionId = {
	timestamp: number;
	date: string;
}
export type QuestionAnswerIdsId = {
	timestamp: number;
	date: string;
}
export type QuestionAnswerIds = {
	id: QuestionAnswerIdsId;
	body: string;
	answererId: string;
	totalUpvotes: number;
}
