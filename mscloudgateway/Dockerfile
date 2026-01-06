FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY ./target/mscloudgateway-0.0.1-SNAPSHOT.jar api-gateway.jar

ARG EUREKA_SERVER=localhost
ARG KEYCLOAK_SERVER=localhost
ARG KEYCLOAK_PORT=8081

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]