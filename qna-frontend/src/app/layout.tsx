import './globals.css'
import type { Metadata } from 'next'
import SessionProvider from "./SessionProvider"
import React from "react";
import {User} from "@/ types/user";
import {Layout} from "@/components/layout";
import getUserByEmail from "@/api/getUserByEmail";
import StoreInitializer from "@/components/storeInitializer";
import userStore from "@/store/userStore";
import {auth} from "../../auth";
export const metadata: Metadata = {
  title: 'qna',
  description: 'qna application',
}

export default async function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
    const session = await auth();
    if (session && session.user && session.user.email){
        const userData = await getUserByEmail(session.user.email)
        console.log(userData)
    }
    return (
    <html lang="en">
      <body className={"dark"}>
      <SessionProvider>
          <StoreInitializer user={userStore.getState()}/>
          <Layout user = {session?.user as User}>
          {children}
          </Layout>
      </SessionProvider>
      </body>
    </html>
  )
}
