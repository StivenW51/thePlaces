# Etapa de construcción
FROM gradle:7.3.0-jdk11 AS build
WORKDIR /app

# Copiar los archivos de configuración de Gradle primero
COPY build.gradle settings.gradle gradlew ./
COPY gradle/ ./gradle/

# Copiar el código fuente de la aplicación
COPY src/ ./src/

# Construir la aplicación usando Gradle
RUN ./gradlew bootJar

# Etapa de ejecución
FROM openjdk:11-jre-slim
WORKDIR /app

# Copiar el archivo JAR desde la etapa de construcción
COPY --from=build /app/build/libs/*.jar app.jar

# Exponer el puerto en el que se ejecutará la aplicación
EXPOSE ${PORT}

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
