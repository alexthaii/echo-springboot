## Build Stage
FROM maven as build

COPY pom.xml ./pom.xml
RUN mvn dependency:go-offline

COPY src/ ./src
RUN mvn package

## Runtime Stage
FROM eclipse-temurin:11
COPY --from=build target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]