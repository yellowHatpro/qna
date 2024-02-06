export default async function getUserByUsername (name:string) {
    const res = await fetch(`http://localhost:8080/api/v1/users/find-by-username?username=${name}`)
    if (!res.ok) throw new Error('failed to fetch data')
    return res.json()
}
