import {Body} from "@/app/body";
import {getServerSession} from "next-auth";
import {authOptions} from "@/app/api/auth/[...nextauth]/route";
import {User} from "@/ types/user";
import {Layout} from "@/components/layout";

export default async function Page() {
    const session = await getServerSession(authOptions);
    return (
    <>
      <Layout user = {session?.user as User}>
        <Body/>
      </Layout>
    </>
  )
}

