# --- ETAPA 1: CONSTRUIR (Docker descarga su propio Maven) ---
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
# Copiamos todos tus archivos al contenedor
COPY . .
# Docker ejecuta el comando 'package' saltándose los tests
RUN mvn clean package -DskipTests

# --- ETAPA 2: EJECUTAR (La imagen final ligera) ---
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
# Cogemos el .jar que se fabricó en la Etapa 1
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]