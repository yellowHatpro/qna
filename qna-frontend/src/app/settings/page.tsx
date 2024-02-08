import userStore from "@/store/userStore";
import SettingForm from "@/app/settings/settingForm";

export default async function SettingPage() {
    const user = userStore.getState()
    return (
        <>
            <h1 className={"text-4xl"}>Settings</h1>
            <section className={"flex flex-col"}>
                <SettingForm/>
            </section>
        </>
    )
}
