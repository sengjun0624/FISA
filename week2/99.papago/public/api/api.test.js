//테스트 코드 작성 파일 네이밍 규칙 -> 테스트할 파일명 .test.js
import {expect, test} from "vitest";
import { detectLanguage } from "./api";//테스트 케이스 작성

//test("테스트 시나리오, 가설", 실행시킬 테스트 코드);
const BASE_URL = "http://localhost:3000"
test("\"안녕\"이라고 작성할 경우, 한국어로 감지된다.", async () => {
    //콜백 안에 실행시킬 테스트 코드 작성
    //기본적인 테스트 코드 작성 컨벤션 or 템플릿, Given-When-Then

    //Given - 테스트 코드 수행에 필요한 조건, 주어진 값들을 명시
    const expected = "ko";
    const text = "안녕";
    const url = `${BASE_URL}/detect`;


    // When - 특정 상황, 실제 테스트할 함수나 로직 호출 부분
    const result = await detectLanguage(url, text);

    //Then -  상황에 대한 결과값 검증
    expect(result).toBe(expected);
})