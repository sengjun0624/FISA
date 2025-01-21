"use client";
import {useEffect, useState} from "react";

export default function ClientPage() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        async function fetchProducts() {
            const response = await fetch('http://localhost:3001/products', {next: {revalidate: 3000}});
            setProducts(await response.json());
        }
        fetchProducts();
    }, []);

    return (
        <ul className="space-y-4 p-4">
            {products.map((product) => (
                <li
                    key={product.id}
                    className="p-4 bg-white shadow-md rounded-lg text-gray-700"
                >
                    <h2 className="text-xl font-semibold">{product.title}</h2>
                    <p>{product.description}</p>
                    <p className="text-lg font-medium">${product.price}</p>
                </li>
            ))}
        </ul>
    );
}