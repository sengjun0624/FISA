import {detectLanguage, translateLanguage} from "./api/api.js";

const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
const [sourceTextArea, targetTextArea] = document.getElementsByTagName('textarea');

let targetLanguage = 'en';
targetSelect.addEventListener('change', (event) => targetLanguage = event.target.value);
// source String, target string, mp

let timer;

sourceTextArea.addEventListener('input', (event) => {
    if (timer) clearTimeout(timer);
    timer = setTimeout(async () => {
        const text = event.target.value;
        const detectedResult = await detectLanguage(text);
        const data= await translateLanguage(detectedResult, targetLanguage, event.target.value);
        sourceSelect.value = data.message.result.srcLangType;
        targetSelect.value = data.message.result.tarLangType;
        targetTextArea.value = data.message.result.translatedText;
    }, 2000)
})