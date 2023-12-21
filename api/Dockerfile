# TODO : Copy target folder from build stage and run the jar file

# Use an official OpenJDK runtime as a parent image with Java 21
FROM eclipse-temurin:21 as builder

WORKDIR /app

COPY .mvn .mvn
COPY mvnw mvnw
COPY pom.xml pom.xml

RUN ./mvnw dependency:go-offline

COPY src src

RUN ./mvnw package

FROM eclipse-temurin:21 as app

WORKDIR /app

COPY --from=builder /app/target/httpinfrastructure-api-1.0-jar-with-dependencies.jar /app/

ENTRYPOINT ["java", "-jar", "httpinfrastructure-api-1.0-jar-with-dependencies.jar"]