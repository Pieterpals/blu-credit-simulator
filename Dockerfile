# Use OpenJDK as the base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/blu-0.0.1-SNAPSHOT.jar credit-simulator.jar

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "credit-simulator.jar"]
