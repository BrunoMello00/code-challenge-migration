FROM openjdk:17-jdk-slim AS build
COPY target/dummyjson-api.jar /app/dummyjson-api.jar
ENV SPRING_PROFILES_ACTIVE=prod
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/dummyjson-api.jar"]
