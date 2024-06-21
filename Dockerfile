# Use an official OpenJDK runtime as a parent image
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file to the container
COPY target/*.jar app.jar

# Copy the .env file to the container
COPY .env .env

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
