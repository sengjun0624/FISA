// 언어 감지
export const detectLanguage = async (text) => {
    let sourceLanguage;
    const url = '/detect';
    const body = {query: text}
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    }
    //fetch API
    await fetch(url, options)
        .then(response => response.json())
        .then(data => sourceLanguage = data.langCode);
    return sourceLanguage;
}
export const translateLanguage = async (source, target, text) => {
    const url = '/translate';
    const body = {source, target, text};
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    }
    let ret;
    await fetch(url, options)
        .then(response => response.json())
        .then(data => ret = data)

    return ret;
}

// 번역