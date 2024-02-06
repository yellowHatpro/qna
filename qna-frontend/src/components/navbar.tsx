'use client'
import {User} from "@/ types/user";
import {Avatar, AvatarFallback, AvatarImage} from "@/components/ui/avatar";
import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem, DropdownMenuSeparator,
    DropdownMenuTrigger
} from "@/components/ui/dropdown-menu";
import Link from "next/link";
import {signIn, signOut} from "next-auth/react";
import userStore from "@/store/userStore";

export interface NavbarProps {
    user: User | null | undefined
}
export const Navbar = ({user}: NavbarProps) => {
    const {username} = userStore()

    return (user) ? (
        <header
            className="sticky top-0 z-50 w-full border-b bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60">
            <div className={"flex flex-row items-center justify-between w-full p-2"}>
                <Link href={"/"}>
                    <text className={"font-light hover:bg-neutral-700 p-2 rounded-md"}>
                        qna
                    </text>
                </Link>
                <DropdownMenu>
                    <DropdownMenuTrigger>
                        <Avatar>
                            <AvatarImage src={user?.image as string}/>
                            <AvatarFallback>AZ</AvatarFallback>
                        </Avatar>
                    </DropdownMenuTrigger>
                    <DropdownMenuContent>
                        <Link href={`/profile/${username}`}>
                            <DropdownMenuItem>
                                Profile
                            </DropdownMenuItem>
                        </Link>
                        <DropdownMenuSeparator/>
                        <Link href={"/settings"}>
                            <DropdownMenuItem>
                                Settings
                            </DropdownMenuItem>
                        </Link>
                        <DropdownMenuSeparator/>
                        <DropdownMenuItem onClick={()=> signOut()}>
                            Log Out
                        </DropdownMenuItem>
                    </DropdownMenuContent>
                </DropdownMenu>
            </div>
        </header>
    ) : (
        <nav className={"p-4 backdrop-blur-md fixed min-w-full flex flex-row items-center justify-between"}>
            <div>
                qna
            </div>
            <button className={"border rounded-sm p-1 hover:border-blue-200"}
                    onClick={() => signIn()}>
                LOG IN
            </button>
        </nav>
    )
}

