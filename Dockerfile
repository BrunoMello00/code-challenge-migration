# Usando a imagem base do OpenJDK 17 com Alpine Linux para a fase de build
FROM openjdk:17-jdk-alpine AS build

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Copiando o diretório src para o diretório de trabalho
COPY src ./src

# Instalando o Maven e construindo o projeto, ignorando os testes
RUN apk add --no-cache maven && mvn clean package -DskipTests

# Usando a imagem base do OpenJDK 17 com Alpine Linux para a fase final
FROM openjdk:17-jdk-alpine

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o JAR gerado na fase de build para o diretório de trabalho
COPY --from=build /app/target/dummyjson-client-1.0-SNAPSHOT.jar dummyjson-client.jar

# Definindo o ponto de entrada para executar o JAR
ENTRYPOINT ["java","-jar","/app/dummyjson-client.jar"]