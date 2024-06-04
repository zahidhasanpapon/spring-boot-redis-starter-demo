FROM amazoncorretto:21

WORKDIR /app

COPY target/spring-data-starer-redis-0.0.1-SNAPSHOT.jar /app/spring-data-starer-redis-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "spring-data-starer-redis-0.0.1-SNAPSHOT.jar"]