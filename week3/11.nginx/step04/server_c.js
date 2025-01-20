// 간단한 백엔드 서버, 3001번에서 동작
const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Node.js Server C\n');
});

server.listen(3003, () => {
    console.log('Server C running on http://localhost:3003\n');
});