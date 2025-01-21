'use client'

import { useRouter } from "next/navigation";

// localhost:3000/order-product
export default function Page() {

    const router = useRouter();

    const clickHandler = () => {
        // 클라이언트 컴포넌트에서 사용자를 특정 경로로 라우팅시키기 위해서는 useRouter() 사용
        router.push('/'); // 루트 페이지로 이동
        // 단순 뒤로가기는 back(), 히스토리 기록을 남기지 않는 replace()
    }

    return (
        <>
            <h1>상품 주문</h1>
            <button className="p-2 text-white bg-black border" onClick={clickHandler}>Place an order</button>
        </>
    );
}