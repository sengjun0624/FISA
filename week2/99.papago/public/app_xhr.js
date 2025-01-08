let timeout = 2000;
let timer;
const [sourceSelect, targetSelect] = document.getElementsByTagName('select');
const [sourceTextArea, targetTextArea] = document.getElementsByTagName('textarea');

function callTranslate(request) {
    const xhr = new XMLHttpRequest();
    xhr.onload = () => {
        if (xhr.readyState === xhr.DONE && xhr.status === 200) {
            const result = JSON.parse(xhr.responseText);
            console.log(result);
            targetTextArea.value = result.message.result.translatedText;
        }
    }
    let data = {
        text: request
        , source: sourceSelect.value
        , target: targetSelect.value
    };
    xhr.open('POST', '/translate');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(data));
}

sourceTextArea.addEventListener('input', (event) => {
    if (timer) clearTimeout(timer);
    timer = setTimeout(() => {
        //입력된 값으로 detect를 호출하는 함수
        detectLanguageAndTranslate(event.target.value);
    }, timeout);
})


/**
 *
 * @param text input에 입력된 값
 */
function detectLanguageAndTranslate(text) {
    const xhr = new XMLHttpRequest();

    xhr.onload = () => {
        if (xhr.readyState === xhr.DONE && xhr.status === 200) {
            const langCode = JSON.parse(xhr.responseText).langCode;
            sourceSelect.value = (langCode === 'ko' || langCode === 'en' || langCode === 'ja') ? langCode : 'auto';
            callTranslate(text);
        }
    }

    let request = {'query': text};
    xhr.open('POST', '/detect');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(request));
}


// source String, target string, mp