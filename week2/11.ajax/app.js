// 1. Ajax API인 XMLHttpRequest() 인스턴스 (객체) 생성
const xhr = new XMLHttpRequest();
// console.log(xhr);
// 2. onload 이벤트 프로퍼티에 서버로부터의 응답이 완료되었는지 확인하는 코드 작성
xhr.onload = () => {
    // 요청이 완료되었고 상태코드가 200일때
    if(xhr.readyState === xhr.DONE && xhr.status === 200){
        const responseData = xhr.responseText;

        // 서버에서 받은 응답(responseData)을 JSON.parse()로 파싱하여 자바스크립트 객체로 변환
// 객체에서 username 속성을 추출하여 콘솔에 출력
        console.log(JSON.parse(responseData));
    }
}

// 3. 실제 요청을 준비하는 코드 (open))
//1번 유저의 더미 데이터를 GET
const REQUEST_URL = 'https://jsonplaceholder.typicode.com/users/1';
xhr.open('GET', REQUEST_URL);

//4. 실제 요청 전송
xhr.send();