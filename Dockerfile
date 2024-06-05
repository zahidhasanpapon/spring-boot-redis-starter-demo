# First stage: build the application
FROM maven:3.9.5-amazoncorretto-21 AS build

WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY src ./src

# Package the application
RUN mvn package spring-boot:repackage

# Second stage: create the final image
FROM amazoncorretto:21

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/spring-data-starer-redis-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "spring-data-starer-redis-0.0.1-SNAPSHOT.jar"]
