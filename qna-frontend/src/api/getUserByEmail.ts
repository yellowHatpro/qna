import {User} from "@/ types/user";
import userStore from "@/store/userStore";

export default async function getUserByEmail (email: string) {
    const res = await fetch('http://localhost:8080/api/v1/users/find-by-email', {
        method: "POST",
        body: email
    })
    if (!res.ok) throw new Error("Something went wrong")
    const user: User = await res.json()
    userStore.setState(user)
    return user
}
