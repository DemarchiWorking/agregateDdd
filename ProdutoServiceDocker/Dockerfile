FROM openjdk:17-jdk-slim
LABEL authors="Rosemary"
# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR gerado para o contêiner
COPY target/ProdutoServiceDocker-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta 8080
EXPOSE 8080

# Defina o comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]