import * as React from 'react';
import {question} from "@/ types/question";
import {BiDownArrow, BiUpArrow} from "react-icons/bi";

type questionProp = {
    question: question
}
export const QuestionCard = ({question}: questionProp) => {
    return (
        <div className={"flex flex-row child:px-4 child:py-2 bg-gray-700 text-gray-400 rounded p-2"}>
            <div className={"flex flex-col items-center justify-center"}>
                <div className={"flex flex-row justify-center items-center text-2xl"}>
                    <button><BiUpArrow/></button>
                    {230}
                </div>
                <div className={"flex flex-row justify-center items-center text-2xl"}>
                    <button><BiDownArrow/></button>
                    {230}
                </div>
            </div>
            <div className={"flex flex-col"}>
                <text className={"text-xl font-bold"}>{question.title}</text>
                <text className={""}>{question.description}</text>
                <text>{question.dateAsked.slice(0, 10)}</text>
                <text>{question.topics}</text>
            </div>
        </div>
    );
};
