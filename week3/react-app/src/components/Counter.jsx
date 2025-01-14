import { useState } from "react"; // const { useState } = React;와 동일한 코드

// 하나의 파일은 하나의 컴포넌트(Single File Component)
const Counter = () => {
    const [count, setCount] = useState(0);

    console.log('Counter 컴포넌트가 호출됨(렌더링됨)');

    const clickHandler = () => {
        setCount(count + 1);
    }

    return (
        <div>
            <p>You clicked {count} times</p>
            <button onClick={clickHandler}>Click me</button>
        </div>
    )
}

export default Counter; // 다른 파일에서 사용할 수 있도록 추출(export)