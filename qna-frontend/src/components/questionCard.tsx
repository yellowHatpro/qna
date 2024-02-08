import * as React from 'react';
import {Question} from "@/ types/question";
import {BiUpArrow} from "react-icons/bi";
import {toDate} from "@/lib/utils";
import Link from "next/link";
import {Separator} from "@/components/ui/separator";

type questionProp = {
    question: Question
}
export const QuestionCard = ({question}: questionProp) => {
    return (
        <Link href={`/question/${question.id}`}>
            <div
                className={"flex flex-row child:px-4 border-2 text-neutral-400 bg-neutral-900 hover:bg-black p-2"}>
                <div className={"flex flex-col items-center justify-center"}>
                    <div className={"flex flex-row justify-center items-center text-2xl"}>
                        <button><BiUpArrow/></button>
                        {6969}
                    </div>
                    <text className={"text-xs mt-2 mx-4"}>{toDate(question.dateAsked)}</text>
                </div>
                <div>
                    <Separator className={"h-full"} orientation="vertical" />
                </div>
                <div className={"flex flex-col w-full"}>
                    <text className={"text-xl font-bold"}>{question.title}</text>
                    <text className={""}>{question.description}</text>
                    <text>{question.topics}</text>
                </div>
            </div>
        </Link>
    );
};
