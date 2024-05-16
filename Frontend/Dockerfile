FROM node:latest AS builder

WORKDIR /react-app

COPY package.json .
RUN npm up && npm i 

COPY . .  
RUN npm run build 

#--------------------------------------- RUN ----------------------------------------

FROM node:latest AS production 

WORKDIR /react-app/prod

# copy Machine code files from build stage to run stage 
COPY --from=builder /react-app/dist/ ./dist/

COPY vite.config.js .
COPY package.json .
RUN npm up && npm i 
  
EXPOSE 4173

CMD [ "npm","run","preview"]