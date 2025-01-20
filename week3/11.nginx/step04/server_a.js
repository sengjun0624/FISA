// 간단한 백엔드 서버, 3001번에서 동작
const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end('Node.js Server A\n');
});

server.listen(3001, () => {
    console.log('Server A running on http://localhost:3001\n');
});