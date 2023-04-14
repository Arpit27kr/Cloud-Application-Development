# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Set environment variables
ENV PORT 8080
ENV SPRING_PROFILES_ACTIVE dev

# Expose port 8080 for the container
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "cad.jar"]
