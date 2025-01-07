let timeout = 2000;
let timer;

const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
const [sourceTextArea, targetTextArea] = document.getElementsByTagName('textarea');

// 요청을 보낼 함수 정의
async function sendRequest() {
    try {
        const response = await axios.post('http://localhost:3000/detect', {
            data: 'some data', // 서버에 보낼 데이터
        });
        console.log('Response:', response.data); // 서버에서 온 응답 출력
    } catch (error) {
        console.error('Error:', error);
    }
}

sourceTextArea.addEventListener('input', (event) => {
    if (timer) clearTimeout(timer);
    timer = setTimeout(() => {
        //값을 채우고
        //api로 axios 보내고 그 값으로 처리.
        console.log('2초 지남');
        const data = event.target.value;
        let request = {'query': data}
        let lang_code;
        axios.post('/detect', request).then(res => {
            lang_code = res.data.langCode;
        });

        request = {'data': data}

        axios.post('/translate', request).then(res => {
            console.log(res.data.message.result.translatedText);
            targetTextArea.value=res.data.message.result.translatedText;
        });
    }, timeout);
})


// source String, target string, mp