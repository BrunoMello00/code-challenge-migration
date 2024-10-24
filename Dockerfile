# Etapa 1: Construção do projeto com testes e gravação de logs
FROM maven:3.8.5-openjdk-17-slim AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto (pom.xml e código-fonte)
COPY pom.xml ./
COPY src ./src

# Executa a construção do projeto com os testes e grava os logs
RUN mvn clean package > test-logs.txt 2>&1

# Etapa 2: Execução do aplicativo
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=builder /app/target/dummyjson-client-1.1.0-SNAPSHOT.jar app.jar

# Copia também os logs de build/testes
COPY --from=builder /app/test-logs.txt /app/test-logs.txt

# Expondo a porta que a aplicação irá usar
EXPOSE 8080

# Comando para iniciar o aplicativo
ENTRYPOINT ["java", "-jar", "app.jar"]
