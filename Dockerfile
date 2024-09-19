FROM openjdk:17-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} petclinic-auth.jar

ENTRYPOINT ["java","-jar","/petclinic-auth.jar"]
