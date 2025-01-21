'use client';

function getRandomInt(count) {
    return Math.floor(Math.random() * count);
}

export default async function ReviewDetail({ params }) {

    const random = getRandomInt(2);

    if (random === 1) {
        throw new Error('리뷰 페이지 로딩 과정에서 에러 발생');
    }

    const { reviewId, productId } = await params;

    if(Number(reviewId) > 10) {
        // Not-found 페이지 렌더링???
        // notFound(); // 프로그램 레벨에서(Programmatically) 처리
    }

    return (
        <div>상품 {productId}의 {reviewId}번째 리뷰</div>
    );
}