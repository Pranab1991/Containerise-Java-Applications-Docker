FROM maven:3.6.3-jdk-8-slim

WORKDIR /home

COPY . .

RUN mvn clean install -DskipTests

WORKDIR /home/target

ENV SERVICE_PORT=mysqldb:3306
ENV DBNAME=bootdb
ENV USERNAME=root
ENV PASSWORD=root

EXPOSE 8080

CMD [ "java","-jar","dockerTest-0.0.1-SNAPSHOT.jar" ]



