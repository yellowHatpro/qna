'use client'

import userStore from "@/store/userStore";
import {useForm} from "react-hook-form";
import {z} from "zod";
import {zodResolver} from "@hookform/resolvers/zod";
import {v4 as uuidv4} from "uuid";
import {toast} from "@/components/ui/use-toast";
import {Form, FormControl, FormDescription, FormField, FormItem, FormLabel, FormMessage} from "@/components/ui/form";
import {Input} from "@/components/ui/input";
import {Textarea} from "@/components/ui/textarea";
import {Button} from "@/components/ui/button";
import {Answer} from "@/ types/answer";
import {url} from "@/lib/utils";

const FormSchema = z.object({
    answerTitle: z
        .string()
        .min(6, {
            message: "Title must be at least 6 characters.",
        })
        .max(160, {
            message: "Title must not be longer than 30 characters.",
        }),
    answerBody: z
        .string()
        .min(10, {
            message: "Body must be at least 10 characters.",
        }),
})

interface AnswerFormProps {
    questionId: string
}

export const AnswerForm = ({questionId}:AnswerFormProps ) => {
    const {id: userId} = userStore()
    const form = useForm<z.infer<typeof FormSchema>>({
        resolver: zodResolver(FormSchema),
        defaultValues: {
            answerBody: "",
            answerTitle: ""
        }
    })

    function onSubmit({answerTitle, answerBody}: z.infer<typeof FormSchema>) {
        const newAnswer : Answer = {
            id: uuidv4(),
            title: answerTitle,
            body: answerBody,
            totalUpvotes: 0,
            userId: userId!,
            questionId: questionId,
            dateAnswered:  Date.now().toString()
        }
        fetch(`${url}/api/v1/answers`, {
            headers: {
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify(newAnswer)}).then(
            ()=> {
                toast({
                    title: "Successfully answered ✅",
                    description: (
                        <pre className="mt-2 w-[340px] rounded-md p-4">
          <code className="text-white">{JSON.stringify(newAnswer,null, 2)}</code>
        </pre>
                    ),
                })
            }
        )
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="w-full flex flex-col space-y-6">
                <FormField
                    control={form.control}
                    name="answerTitle"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Answer Title</FormLabel>
                            <FormControl>
                                <Input
                                    placeholder="Enter your answer title here"
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
                    name="answerBody"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Describe your answer</FormLabel>
                            <FormControl>
                                <Textarea
                                    placeholder="Write your answer body here"
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
