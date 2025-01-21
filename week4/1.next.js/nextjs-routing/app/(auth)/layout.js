'use client';
import Link from "next/link";
import {usePathname} from "next/navigation";

const navLinks = [
    { name: 'Regiser', href: '/register' },
    { name: 'Login', href: '/login' },
    { name: 'Forgot-Password?', href: '/forgot-password' },
];
/*
* client로 처리하다보니까 개발자도구 console에 로그가 찍힘.
* 기본적으로는 서버사이들 렌더링임.
* */

export default function AuthLayout({children}) {
    // navLinks를 활용하여 네비게이션 할 수 있도록 구현
    const pathName = usePathname();
    console.log(pathName);
    return (

        <section>
            {navLinks.map(link => {
                const isActive = pathName.startsWith(link.href);
                return (
                    <Link
                        className={`text-2xl text-blue-500 ${isActive ? 'text-red-500' : ''}`}
                        href={link.href}
                        key={link.name}>
                        {link.name}&nbsp;
                    </Link>
                )
            })}
            {children}
        </section>
    );
}