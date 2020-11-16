FROM openjdk:8-jdk-alpine
MAINTAINER demo
VOLUME /tmp
RUN apk update
ENV APP_HOME /home
RUN mkdir -p $APP_HOME
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ADD target/demo-0.0.1-SNAPSHOT.jar. demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.data.mongodb.uri=mymongodb://mongo:27017/mydb","-jar","/demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090