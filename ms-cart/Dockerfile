#FROM openjdk:11-slim
FROM amazoncorretto:11-alpine
VOLUME /tmp
#EXPOSE 8888
ADD ./target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]