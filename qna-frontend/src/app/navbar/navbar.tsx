import {UserMenuDropDown} from "@/app/navbar/user_menu_dropdown";
import {getServerSession} from "next-auth";
import {authOptions} from "@/app/api/auth/[...nextauth]/route";

export default async function Navbar() {
    const session = await getServerSession(authOptions);
    return (
        <div className = {"flex flex-row min-w-full justify-between items-stretch"}>
            <div className={"px-5"}>
                qna
            </div>
            <div className={"px-5"}>
                <UserMenuDropDown session={session}/>
                Profile div
            </div>
        </div>
    )
}