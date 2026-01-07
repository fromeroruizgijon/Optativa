
FROM eclipse-temurin:17-jdk-jammy

# 2. Copiamos tu JAR generado dentro del contenedor con el nombre 'app.jar'
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# 3. Informamos que la app usa el puerto 8080
EXPOSE 8080

# 4. Comando para arrancar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]