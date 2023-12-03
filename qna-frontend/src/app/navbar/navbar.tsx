'use client'
import {signIn} from "next-auth/react";
import {Session} from "next-auth";

interface NavbarProps {
    session: Session | null
}

export const Navbar = ({session}: NavbarProps) => {
    return (session && session?.user) ?
     (
        <div className = {"flex flex-row justify-between "}>
            <div className={"px-5 font-thin"}>
                qna
            </div>
            <div className={"px-5"}>
                Profile div
            </div>
        </div>
    ) : (
        <nav className={"p-4 backdrop-blur-md fixed min-w-full flex flex-row items-center justify-between"}>
            <div>
                qna
            </div>
            <button className={"border rounded-sm p-1 hover:border-blue-200"}
            onClick={()=>signIn()}>
                LOG IN
            </button>
        </nav>
        )
}
