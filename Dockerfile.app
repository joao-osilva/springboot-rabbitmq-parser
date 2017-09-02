FROM openjdk:8-jre-alpine

MAINTAINER Joao Silva <vitor191291@gmail.com>

VOLUME /tmp
EXPOSE 8080
ADD target/demo-json-parser-1.0-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
