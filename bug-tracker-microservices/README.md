# Bug Tracker Microservices

Eine Microservice-Architektur für das Bug Tracker System, basierend auf Spring Boot und Spring Cloud Netflix Eureka.

## Schnellstart

### Voraussetzungen

- Java 17+
- Maven 3.6+

### Services starten

1. **Projekt kompilieren:**

   ```bash
   mvn clean install
   ```

2. **Eureka Server starten (zuerst!):**

   ```bash
   cd eureka-server && mvn spring-boot:run
   ```

3. **Microservices starten (in separaten Terminals):**
   ```bash
   cd person-service && mvn spring-boot:run
   cd application-service && mvn spring-boot:run
   cd ticket-service && mvn spring-boot:run
   ```

## Service-Übersicht

| Service             | Port | Beschreibung                 |
| ------------------- | ---- | ---------------------------- |
| Eureka Server       | 8761 | Service Discovery & Registry |
| Person Service      | 8081 | Personen-Verwaltung          |
| Application Service | 8082 | Anwendungs-Verwaltung        |
| Ticket Service      | 8083 | Ticket-Verwaltung            |

## URLs

- **Eureka Dashboard:** http://localhost:8761
- **Person API:** http://localhost:8081/persons
- **Application API:** http://localhost:8082/applications
- **Ticket API:** http://localhost:8083/tickets

## Dokumentation

Siehe [documentation.md](documentation.md) für detaillierte Informationen.
