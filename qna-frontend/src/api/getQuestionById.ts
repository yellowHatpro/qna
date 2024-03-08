import {url} from "@/lib/utils";

export default async function getQuestionById (id:string) {
    const res = await fetch(`${url}/api/v1/questions/${id}`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
