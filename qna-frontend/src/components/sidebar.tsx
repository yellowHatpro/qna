import * as React from 'react';
import {User} from "@/ types/user";
import {FaUser} from "react-icons/fa";
import Image from "next/image";
import {Suspense} from "react";

type SidebarProps = {
    user: User
};
export const Sidebar = ({user}: SidebarProps) => {
    return (
        <div className={"flex flex-col text-sm items-center min-w-full"}>
            <div className={"flex flex-col items-center"}>
                <Suspense fallback={
                    <FaUser/>
                }>
                    <Image
                        className={"rounded-full"}
                        src={user.image}
                        width={150}
                        height={150}
                        alt={user?.name ?? "pp"}
                        priority={true}/>
                </Suspense>
                <text>{user.name}</text>
            </div>
            <div className={"flex flex-col child:m-2 child:p-1 child:bg-gray-500 child:w-full child:rounded"}>
                <button>
                    Questions
                </button>
                <button>
                    Saved
                </button>
                <button>
                   Tags
                </button>
                <button>
                    Profile
                </button>
                <button>
                    Logout
                </button>
            </div>
            </div>
    );
};
