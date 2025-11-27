# Tasks - Bug Tracker Monolith to Microservices

## Übersicht

Aufteilen des Bug Tracker Monoliths in separate Microservices mit Eureka Service Discovery.

## Aufgaben

1. [x] Erstelle Aufgabenstruktur und tasks.md
2. [x] Erstelle PersonManagement Microservice
   - [x] Person Entity erstellen
   - [x] PersonRepository erstellen
   - [x] PersonServiceApplication erstellen
   - [x] application.properties konfigurieren
3. [x] Erstelle ApplicationManagement Microservice
   - [x] Application Entity erstellen
   - [x] ApplicationRepository erstellen
   - [x] ApplicationServiceApplication erstellen
   - [x] application.properties konfigurieren
4. [x] Erstelle TicketManagement Microservice
   - [x] Ticket Entity erstellen
   - [x] TicketRepository erstellen
   - [x] TicketServiceApplication erstellen
   - [x] application.properties konfigurieren
5. [x] Erstelle Eureka Discovery Server
   - [x] EurekaServerApplication erstellen
   - [x] application.properties konfigurieren
6. [x] Dokumentation erstellen

## Progress Log

- [2025-11-27 10:00] Projekt analysiert, Monolith-Struktur verstanden
- [2025-11-27 10:05] Parent POM erstellt mit Spring Cloud Dependency Management
- [2025-11-27 10:10] Eureka Server erstellt (Port 8761)
- [2025-11-27 10:15] Person Service erstellt (Port 8081)
- [2025-11-27 10:20] Application Service erstellt (Port 8082)
- [2025-11-27 10:25] Ticket Service erstellt (Port 8083)
- [2025-11-27 10:30] Dokumentation fertiggestellt

## Ergebnis

Alle Aufgaben wurden erfolgreich abgeschlossen. Der Monolith wurde in 4 separate Services aufgeteilt:

- Eureka Server für Service Discovery
- Person Service
- Application Service
- Ticket Service
