FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY ./target/msclient-0.0.1-SNAPSHOT.jar msclient.jar
ENTRYPOINT ["java", "-jar", "msclient.jar"]