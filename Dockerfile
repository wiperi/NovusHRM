FROM openjdk:20-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/NovusCRM-0.0.1-SNAPSHOT.jar /app/NovusCRM.jar

# Expose the port the application runs on
EXPOSE 8080

# Command to run the jar file
ENTRYPOINT ["java", "-jar", "NovusCRM.jar"]

