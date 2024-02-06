import * as React from 'react';
import getAllQuestions from "@/api/getQuestions";
import {QuestionCard} from "@/components/questionCard";
import {Question} from "@/ types/question";
import Link from "next/link";
import {auth} from "../../auth";
import {WavyBackground} from "@/components/ui/wavy-background";
import {SparklesCore} from "@/components/ui/sparkles";
import {Button} from "@/components/ui/button";
import {SearchIcon} from "lucide-react";

export const Body = async() => {
    const session = await auth()
    const questions: Question[] = await getAllQuestions()
    questions.reverse()

    const topSection = (
        <section className={"justify-between flex flex-row px-4 pt-4"}>
            <Button variant={"outline"} className={"inline-flex child:mr-2"}>
               <SearchIcon/> {"Search your Question"}
            </Button>
            <Link href={"/ask"}>
                <Button variant={"outline"}>
                    Ask a doubt
                </Button>
            </Link>
        </section>
    )
    const questionsDiv = (
        <section className={"grid auto-rows-fr grid-cols-1 gap-4 justify-between grow p-2 m-2"}>
            {
                questions.map((question)=>{
                    return <>
                        <QuestionCard question={question}/>
                    </>
                })
            }
        </section>
    )
    return (<div>{

            (session && session.user) ? <div>
                {topSection}
                {questionsDiv}
            </div> :
            //not signed in
                <div className={"pt-16"}>
                    <WavyBackground className="flex flex-col justify-center items-center text-center">
                        <p className="text-2xl md:text-4xl lg:text-7xl text-white font-bold inter-var text-center">
                            Instant answers, endless conversations, endless
                            insights.
                        </p>
                        <p className="text-base md:text-lg mt-4 text-white font-normal inter-var text-center">
                            Curiosity meets collaboration!
                        </p>
                    </WavyBackground>
                    <div
                        className="h-fit w-full bg-black flex flex-col items-center justify-center overflow-hidden rounded-md">
                        <h1 className="md:text-7xl text-3xl lg:text-9xl font-bold text-center text-white relative z-20">
                            qna
                        </h1>
                        <div className="w-[40rem] h-40 relative">
                            {/* Gradients */}
                            <div
                                className="absolute inset-x-20 top-0 bg-gradient-to-r from-transparent via-indigo-500 to-transparent h-[2px] w-3/4 blur-sm"/>
                            <div
                                className="absolute inset-x-20 top-0 bg-gradient-to-r from-transparent via-indigo-500 to-transparent h-px w-3/4"/>
                            <div
                                className="absolute inset-x-60 top-0 bg-gradient-to-r from-transparent via-sky-500 to-transparent h-[5px] w-1/4 blur-sm"/>
                            <div
                                className="absolute inset-x-60 top-0 bg-gradient-to-r from-transparent via-sky-500 to-transparent h-px w-1/4"/>

                            {/* Core component */}
                            <SparklesCore
                                minSize={0.4}
                                maxSize={1}
                                particleDensity={1200}
                                className="w-full h-full"
                                particleColor="#FFFFFF"
                            />

                            {/* Radial Gradient to prevent sharp edges */}
                            <div
                                className="absolute inset-0 w-full h-full bg-black [mask-image:radial-gradient(350px_200px_at_top,transparent_20%,white)]"></div>
                        </div>
                    </div>
                    <div className={"child:p-4"}>
                        <div>
                            <div className={"text-3xl py-2"}>
                                Virtual Rooms
                            </div>
                            <div>
                                {"Our platform features virtual rooms, each dedicated to a specific theme or topic. \n From technology and science to lifestyle and hobbies, there`s a room for everyone. Join a room that aligns with your interests or expertise, and start or join discussions with like-minded individuals."}
                            </div>
                        </div>
                        <div>
                            <div className={"text-3xl py-2"}>
                                Real-time Interaction
                            </div>
                            <div>
                                Experience the thrill of real-time conversations with people around the world. Ask
                                questions, provide answers, and engage in lively discussions as if you were in the same
                                room. The immediacy of our platform ensures that you get instant responses and foster
                                genuine connections.
                            </div>
                        </div>
                        <div>
                            <div className={"text-3xl py-2"}>Diverse Perspectives</div>
                            <div>{"Many rooms feature experts in their respective fields, offering valuable insights and expertise. Whether you're a beginner seeking guidance or an enthusiast wanting to delve deeper into a topic, you'll have the opportunity to interact with knowledgeable individuals who are passionate about sharing their expertise."}</div>
                        </div>
                        <div>
                            <div className={"text-3xl py-2"}>Community-driven Knowledge</div>
                            <div>Our platform thrives on the power of community. Users actively contribute to building a
                                repository of knowledge, making it a go-to resource for information. The collective
                                wisdom of the community ensures that you receive well-informed and thoughtful responses
                                to your queries.
                            </div>
                        </div>
                    </div>
                </div>
        }
        </div>
    );
}

