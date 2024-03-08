'use client'

import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { z } from "zod"
import { v4 as uuidv4 } from 'uuid';

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
import userStore from "@/store/userStore";
import {Question} from "@/ types/question";
import {url} from "@/lib/utils";

const FormSchema = z.object({
    questionTitle: z
        .string()
        .min(6, {
            message: "Title must be at least 6 characters.",
        })
        .max(160, {
            message: "Title must not be longer than 30 characters.",
        }),
    questionBody: z
        .string()
        .min(10, {
            message: "Body must be at least 10 characters.",
        }),
})

const AskPage = () => {
    const {id: userId} = userStore()
    const form = useForm<z.infer<typeof FormSchema>>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            questionBody: "",
            questionTitle: ""
        }
    })

    function onSubmit({questionTitle, questionBody}: z.infer<typeof FormSchema>) {
        const newQuestion : Question = {
            id: uuidv4(),
            title: questionTitle,
            description: questionBody,
            dateAsked: JSON.stringify(Date.now()),
            isResolved: false,
            topics: [],
            answerIds: [],
            questionerId: userId!
        }
        fetch(`${url}/api/v1/questions/create`, {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(newQuestion)}).then(
            ()=> {
                toast({
                    title: "Successfully created question ✅",
                    description: (
                        <pre className="mt-2 w-[340px] rounded-md p-4">
          <code className="text-white">{questionTitle}</code>
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
