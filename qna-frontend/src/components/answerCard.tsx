import Link from "next/link";
import {BiUpArrow} from "react-icons/bi";
import * as React from "react";
import {Answer} from "@/ types/answer";
import {Question} from "@/ types/question";
import getQuestionById from "@/api/getQuestionById";
import {toDate} from "@/lib/utils";
import {Separator} from "@/components/ui/separator";

type answerProp = {
    answer: Answer
}
export const AnswerCard = async ({answer}: answerProp) => {
    const question: Question = await getQuestionById(answer.questionId)
    return (
        <Link href={`/question/${answer.questionId}`}>
            <div
                className={"flex flex-row child:px-4 border-2 text-neutral-400 bg-neutral-900 hover:bg-black p-2"}>
                <div className={"flex flex-col items-center justify-center"}>
                    <div className={"flex flex-row justify-center items-center text-2xl"}>
                        <button><BiUpArrow/></button>
                        {6969}
                    </div>
                    <div className={"text-xs mt-2 mx-4"}>
                        {toDate(answer.dateAnswered)}
                    </div>
                </div>
                <div>
                    <Separator className={"h-full"} orientation="vertical"/>
                </div>
                <div className={"flex flex-col w-full"}>
                    <h1 className={"text-xl font-bold"}>{question.title}</h1>
                    <h1 className={"text-xl font-bold"}>{answer.title}</h1>
                    <h1 className={""}>{answer.body}</h1>
                </div>
            </div>
        </Link>
    );
};
