//테스트 코드 작성 파일 네이밍 규칙 -> 테스트할 파일명 .test.js
import {expect, test} from "vitest";
import {changeLanguage} from "./util.js";

test("한국어 => 한국어 , expeect 한국어 => 영어", async ()=>{

    //given
    const sourceLangCode ="ko";
    const targetLangCode ="ko";
    const expected="en"
    //when
    const result = await changeLanguage(sourceLangCode, targetLangCode);
    //then
    expect(result).toBe(expected);
});
test("영어 => 영어 , expeect 영어 => 한국어", async ()=>{

    //given
    const sourceLangCode ="en";
    const targetLangCode ="en";
    const expected="ko"
    //when
    const result = await changeLanguage(sourceLangCode, targetLangCode);
    //then
    expect(result).toBe(expected);
});