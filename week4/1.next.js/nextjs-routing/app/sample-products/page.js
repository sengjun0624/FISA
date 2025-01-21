import Link from "next/link";

const ProductList = () => {
    const productList = [1, 2, 3, 4]; // 상품 목록이 들어있는 리스트

    return (
        <div>
            <h1>Product List</h1>
            {/* Array.map()을 통해 동적으로 렌더링 */}
            {productList.map(productId => (
                <h2 key={productId}>
                    <Link href={`products/${productId}`}>Product {productId}</Link>
                </h2>
            ))}
        </div>
    );
}
export default ProductList;