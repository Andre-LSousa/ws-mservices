FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY ./target/mscard-0.0.1-SNAPSHOT.jar mscard.jar
ENTRYPOINT ["java", "-jar", "mscard.jar"]