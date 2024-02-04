'use client'

import {User} from "@/ types/user";
import {useRef} from "react";
import userStore from "@/store/userStore";

interface UserProp {
    user: User
}

export default function StoreInitializer({user}: UserProp) {
    const initialized = useRef(false)
    if (!initialized.current) {
        userStore.setState(user)
        initialized.current = true
    }
    return null
}
