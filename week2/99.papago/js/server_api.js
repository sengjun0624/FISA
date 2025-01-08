/*
//언어 감지 api 요청-응답 테스트
import HTTP from 'superagent';

//API 서버의 end-Point (url)
const DETECT_LANG_URL = 'https://naveropenapi.apigw.ntruss.com/langs/v1/dect';

const request_body={
    query: '안녕'
}

HTTP.post(DETECT_LANG_URL)
.send(request_body)
.set("x-ncp-apigw-api-key-id" ,CLIENT_ID)
.set("x-ncp-apigw-api-key",CLIENT_SECRET)
.end((error,result)=>{
    if (result.statusCode == 200) {
        console.log(result.body);
    }else console.error(error);
});*/
