import {Inter, JetBrains_Mono, Roboto} from "next/font/google";

export const roboto = Roboto({
    weight: ['100', '400', '700'],
    subsets: ['latin'],
    display: 'swap',
    variable: '--font-roboto',
})

export const jetbrains = JetBrains_Mono({
    subsets: ['latin'],
    weight: ['100','200','300','400','500','600','700','800'],
    display : 'swap',
    variable: '--font-jetbrains',
})

export const inter = Inter({
    subsets: ['latin'],
    weight: ['100','200','300','400','500','600','700','800'],
    display: 'swap',
    variable: '--font-inter'
})
