FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY ./target/mscloudgateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]