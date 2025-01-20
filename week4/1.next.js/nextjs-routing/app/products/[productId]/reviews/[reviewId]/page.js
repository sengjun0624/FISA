import {notFound} from "next/navigation";

export default async function ProductDetail(props) {
    const {reviewId, productId} = await props.params;
    if (reviewId > 10) {
        notFound(); //프로그램 레벨에서 Programmatically
    } else {
        return (
            <div>상품 {productId}번 상세 리뷰 {reviewId}페이지</div>
        );
    }

}
