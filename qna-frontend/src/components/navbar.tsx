import {User} from "@/ types/user";
import {NavBarContent} from "@/components/navbarContent";


export interface NavbarProps {
    user: User | null | undefined
}
export const Navbar = async ({user}: NavbarProps) => {
    return <NavBarContent user={user}/>
}
