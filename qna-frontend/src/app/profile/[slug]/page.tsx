import {User} from "@/ types/user";
import getUserByUsername from "@/api/getUserByUsername";
import getAllQuestionsByIds from "@/api/getAllQuestionsByIds";
import {Question} from "@/ types/question";

interface ProfileParams { params: { slug: string } }

export default async function QuestionPage({params} : ProfileParams) {
    const user: User = await getUserByUsername(params.slug)
    const userAskedQuestions : Question[] = await getAllQuestionsByIds(user.questionsAskedIds??[])
    return (
        <section className={"p-4 h-full w-full"}>
            <h1>
                {userAskedQuestions.map((question, index)=>{
                    return (
                        <div>
                            {question.title}
                        </div>
                    )
                })}
            </h1>
        </section>
    )
}
