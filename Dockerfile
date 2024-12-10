# Usar una imagen base de Maven con OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Copiar el código fuente al contenedor
COPY . /app

# Establecer el directorio de trabajo
WORKDIR /app

# Ejecutar Maven para compilar el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Usar una imagen de OpenJDK para el contenedor final
FROM openjdk:17-jdk-slim

# Exponer el puerto de la aplicación
EXPOSE 8080

# Copiar el archivo JAR generado desde el contenedor de construcción
COPY --from=build /app/target/*.jar app.jar

# Ejecutar el JAR con Java
ENTRYPOINT ["java", "-jar", "app.jar"]
