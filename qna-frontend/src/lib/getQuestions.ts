export default async function getAllQuestions () {
    const res = await fetch('http://localhost:8080/api/v1/questions')
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
