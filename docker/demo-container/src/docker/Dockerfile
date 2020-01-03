FROM openjdk:12-alpine

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY jar/demo.jar /opt/app/

VOLUME /opt/app

EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]