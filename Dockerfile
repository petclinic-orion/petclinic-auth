FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory in the container
WORKDIR /app

COPY pom.xml .

COPY src ./src

 # Build the application using Maven
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

EXPOSE 8080
COPY --from=builder /app/target/*.jar /app/analytics.jar

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petclinic-auth.jar

ENTRYPOINT ["java","-jar","/petclinic-auth.jar"]