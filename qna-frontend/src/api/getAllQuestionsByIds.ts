import {url} from "@/lib/utils";

export default async function getAllQuestionsByIds (ids:string[]) {
    const [res] = await Promise.all([Promise.all(ids.map(id => fetch(`${url}/api/v1/questions/${id}`)))])
    if (!res) throw new Error('failed to fetch data')
    const questionsPromises =  res.map(item=>item.json())
    return await Promise.all(questionsPromises)
}
