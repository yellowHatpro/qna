import {StaticImport} from "next/dist/shared/lib/get-img-props";

export type User = {
    name?: string | null | undefined;
    email?: string | null | undefined;
    image: string | StaticImport
}
