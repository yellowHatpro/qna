import {Question} from "@/ types/question";
import getQuestionById from "@/api/getQuestionById";
import {User} from "@/ types/user";
import getUserById from "@/api/getUserById";
import {toDate} from "@/lib/utils";

interface QuestionParams { params: { slug: string } }

export default async function QuestionPage({params} : QuestionParams) {
    const question: Question = await getQuestionById(params.slug)
    const questioner: User = await getUserById(question.questionerId)
    return (
        <section className={"p-4 h-full w-full"}>
            <section className={"flex flex-col"}>
                <h1 className={"font-black text-4xl"}>{question.title}</h1>
                <h1 className={"text-xs"}>{toDate(question.dateAsked)}</h1>
                <h1 className={"text-lg font-bold"}>{`Question Asked by: ${questioner.username}`}</h1>
            </section>
            <section className={"pt-12"}>
                {question.description}
            </section>
            <section className={"pt-12"}>
                <h1 className={"font-black text-3xl"}>
                    Answers
                </h1>
                {question.answerIds.length}
            </section>
        </section>
    )
}
