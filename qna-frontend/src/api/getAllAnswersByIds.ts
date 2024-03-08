import {url} from "@/lib/utils";

export default async function getAllAnswersByIds (ids:string[]) {
    const [res] = await Promise.all([Promise.all(ids.map(id => fetch(`${url}/api/v1/answers/find-by-answerId?answerId=${id}`)))])
    if (!res) throw new Error('failed to fetch data')
    const answersPromises =  res.map(item=>item.json())
    return await Promise.all(answersPromises)
}
