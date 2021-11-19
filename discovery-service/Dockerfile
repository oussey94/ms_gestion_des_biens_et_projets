FROM openjdk:8-jdk-alpine
RUN addgroup -S springdocker && adduser -S springdocker -G springdocker
USER springdocker:springdocker
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app4.jar
ENTRYPOINT ["java","-jar","/app4.jar"]