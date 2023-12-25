import * as React from 'react';
import {Navbar} from "@/components/navbar";
import {User} from "@/ types/user";
import {Footer} from "@/components/footer";
import {Sidebar} from "@/components/sidebar";

type Props = {
    children: React.ReactNode,
    user: User
};
export const Layout = ({children, user}: Props) => {
    return (
        <div className={"flex flex-col justify-between min-h-screen"}>
            <div className={"flex flex-col justify-top"}>
                <Navbar user={user}/>
                <div className={"flex flex-row min-w-screen"}>
                    <div className={"hidden md:flex w-1/5"}>
                        <Sidebar user={user}/>
                    </div>
                    <div className={"grow"}>
                        {children}
                    </div>
                </div>
            </div>
            <Footer/>
        </div>
    );
};
