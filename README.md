# Spring Boot Redis Caching Example

This project demonstrates how to use Redis for caching with Spring Data Redis.

## Prerequisites
- Java 8 or higher
- Maven
- Redis server

## Getting Started
1. **Clone the Repository**
    ```shell
    git clone https://github.com/your-repo/spring-boot-redis-caching-example.git
    cd spring-boot-redis-caching-example
    ```

2. **Build and Run the Application**
    ```shell
    mvn clean install
    mvn spring-boot:run
    ```
   The application will start on [http://localhost:8080](http://localhost:8080).

3. **Run with Docker**
    ```shell
    docker build -t spring-boot-redis .
    docker run -p 8080:8080 spring-boot-redis
    ```
   The application will be accessible at [http://localhost:8080](http://localhost:8080).


## Endpoints

### Compute (Create/Cache)

This endpoint performs a computationally expensive operation (squares the input) and caches the result.

```shell
curl -X GET "http://localhost:8080/compute/5"
```

### Update Cache

This endpoint performs a different computationally expensive operation (cubes the input) and updates the cache.

```shell
curl -X PUT "http://localhost:8080/update/5"
```

### Clear Cache

This endpoint clears all entries in the cache.

```shell
curl -X DELETE "http://localhost:8080/clear-cache"
```
