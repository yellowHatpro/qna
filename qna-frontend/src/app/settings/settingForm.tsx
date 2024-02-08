'use client'

import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { Button } from "@/components/ui/button"
import {
    Form,
    FormControl,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form"
import {Input} from "@/components/ui/input";
import userStore from "@/store/userStore";
import {toast} from "@/components/ui/use-toast";
import {User} from "@/ types/user";

const FormSchema = z.object({
    name: z.string(),
    phoneNumber: z
        .string()
        .min(10, {
            message: "Number must be at least 10 characters.",
        }),
})

const SettingForm = () => {
    const user = userStore()
    const form = useForm<z.infer<typeof FormSchema>>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            name: "",
            phoneNumber: ""
        }
    })

    function onSubmit({name, phoneNumber}: z.infer<typeof FormSchema>) {
        const newUser: User = {
            ...user,
            name: name,
            phoneNumber: phoneNumber
        }
        fetch("http://localhost:8080/api/v1/users/update", {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(newUser)}).then(
            ()=> {
                toast({
                    title: "Successfully created question ✅",
                    description: (
                        <pre className="mt-2 w-[340px] rounded-md p-4">
          <code className="text-white">User updated successfully ✅</code>
        </pre>
                    ),
                })
            }
        )
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
                <FormField
                    control={form.control}
                    name="name"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Name</FormLabel>
                            <FormControl>
                                <Input
                                    placeholder={user.firstName??
                                "Enter your name"}
                                    className="resize-none"
                                    {...field}
                                />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="phoneNumber"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Phone number</FormLabel>
                            <FormControl>
                                <Input
                                    placeholder={user.phoneNumber??
                                        "Enter your phone number"}
                                    className="resize-none"
                                    {...field}
                                />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <Button type="submit">Submit</Button>
            </form>
        </Form>
    )
}

export default SettingForm
