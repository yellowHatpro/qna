import {create} from "zustand";
import {User} from "@/ types/user";

const userStore = create<User>((set) => ({
   user: {},
}))

export default userStore
