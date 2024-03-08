import { type ClassValue, clsx } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export function toDate(unixTime: string) {
  let date = new Date(parseInt(unixTime))
  let day = date.getDate()
  let month = date.getMonth() + 1
  let year = date.getFullYear()
  return `${day}/${month}/${year}`
}

export function toFullDate(unixTime: string) {
  let date = new Date(parseInt(unixTime))
  let hours = date.getHours()
  let minutes = date.getMinutes()
  let seconds = date.getSeconds()
  let day = date.getDate()
  let month = date.getMonth() + 1
  let year = date.getFullYear()
  let pm = (hours / 12) >= 1;
  return `${day}/${month}/${year}, ${hours % 12}:${minutes}:${seconds} ${pm ? "PM" : "AM"}`
}

export const env = process.env.NODE_ENV === "development" ? "development" : "production"
export const url = process.env.NODE_ENV === "development" ? "http://localhost:80" : "https://wa-qna.azurewebsites.net"
