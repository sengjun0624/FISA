let g = 0;

function setGWith100() {
    console.log('setGWith100 started');
    setTimeout(() => g = 100, 1000); // 상위 스코프인 g에 100으로 재할당
    console.log('setGWith100 ended');
    return g; // g의 값을 반환
}

const result = setGWith100();

console.log(result);
console.log(g);

/**
 * 왜 g가 0?
 *
 */