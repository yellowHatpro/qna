import {User} from "@/ types/user";
import getUserByUsername from "@/api/getUserByUsername";
import getAllQuestionsByIds from "@/api/getAllQuestionsByIds";
import {Question} from "@/ types/question";
import {auth} from "../../../../auth";
import {QuestionCard} from "@/components/questionCard";
import {Suspense} from "react";
import {FaUser} from "react-icons/fa";
import Image from "next/image";
import * as React from "react";
import getAllAnswersByIds from "@/api/getAllAnswersByIds";
import {Answer} from "@/ types/answer";
import {AnswerCard} from "@/components/answerCard";

interface ProfileParams { params: { slug: string } }

export default async function QuestionPage({params} : ProfileParams) {
    const user: User = await getUserByUsername(params.slug)
    const getAuth = await auth()
    const userAskedQuestions : Question[] = await getAllQuestionsByIds(user.questionsAskedIds??[])
    const userAnsweredAnswers: Answer[] = await getAllAnswersByIds(user.answerIds??[])
    return (
        <main className={"p-4 h-full w-full"}>
            <section className={"flex flex-row items-center"}>
                <Suspense fallback={
                    <FaUser/>
                }>
                    {getAuth?.user?.image && <Image
                        className={"rounded-full"}
                        src={getAuth?.user.image}
                        width={150}
                        height={150}
                        alt={user?.name ?? "pp"}
                        priority={true}/>}
                </Suspense>
                <div className={"border-2 mx-4 px-4 py-2 bg-neutral-900"}>
                    <h1>
                        {user.username}
                    </h1>
                    <h1>
                        {user.firstName}{" "}{user.secondName}
                    </h1>
                    <h1>
                        {user.email}
                    </h1>
                    <h1>
                        {user.phoneNumber}
                    </h1>
                    <h1>
                        {user.address}
                    </h1>
                </div>
            </section>
            <section>
                <h1 className={"font-semibold border-2 bg-neutral-900 text-2xl p-4 my-2"}>
                    {"Questions Asked"}
                </h1>
                <div>
                    {userAskedQuestions.map((question, index) => {
                        return (
                            <div key={index} className={"mt-2"}>
                                <QuestionCard question={question}/>
                            </div>
                        )
                    })}
                </div>
            </section>
            <section>
                <h1 className={"font-semibold border-2 bg-neutral-900 text-2xl p-4 my-2"}>
                    {"Answers Provided"}
                </h1>
                <div>
                    {userAnsweredAnswers.map((answer, index) => {
                        return (
                            <div key={index} className={"mt-2"}>
                                <AnswerCard answer={answer}/>
                            </div>
                        )
                    })}
                </div>
            </section>
        </main>
    )
}
