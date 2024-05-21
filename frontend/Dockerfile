FROM node:16.16.0-alpine3.16
WORKDIR /APP
COPY package*.json .
RUN npm install
COPY . .
ENV API_URL=http://localhost
EXPOSE 3000
CMD [ "npm", "start" ]
