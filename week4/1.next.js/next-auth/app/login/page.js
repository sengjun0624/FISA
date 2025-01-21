import Link from "next/link";
import LoginForm from "@/components/auth/Loginform";

export default function Home() {
    return (
        <main className="flex flex-col items-center mt-4">
            <LoginForm/>
        </main>
    );
}



