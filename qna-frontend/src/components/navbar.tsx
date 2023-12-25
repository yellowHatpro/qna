'use client'
import {signIn} from "next-auth/react";
import Image from "next/image";
import {User} from "@/ types/user";
import {Suspense} from "react";
import {FaUser} from "react-icons/fa";
import {qnaLogo} from "../../public";
import {CgMenu} from "react-icons/cg";

interface NavbarProps {
    user: User | null | undefined
}

export const Navbar = ({user}: NavbarProps) => {
    return (user) ?
        (
            <div className = {"flex flex-row justify-between items-center p-4"}>
                <div className={"flex flex-row items-center"}>
                    <button className={"md:hidden text-3xl m-3"} onClick={()=>null}>
                        <CgMenu/>
                    </button>
                    <Image
                        className={"hidden md:block"}
                        src={qnaLogo}
                           height={25}
                           width={25}
                           alt={""}/>
                    <div className={"px-5 text-2xl font-thin"}>
                        qna
                    </div>
                </div>
                <div className={"px-5"}>
                    <Suspense fallback={
                        <FaUser/>
                    }>
                        <Image
                            className={"rounded-full"}
                            src={user.image}
                            width={50}
                            height={50}
                            alt={user?.name ?? "pp"}
                            priority={true}/>
                    </Suspense>
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
