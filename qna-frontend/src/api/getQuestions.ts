import {url} from "@/lib/utils";

export default async function getAllQuestions () {
    const res = await fetch(`${url}/api/v1/questions`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
