// 언어 감지
const detectLanguage = (text) => {
    const url = '/detect';
    const body = {query: text}
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: body
    }
    //fetch API
    fetch(url, options)
        .then(response => response.json())
        .then(data=>console.log(data))
}
const translateLanguage = () => {
    const url = '/translage';

    fetch(url,)
}

// 번역