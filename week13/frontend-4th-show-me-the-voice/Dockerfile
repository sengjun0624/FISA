# 1단계: 빌드용
FROM node:18-alpine AS builder

# node-gyp가 필요한 의존성 설치
RUN apk add --no-cache python3 make g++

# 작업 디렉토리
WORKDIR /app

# 의존성 설치
COPY package*.json ./
RUN npm install

# 전체 프로젝트 복사 후 빌드
COPY . .
RUN npm run build

# 2단계: 런타임 이미지
FROM node:18-alpine AS runner

WORKDIR /app

# 환경 설정
ENV NODE_ENV=production

# 의존 파일 복사
COPY --from=builder /app/public ./public
COPY --from=builder /app/.next ./.next
COPY --from=builder /app/node_modules ./node_modules
COPY --from=builder /app/package.json ./package.json

EXPOSE 3000

CMD ["npm", "start"]

