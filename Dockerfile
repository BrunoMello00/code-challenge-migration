
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

RUN apt-get update && apt-get install -y wget tar
RUN wget https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz
RUN tar -xzf apache-maven-3.9.6-bin.tar.gz
ENV PATH="/app/apache-maven-3.9.6/bin:${PATH}"

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=build /app/target/dummyjson-client-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]