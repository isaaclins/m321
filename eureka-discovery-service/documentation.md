# Eureka Discovery Service - Bug Tracker Integration

## Task
Integration von Netflix Eureka Service Discovery in das bestehende Bug Tracker Microservices-Projekt.

## Architektur

```
┌─────────────────────────────────────────────────────────────────┐
│                    Eureka Server (Port 8761)                     │
│                  Service Discovery & Registry                    │
└─────────────────────────────────────────────────────────────────┘
                                │
       ┌─────────────────────────┼─────────────────────────┐
       │                         │                         │
       ▼                         ▼                         ▼
┌──────────────┐       ┌──────────────┐       ┌──────────────┐
│    User      │       │   Ticket     │       │ Application  │
│ Management   │       │ Management   │       │  Catalog     │
│ (Port 8081)  │       │ (Port 8082)  │       │ (Port 8083)  │
└──────────────┘       └──────────────┘       └──────────────┘
```

## Projektstruktur

```
bugtracker25-before Eureka/
├── pom.xml                    # Parent POM mit allen Modulen
├── EurekaServer/              # NEU: Service Discovery Server
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../EurekaServerApplication.java
│       └── resources/application.properties
├── UserManagement3/           # User Microservice (Eureka Client)
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../Person.java, PersonRepository.java, UserApplication.java
│       └── resources/application.properties
├── TicketManagement3/         # Ticket Microservice (Eureka Client)
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../Ticket.java, TicketRepository.java, TicketApplication.java
│       └── resources/application.properties
└── ApplicationCatalog3/       # Application Microservice (Eureka Client)
    ├── pom.xml
    └── src/main/
        ├── java/.../Application.java, ApplicationRepository.java, ApplicationCatalogApplication.java
        └── resources/application.properties
```

## Durchgeführte Änderungen

### 1. Neuer Eureka Server
- Erstellt: `EurekaServer/` Modul
- `@EnableEurekaServer` Annotation
- Konfiguration auf Port 8761

### 2. Microservice Konfigurationen aktualisiert
Alle Services wurden konfiguriert mit:
- `eureka.client.service-url.defaultZone=http://localhost:8761/eureka/`
- `eureka.client.register-with-eureka=true`
- `eureka.client.fetch-registry=true`
- Feste Ports statt dynamischer Ports (0)

### 3. Parent POM aktualisiert
- EurekaServer Modul hinzugefügt
- Spring Cloud Dependency Management hinzugefügt

## Services Übersicht

| Service              | Port | Eureka Name                  |
|---------------------|------|------------------------------|
| Eureka Server       | 8761 | -                            |
| User Management     | 8081 | user-management-service      |
| Ticket Management   | 8082 | ticket-management-service    |
| Application Catalog | 8083 | application-catalog-service  |

## Schritte zur Ausführung

### Voraussetzungen
- Java 17+
- Maven 3.6+

### 1. Projekt kompilieren
```bash
cd eureka-discovery-service/extracted/bugtracker25-before\ Eureka
mvn clean install -DskipTests
```

### 2. Eureka Server starten (ZUERST!)
```bash
cd EurekaServer
mvn spring-boot:run
```
Eureka Dashboard: http://localhost:8761

### 3. Microservices starten (separate Terminals)
```bash
# User Management
cd UserManagement3
mvn spring-boot:run

# Ticket Management
cd TicketManagement3
mvn spring-boot:run

# Application Catalog
cd ApplicationCatalog3
mvn spring-boot:run
```

## API Endpoints

### User Management (Port 8081)
- GET /persons - Alle Benutzer
- POST /persons - Neuer Benutzer

### Ticket Management (Port 8082)
- GET /tickets - Alle Tickets
- POST /tickets - Neues Ticket

### Application Catalog (Port 8083)
- GET /applications - Alle Applikationen
- POST /applications - Neue Applikation

## Eureka Dashboard

Nach dem Start aller Services zeigt das Eureka Dashboard (http://localhost:8761) alle registrierten Services:

- USER-MANAGEMENT-SERVICE
- TICKET-MANAGEMENT-SERVICE  
- APPLICATION-CATALOG-SERVICE

## Vorteile von Eureka Service Discovery

1. **Automatische Registrierung**: Services registrieren sich automatisch
2. **Health Checks**: Eureka überwacht den Status der Services
3. **Load Balancing Ready**: Grundlage für Client-seitiges Load Balancing
4. **Dynamische Skalierung**: Neue Instanzen werden automatisch erkannt
5. **Fehlertoleranz**: Ausgefallene Services werden automatisch entfernt

## Technologien

- Spring Boot 3.3.3
- Spring Cloud 2023.0.3
- Netflix Eureka Server/Client
- H2 Database
- Java 17
