'use client'
import * as React from 'react';
import {User} from "@/ types/user";
import {FaUser} from "react-icons/fa";
import Image from "next/image";
import {Suspense} from "react";
import {signOut} from "next-auth/react";

type SidebarProps = {
    user: User
};
export const Sidebar = ({user}: SidebarProps) => {
    return (
        user && <div className={"flex flex-col text-sm items-center min-w-full"}>
            <div className={"flex flex-col items-center"}>
                <text>{user?.name}</text>
            </div>
            <div className={"flex flex-col child:m-2 child:p-1 hover:child:bg-neutral-900 child:w-full  w-full px-8 child:rounded"}>
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
                <button onClick={()=> signOut()}>
                    Logout
                </button>
            </div>
            </div>
    );
};
