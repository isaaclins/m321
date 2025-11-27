# Bug Tracker - Monolith to Microservices

## Task

Aufteilung des Bug Tracker Monoliths in eine Microservice-Architektur mit Spring Cloud Netflix Eureka für Service Discovery.

## Architektur-Übersicht

### Ursprünglicher Monolith

Der Monolith enthielt drei Domain-Entitäten in einer einzigen Anwendung:

- **Application**: Repräsentiert Software-Anwendungen
- **Person**: Repräsentiert Benutzer/Mitarbeiter
- **Ticket**: Repräsentiert Bug-Reports/Tickets

### Neue Microservice-Architektur

```
┌─────────────────────────────────────────────────────────────────┐
│                      Eureka Server (Port 8761)                   │
│                    Service Discovery & Registry                  │
└─────────────────────────────────────────────────────────────────┘
                                 │
       ┌─────────────────────────┼─────────────────────────┐
       │                         │                         │
       ▼                         ▼                         ▼
┌──────────────┐       ┌──────────────┐       ┌──────────────┐
│Person Service│       │Application   │       │Ticket Service│
│  (Port 8081) │       │Service (8082)│       │  (Port 8083) │
│              │       │              │       │              │
│ - Person     │       │ - Application│       │ - Ticket     │
│ - Repository │       │ - Repository │       │ - Repository │
└──────────────┘       └──────────────┘       └──────────────┘
```

## Projektstruktur

```
bug-tracker-microservices/
├── pom.xml                          # Parent POM
├── eureka-server/                   # Service Discovery Server
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../EurekaServerApplication.java
│       └── resources/application.properties
├── person-service/                  # Person Microservice
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../person/
│       │   ├── Person.java
│       │   ├── PersonRepository.java
│       │   └── PersonServiceApplication.java
│       └── resources/application.properties
├── application-service/             # Application Microservice
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../application/
│       │   ├── Application.java
│       │   ├── ApplicationRepository.java
│       │   └── ApplicationServiceApplication.java
│       └── resources/application.properties
└── ticket-service/                  # Ticket Microservice
    ├── pom.xml
    └── src/main/
        ├── java/.../ticket/
        │   ├── Ticket.java
        │   ├── TicketRepository.java
        │   └── TicketServiceApplication.java
        └── resources/application.properties
```

## Technologien

- **Spring Boot 3.2.0**: Framework für die Microservices
- **Spring Cloud 2023.0.0**: Cloud-native Funktionalitäten
- **Spring Cloud Netflix Eureka**: Service Discovery
- **Spring Data JPA**: Datenbankzugriff
- **Spring Data REST**: RESTful API Generierung
- **H2 Database**: In-Memory Datenbank (für Entwicklung)
- **Lombok**: Boilerplate-Code Reduktion
- **Java 17**: Programmiersprache

## Schritte zur Ausführung

### Voraussetzungen

- Java 17 oder höher
- Maven 3.6+

### 1. Projekt kompilieren

```bash
cd bug-tracker-microservices
mvn clean install
```

### 2. Eureka Server starten (zuerst!)

```bash
cd eureka-server
mvn spring-boot:run
```

Eureka Dashboard verfügbar unter: http://localhost:8761

### 3. Microservices starten (in separaten Terminals)

**Person Service:**

```bash
cd person-service
mvn spring-boot:run
```

**Application Service:**

```bash
cd application-service
mvn spring-boot:run
```

**Ticket Service:**

```bash
cd ticket-service
mvn spring-boot:run
```

## API Endpoints

### Person Service (Port 8081)

| Method | Endpoint      | Beschreibung          |
| ------ | ------------- | --------------------- |
| GET    | /persons      | Alle Personen abrufen |
| GET    | /persons/{id} | Person nach ID        |
| POST   | /persons      | Neue Person erstellen |
| PUT    | /persons/{id} | Person aktualisieren  |
| DELETE | /persons/{id} | Person löschen        |

### Application Service (Port 8082)

| Method | Endpoint           | Beschreibung               |
| ------ | ------------------ | -------------------------- |
| GET    | /applications      | Alle Applications abrufen  |
| GET    | /applications/{id} | Application nach ID        |
| POST   | /applications      | Neue Application erstellen |
| PUT    | /applications/{id} | Application aktualisieren  |
| DELETE | /applications/{id} | Application löschen        |

### Ticket Service (Port 8083)

| Method | Endpoint      | Beschreibung           |
| ------ | ------------- | ---------------------- |
| GET    | /tickets      | Alle Tickets abrufen   |
| GET    | /tickets/{id} | Ticket nach ID         |
| POST   | /tickets      | Neues Ticket erstellen |
| PUT    | /tickets/{id} | Ticket aktualisieren   |
| DELETE | /tickets/{id} | Ticket löschen         |

## Beispiel-Requests

### Person erstellen

```bash
curl -X POST http://localhost:8081/persons \
  -H "Content-Type: application/json" \
  -d '{"firstName": "Hans", "lastName": "Meier"}'
```

### Alle Tickets abrufen

```bash
curl http://localhost:8083/tickets
```

### Application erstellen

```bash
curl -X POST http://localhost:8082/applications \
  -H "Content-Type: application/json" \
  -d '{"name": "New App", "description": "A new application", "ownerId": 1}'
```

## H2 Console Zugriff

Jeder Service hat eine H2-Konsole für Datenbankzugriff:

- Person Service: http://localhost:8081/h2-console
- Application Service: http://localhost:8082/h2-console
- Ticket Service: http://localhost:8083/h2-console

**JDBC URL:** `jdbc:h2:mem:persondb` (bzw. appdb, ticketdb)
**Username:** `sa`
**Password:** (leer)

## Vorteile der Microservice-Architektur

1. **Unabhängige Skalierung**: Jeder Service kann separat skaliert werden
2. **Technologie-Flexibilität**: Services können unterschiedliche Technologien nutzen
3. **Fehler-Isolation**: Ein Fehler in einem Service beeinträchtigt nicht die anderen
4. **Einfache Wartung**: Kleinere Codebasen sind leichter zu verstehen
5. **Unabhängiges Deployment**: Services können separat deployed werden

## Cleanup

Keine temporären Dateien wurden erstellt. Alle Artefakte befinden sich im `bug-tracker-microservices` Ordner.

## Weiterführende Schritte

1. **API Gateway hinzufügen**: Spring Cloud Gateway für zentralen Einstiegspunkt
2. **Config Server**: Zentralisierte Konfigurationsverwaltung
3. **Circuit Breaker**: Resilience4j für Fehlertoleranz
4. **Distributed Tracing**: Sleuth/Zipkin für Monitoring
5. **Produktionsdatenbank**: PostgreSQL oder MySQL statt H2
