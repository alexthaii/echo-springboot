## Build Stage
FROM openjdk:8-jdk-alpine as build
RUN apk add --no-cache maven

COPY pom.xml ./pom.xml
RUN mvn dependency:go-offline

COPY src/ ./src
RUN mvn package

## Runtime Stage
FROM openjdk:8u171-jre-alpine
COPY --from=build target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]