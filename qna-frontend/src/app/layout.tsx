import './globals.css'
import type { Metadata } from 'next'
import SessionProvider from "./SessionProvider"
import React from "react";
import {getServerSession} from "next-auth";
import {authOptions} from "@/app/api/auth/[...nextauth]/route";
import {User} from "@/ types/user";
import {Layout} from "@/components/layout";
export const metadata: Metadata = {
  title: 'qna',
  description: 'qna application',
}

export default async function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
    const session = await getServerSession(authOptions);

    return (
    <html lang="en">
      <body className={"dark"}>
      <SessionProvider>
          <Layout user = {session?.user as User}>
          {children}
          </Layout>
      </SessionProvider>
      </body>
    </html>
  )
}
