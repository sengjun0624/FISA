import HTTP from 'superagent';
import express from 'express';

const app = express()
const port = 3000
app.use(express.static('public'));
app.use(express.json());

const CLIENT_ID = 'lwd4vv7k1c'
const CLIENT_SECRET = 'rQaWHJyZNNkEsiE84lWTfiB2WNxmkGPhKqkd6D2Y'

// lh:3-/로 접속 시 응답할 핸들러(엔드포인트)
app.get('/', (_, response) => {
    response.sendFile('index.html');
})

// lh:3-/detect/로 요청 시 응답할 핸들러 - POST:/detect
app.post('/detect', (request, response) => {
    console.log('POST: /detect called');
    console.log(request.body);
    // TODO: 언어 감지 요청 처리 로직
    const DETECT_LANGUAGE_URL = 'https://naveropenapi.apigw.ntruss.com/langs/v1/dect';

    const requestBody = {
        query: request.body.query
    }

    HTTP.post(DETECT_LANGUAGE_URL) // 보낼 주소
        .send(requestBody) // 보낼 데이터
        .set('x-ncp-apigw-api-key-id', CLIENT_ID) // 요청 헤더값 세팅
        .set('x-ncp-apigw-api-key', CLIENT_SECRET)
        .end((error, result) => { // 응답받은 결과값 취득
            if (result.statusCode === 200) {
                 response.send(result.body);
            } else {
                console.error(error);
            }
        });
});
app.post('/translate', (request, response) => {
    console.log('POST: /translate called');

    const TRANSLATE_LANGUAGE_URL = 'https://naveropenapi.apigw.ntruss.com/nmt/v1/translation';
    const request_body = {
        source: 'ko',
        target: 'en',
        text: request.body.data
    }

    HTTP.post(TRANSLATE_LANGUAGE_URL) // 보낼 주소
        .send(request_body) // 보낼 데이터
        .set('x-ncp-apigw-api-key-id', CLIENT_ID) // 요청 헤더값 세팅
        .set('x-ncp-apigw-api-key', CLIENT_SECRET)
        .end((error, result) => { // 응답받은 결과값 취득
            if (result.statusCode === 200) {
                response.send(result.body);
            } else {
                console.error(error);
            }
        });
});
app.listen(port,
    () => console.log(`http://127.0.0.1:${port}/ 서버 프로세스가 3000번 포트에서 실행 중입니다.`)
);