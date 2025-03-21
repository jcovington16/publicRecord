# Dockerfile
FROM openjdk:21-jdk

WORKDIR /app

COPY build/libs/political-accountability-app-all.jar app.jar

CMD ["java", "-jar", "app.jar"]
