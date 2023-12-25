import './globals.css'
import type { Metadata } from 'next'
import SessionProvider from "./SessionProvider"
import React from "react";


export const metadata: Metadata = {
  title: 'qna',
  description: 'qna application',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body>
      <SessionProvider>
          {children}
      </SessionProvider>
      </body>
    </html>
  )
}
