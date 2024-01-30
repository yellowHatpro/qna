'use client'

import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"

import { Button } from "@/components/ui/button"
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form"
import { Textarea } from "@/components/ui/textarea"
import { toast } from "@/components/ui/use-toast"
import {Input} from "@/components/ui/input";

const FormSchema = z.object({
    questionTitle: z
        .string()
        .min(10, {
            message: "Title must be at least 10 characters.",
        })
        .max(160, {
            message: "Bio must not be longer than 30 characters.",
        }),
    questionBody: z
        .string()
        .min(10, {
            message: "Body must be at least 10 characters.",
        }),
})

const AskPage = () => {
    const form = useForm<z.infer<typeof FormSchema>>({
        resolver: zodResolver(FormSchema),
    })

    function onSubmit(data: z.infer<typeof FormSchema>) {
        toast({
            title: "You submitted the following values:",
            description: (
                <pre className="mt-2 w-[340px] rounded-md p-4">
          <code className="text-white">{JSON.stringify(data, null, 2)}</code>
        </pre>
            ),
        })
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
                <FormField
                    control={form.control}
                    name="questionTitle"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Title</FormLabel>
                            <FormControl>
                                <Input
                                    placeholder="Enter your title here"
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
                    name="questionBody"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Body</FormLabel>
                            <FormControl>
                                <Textarea
                                    placeholder="Tell us a little bit about your doubt"
                                    className="resize-none"
                                    {...field}
                                />
                            </FormControl>
                            <FormDescription>
                                Please follow the community guidelines before creating a doubt.
                            </FormDescription>
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <Button type="submit">Submit</Button>
            </form>
        </Form>
    )
}

export default AskPage
