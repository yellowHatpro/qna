import {Question} from "@/ types/question";
import getQuestionById from "@/api/getQuestionById";
import {User} from "@/ types/user";
import getUserById from "@/api/getUserById";
import {toDate} from "@/lib/utils";
import * as React from "react";
import {Button} from "@/components/ui/button";
import {
    Drawer, DrawerClose,
    DrawerContent,
    DrawerDescription, DrawerFooter,
    DrawerHeader,
    DrawerTitle,
    DrawerTrigger
} from "@/components/ui/drawer";
import {AnswerForm} from "@/app/question/answerForm";
import {Answer} from "@/ types/answer";
import getAllAnswersByIds from "@/api/getAllAnswersByIds";
import {AnswerCard} from "@/components/answerCard";

interface QuestionParams { params: { slug: string } }

export default async function QuestionPage({params} : QuestionParams) {
    const question: Question = await getQuestionById(params.slug)
    const questioner: User = await getUserById(question.questionerId)
    const userAnsweredAnswers: Answer[] = await getAllAnswersByIds(question.answerIds??[])

    return (
        <section className={"p-4 h-full w-full"}>
            <section className={"flex flex-col"}>
                <div className={"flex flex-row justify-between items-center"}>
                    <h1 className={"font-normal text-4xl"}>{question.title}</h1>
                    <Drawer>
                        <DrawerTrigger asChild>
                            <Button>Answer</Button>
                        </DrawerTrigger>
                        <DrawerContent>
                            <div className="mx-auto w-full max-w-sm">
                                <DrawerHeader>
                                    <DrawerTitle>Answer to this question:</DrawerTitle>
                                    <DrawerDescription>{question.title}</DrawerDescription>
                                </DrawerHeader>
                                <div className="p-4 pb-0">
                                    <AnswerForm questionId={question.id}/>
                                </div>
                                <DrawerFooter>
                                    <DrawerClose asChild>
                                        <Button variant="outline">Cancel</Button>
                                    </DrawerClose>
                                </DrawerFooter>
                            </div>
                        </DrawerContent>
                    </Drawer>
                </div>
                <div className={"flex flex-row items-center space-x-3"}>
                    <h1 className={"text-sm my-2"}>{`Date Asked: ${toDate(question.dateAsked)}`}</h1>
                    <h1 className={"text-sm font-light"}>{`Question Asked by: ${questioner.username}`}</h1>
                </div>
            </section>
            <hr className={"p-2"}/>
            <section className={"p-4 border-2 items-center flex"}>
                {question.description}
            </section>
            <section className={"pt-4"}>
                <h1 className={"font-semibold border-2 bg-neutral-900 text-2xl p-4 my-2"}>
                    {"Answers"}
                </h1>
                <div>
                    {userAnsweredAnswers.map((ans,id)=>{
                        return(
                           <div
                               key={ans.id}
                               className={"pb-2"}>
                               <AnswerCard
                                   answer={ans}/>
                           </div>
                        )
                    })}
                </div>
            </section>
        </section>
    )
}
