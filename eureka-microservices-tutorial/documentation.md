# Documentation

## Task

The goal is to build a simple microservice architecture using Spring Boot and Spring Cloud with Eureka for service discovery, based on the provided tutorial document. This involves creating a Eureka discovery server and two client microservices that register with the server.

## Approach

I will follow the steps outlined in the document:

1.  Set up a Spring Boot application to act as the Eureka Server.
2.  Create two separate Spring Boot applications for the microservices (`service-01` and `service-02`).
3.  Configure each service to register with the Eureka server.
4.  Implement a simple REST API endpoint in each microservice.
5.  Verify the setup by checking the Eureka dashboard and calling the APIs.

This approach ensures that we follow the tutorial's instructions closely to replicate the intended architecture.

## Steps to Reproduce

1.  **Clone the repository.**
2.  **Navigate to the `eureka-microservices-tutorial` directory.**
3.  **Start the Eureka Server:**
    ```bash
    cd eureka-server-app
    mvn spring-boot:run
    ```
4.  **In a new terminal, start Service 01:**
    ```bash
    cd service-01
    mvn spring-boot:run
    ```
5.  **In another new terminal, start Service 02:**
    ```bash
    cd service-02
    mvn spring-boot:run
    ```
6.  **Verify service registration** by opening a web browser and navigating to the Eureka Dashboard at `http://localhost:8761/`. You should see `SERVICE-01` and `SERVICE-02` listed under "Instances currently registered with Eureka."
7.  **Test the service endpoints:**
    -   Service 01: `curl http://localhost:8081/api` (should return `{"name":"Hello World from Service 01"}`)
    -   Service 02: `curl http://localhost:8082/api` (should return `Hello World from Service 02`)

## Results

All services started successfully. The Eureka dashboard shows both `service-01` and `service-02` as registered. The API endpoints for both services are responding as expected. The microservice architecture with service discovery is working correctly.

## Cleanup

All temporary log files (`eureka.log`, `service01.log`, `service02.log`) will be removed. The running Java processes for the three services will be terminated.
