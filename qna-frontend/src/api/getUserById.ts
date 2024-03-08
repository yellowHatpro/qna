import {url} from "@/lib/utils";

export default async function getUserById (id:string) {
    const res = await fetch(`${url}/api/v1/users/find-by-userId?userId=${id}`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
