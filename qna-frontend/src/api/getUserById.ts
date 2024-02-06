export default async function getUserById (id:string) {
    const res = await fetch(`http://localhost:8080/api/v1/users/find-by-userId?userId=${id}`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
