export default async  function  ProductDetail ({params}){
    const {productId} = params;
    return (
        <div>상품 {productId} 디테일 페이지</div>
    );
}