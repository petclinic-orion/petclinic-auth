# Stage 1: Build the application using Maven
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file and download dependencies
COPY pom.xml .

# Copy the rest of the application code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application using a smaller base image
FROM openjdk:17-jdk-slim

# Expose the application's port
EXPOSE 8080

# Copy the built jar file from the builder stage
COPY --from=builder /app/target/*.jar /app/petclinic-auth.jar

# Set the entry point to run the jar file
ENTRYPOINT ["java","-jar","/app/petclinic-auth.jar"]
