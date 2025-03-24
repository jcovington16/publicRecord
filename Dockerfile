# Use Java 21 JDK image
FROM openjdk:21-jdk

# Set working directory
WORKDIR /app

# Copy the JAR file (update the file name if necessary)
COPY build/libs/political-accountability-app-all.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
