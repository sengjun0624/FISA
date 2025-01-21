import Link from "next/link";

export default function Home() {
    return (
        <>
            <main>Hello Next!</main>
            <Link href="/blog" className="text-2xl text-blue-500 underline">블로그</Link><br/>
            <Link href="/products" className="text-2xl text-blue-500 underline">상품</Link>
        </>
    );
}
