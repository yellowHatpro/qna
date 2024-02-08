export default async function getAllAnswersByIds (ids:string[]) {
    const [res] = await Promise.all([Promise.all(ids.map(id => fetch(`http://localhost:8080/api/v1/answers/find-by-answerId?answerId=${id}`)))])
    if (!res) throw new Error('failed to fetch data')
    const answersPromises =  res.map(item=>item.json())
    return await Promise.all(answersPromises)
}
