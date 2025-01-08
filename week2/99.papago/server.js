import HTTP from 'superagent';
import express, {json} from 'express';
import dotenv from 'dotenv';


dotenv.config();

const app = express()
const port = 3000
app.use(express.static('public'));
app.use(express.json());

const CLIENT_ID = process.env.CLIENT_ID;
const CLIENT_SECRET = process.env.CLIENT_SECRET;

// lh:3-/로 접속 시 응답할 핸들러(엔드포인트)
app.get('/', (_, response) => {
    response.sendFile('index.html');
})

// lh:3-/detect/로 요청 시 응답할 핸들러 - POST:/detect
app.post('/detect', (request, response) => {
    // TODO: 언어 감지 요청 처리 로직
    HTTP.post( process.env.DETECT_LANGUAGE_URL) // 보낼 주소
        .send({ query: request.body.query}) // 보낼 데이터
        .set('x-ncp-apigw-api-key-id', CLIENT_ID) // 요청 헤더값 세팅
        .set('x-ncp-apigw-api-key', CLIENT_SECRET)
        .end((error, result) => { // 응답받은 결과값 취득
            if (result.statusCode === 200) {
                //TODO 값을 select에 다시 넣기
                response.send(result.body);
            } else {
                console.error(error);
            }
        });
});
app.post('/translate', (request, response) => {

    const TRANSLATE_LANGUAGE_URL = process.env.TRANSLATE_LANGUAGE_URL;

    const request_body = {
        //TODO 해당 값도 select에서 가져오기
        source: request.body.source,
        target: request.body.target,
        text: request.body.text
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