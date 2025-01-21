'use server'
import {z} from 'zod';
import deleteSession, {createSession} from "@/app/lib/session";
import {redirect} from "next/navigation";


const testUser={
    id:1,
    email:'1@1.com',
    password:'12345678'
}
// 유효성 검증 로직, Zod 라이브러리 활용
const loginSchema = z.object({
    email: z.string().email({ message: "Invalid email address" }).trim(),
    password: z
        .string()
        .min(8, { message: "Password must be at least 8 characters" })
        .trim(),
});


// 사용자가 submit 버튼을 클릭했을때 동작할 함수
// 로그인 로직
export async function login(prevState, formData) {

    // 1. 사용자가 입력한 값이 유효한지 확인(주로 회원가입)
    const result = loginSchema.safeParse(Object.fromEntries(formData));

    if (!result.success) { // 입력값이 유효하지 않을 경우, 에러 메시지를 반환
        return {
            errors: result.error.flatten().fieldErrors,
        };
    }

    const { email, password } = result.data; // 입력값이 유효할 경우 email, password 추출
    console.log(email,password);

    // 2. 인증을 수행하는 서버(주로 백엔드)로 전송(했다고 가정하고 skip)
    // 백엔드 서버 검증 로직
    if (email !== testUser.email || password !== testUser.password) {
        return {
            errors: {
                email: ["Invalid email or password"],
            },
        };
    }

    // 3. 인증이 성공했을 경우, 자체적으로 세션 정보 생성 후 쿠키에 저장
    await createSession(testUser.id);
    // 4. 사용자를 적절한 페이지로 이동(리다이렉트)
    redirect('/dashboard')
}

// 로그아웃 처리 함수
export async function logout() {
    // 1. 쿠키에서 세션 정보 제거
    deleteSession();
    // 2. 로그인 페이지 or 메인 페이지로 이동(리다이렉트)
    redirect('/login');
}