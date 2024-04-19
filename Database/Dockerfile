
FROM mysql:latest

#ENV MYSQL_ROOT_PASSWORD =omar1234

COPY ./database.sql /docker-entrypoint-initdb.d/

WORKDIR /app

#RUN exec mysql -uroot -pomar1234 < /app/database.sql
#RUN mysql -uroot -p${MYSQL_ROOT_PASSWORD};
#RUN USE todolist;
#RUN ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '${MYSQL_ROOT_PASSWORD}';
#RUN FLUSH PRIVILEGES;


EXPOSE 3306

#docker run -d --rm -p3000:3306 --name DatabaseContainer -e MYSQL_ROOT_PASSWORD=omar1234 database:v1