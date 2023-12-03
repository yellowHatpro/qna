// @flow
import * as React from 'react';
import {getServerSession} from "next-auth";
import {authOptions} from "@/app/api/auth/[...nextauth]/route";

export const Body = async() => {
    const session = await getServerSession(authOptions);
    return (<div>{
            (session && session.user) ? <div>
            </div> :
            //not signed in
            <div className={"pt-16"}>
                <div className={"flex flex-col justify-center items-center text-center"}>
                    <div className={"text-6xl font-bold"}>Instant answers, endless conversations, endless
                        insights.
                    </div>
                    <div className={"text-neutral-400 p-4"}>Curiosity meets collaboration!</div>
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
                            Experience the thrill of real-time conversations with people around the world. Ask questions, provide answers, and engage in lively discussions as if you were in the same room. The immediacy of our platform ensures that you get instant responses and foster genuine connections.
                        </div>
                    </div>
                    <div>
                        <div className={"text-3xl py-2"}>Diverse Perspectives</div>
                        <div>{"Many rooms feature experts in their respective fields, offering valuable insights and expertise. Whether you're a beginner seeking guidance or an enthusiast wanting to delve deeper into a topic, you'll have the opportunity to interact with knowledgeable individuals who are passionate about sharing their expertise."}</div>
                    </div>
                    <div>
                        <div className={"text-3xl py-2"}>Community-driven Knowledge</div>
                        <div>Our platform thrives on the power of community. Users actively contribute to building a repository of knowledge, making it a go-to resource for information. The collective wisdom of the community ensures that you receive well-informed and thoughtful responses to your queries.</div>
                    </div>
                </div>
            </div>
        }
        </div>
    );
}
