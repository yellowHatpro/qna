import * as React from 'react';
import {Question} from "@/ types/question";
import {BiUpArrow} from "react-icons/bi";
import {toDate} from "@/lib/utils";

type questionProp = {
    question: Question
}
export const QuestionCard = ({question}: questionProp) => {

    return (
        <div className={"flex flex-row child:px-4 child:py-2 border-2 text-neutral-400  p-2"}>
            <div className={"flex flex-col items-center justify-center"}>
                <div className={"flex flex-row justify-center items-center text-2xl"}>
                    <button><BiUpArrow/></button>
                    {230}
                </div>
            </div>
            <div className={"flex flex-col w-full"}>
                <text className={"text-xl font-bold"}>{question.title}</text>
                <text className={""}>{question.description}</text>
                <text className={"flex text-sm justify-end w-full"}>{toDate(question.dateAsked)}</text>
                <text>{question.topics}</text>
            </div>
        </div>
    );
};
