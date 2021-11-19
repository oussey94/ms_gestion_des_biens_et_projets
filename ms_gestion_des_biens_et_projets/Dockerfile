FROM openjdk:8-jdk-alpine
RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
USER springdocker:springdocker
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app1.jar
ENTRYPOINT ["java","-jar","/app1.jar"]