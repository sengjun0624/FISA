export default async function ProductDetail(props) {
    const params = await props.params;
    return (
        <div>상품 {params.productId}번  상세 리뷰 {params.reviewId}페이지</div>
    );
}
