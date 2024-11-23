# Step 1: Build the application
FROM maven:3.8.5-openjdk-17 AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application (creates a jar file in the /target directory)
RUN mvn clean package -DskipTests

# Step 2: Run the application
FROM openjdk:24-ea-17-jdk-slim-bullseye

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# build image and run container
# docker build -t api_langgomsport .
# docker network create langgomsport_network
# docker rm -f api_langgomsport
# docker run --env-file .env --name api_langgomsport -p 8080:8080 --network langgomsport_network api_langgomsport

# push image into docker hub
# docker login
# docker tag api_langgomsport khanhlv2004/api_langgomsport:2.0
# docker tag api_langgomsport khanhlv2004/api_langgomsport:latest
# docker push khanhlv2004/api_langgomsport:2.0
# docker push khanhlv2004/api_langgomsport:latest

#
# export DATABASE_NAME=langgomsport
# export DATABASE_HOST=localhost
# export DATABASE_PORT=3308
# export DATABASE_USERNAME=admin
# export DATABASE_PASSWORD=123456