export default async function getQuestionById (id:string) {
    const res = await fetch(`http://localhost:8080/api/v1/questions/${id}`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
