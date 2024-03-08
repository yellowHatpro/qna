import {User} from "@/ types/user";
import userStore from "@/store/userStore";
import {url} from "@/lib/utils";

export default async function getUserByEmail (email: string) {
    const res = await fetch(`${url}/api/v1/users/find-by-email`, {
        method: "POST",
        body: email
    })
    if (!res.ok) throw new Error("Something went wrong")
    const user: User = await res.json()
    userStore.setState(user)
    return user
}
