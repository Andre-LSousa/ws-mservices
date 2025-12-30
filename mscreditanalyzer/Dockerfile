FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY ./target/mscreditanalyzer-0.0.1-SNAPSHOT.jar mscredit-analyzer.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "mscredit-analyzer.jar"]