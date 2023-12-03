import {Navbar} from "@/app/navbar/navbar";
import {Body} from "@/app/body";
import {Footer} from "@/app/footer";
import {getServerSession} from "next-auth";
import {authOptions} from "@/app/api/auth/[...nextauth]/route";

export default async function Home() {
    const session = await getServerSession(authOptions);

    return (
    <main className="flex min-h-screen flex-col">
      <Navbar session = {session}/>
      <Body/>
      <Footer/>
    </main>
  )
}
