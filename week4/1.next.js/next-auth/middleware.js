// middleware.js
import { NextResponse } from 'next/server'
import { decrypt } from '@/app/lib/session'
import { cookies } from 'next/headers'

// 1. 접근을 제한할 경로와 별도의 권한이 없어도 접근할 수 있는 경로를 구분
const protectedRoutes = ['/dashboard']
const publicRoutes = ['/login', '/signup', '/']

export default async function middleware(req) {
    // 2. 현재 URL로 요청된 경로가 public인지 protected 라우트인지 확인
    const path = req.nextUrl.pathname
    const isProtectedRoute = protectedRoutes.includes(path)
    const isPublicRoute = publicRoutes.includes(path)

    // 3. 쿠키에서 암호화된 세션 정보를 복호화
    const cookie = (await cookies()).get('session')?.value
    const session = await decrypt(cookie)

    // 5. 아직 로그인을 수행하지 않은 사용자일 경우 로그인 페이지로 리다이렉트
    if (isProtectedRoute && !session?.userId) {
        return NextResponse.redirect(new URL('/login', req.nextUrl))
    }

    // 6. 인증된 사용자의 경우 보호된 경로인 /dashboard로 리다이렉트
    if (
        isPublicRoute &&
        session?.userId &&
        !req.nextUrl.pathname.startsWith('/dashboard')
    ) {
        return NextResponse.redirect(new URL('/dashboard', req.nextUrl))
    }

    return NextResponse.next()
}

// api, static 경로 등에 대해서는 미들웨어가 동작하지 않도록 적용
export const config = {
    matcher: ['/((?!api|_next/static|_next/image|.*\\.png$).*)'],
}