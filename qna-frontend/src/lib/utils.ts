import { type ClassValue, clsx } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export function toDate(unixTime: string){

  let date = new Date(parseInt(unixTime))
  let hours = date.getHours()
  let minutes = date.getMinutes()
  let seconds = date.getSeconds()
  let day = date.getDate()
  let month = date.getMonth()+1
  let year = date.getFullYear()
  let pm = (hours/12)>=1;
 return `${hours%12}:${minutes}:${seconds} ${pm ? "PM" : "AM"}, ${day}/${month}/${year}`
}
