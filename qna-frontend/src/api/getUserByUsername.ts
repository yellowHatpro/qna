import {url} from "@/lib/utils";

export default async function getUserByUsername (name:string) {
    const res = await fetch(`${url}/api/v1/users/find-by-username?username=${name}`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
