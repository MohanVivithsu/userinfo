# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set app directory
WORKDIR /app

# Copy the built JAR into the image
COPY target/userinfo-0.0.1-SNAPSHOT.jar app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080  