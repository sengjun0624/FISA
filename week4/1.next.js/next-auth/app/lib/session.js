// 세션 정보 생성, 세션 정보 제거, 생성한 토큰 암호화, 복호화 등의 유틸함수 모음

import {jwtVerify, SignJWT} from "jose";
import {cookies} from "next/headers";


const secretKey = process.env.SESSION_SECRET;
const encodedKey = new TextEncoder().encode(secretKey);

// 세션 생성 함수
export async function createSession(userId) {

    // 세션 만료 시간
    const expiresAt = new Date(Date.now() + 7 * 24 * 60 * 60 * 1000);

    // 세션 생성(암호화해서 생성)
    const session = await encrypt({userId, expiresAt});

    // 만든 세션을 쿠키에 저장
    (await cookies()).set('session', session, {
        httpOnly: true,
        secure: true,
        expires: expiresAt,
    });
}

export default  async function deleteSession() {
    (await cookies()).delete('session');
}

// JWT 토큰 생성
export async function encrypt(payload) {
    return new SignJWT(payload)
        .setProtectedHeader({alg: "HS256"})
        .setIssuedAt()
        .setExpirationTime("7d")
        .sign(encodedKey);
}

// 토큰 복호화
export async function decrypt(session) {

    try {
        const {payload} = await jwtVerify(session, encodedKey, {
            algorithms: ["HS256"],
        });

        return payload;
    } catch (error) {
        console.log("Failed to verify session");
    }
}