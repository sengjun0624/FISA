export default function ProductDetail ({params}){
    const { id } = await params
    return (
        <div>상품 {params.productId}번  상세 리뷰 {params.reviewId}페이지</div>
    );
}