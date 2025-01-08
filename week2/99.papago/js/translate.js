/*
//언어 감지 api 요청-응답 테스트
import HTTP from 'superagent';

//API 서버의 end-Point (url)
const DETECT_LANG_URL = 'https://naveropenapi.apigw.ntruss.com/nmt/v1/translation';


const request_body={
    source: 'auto',
    target: 'en',
    text:'Français'
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
