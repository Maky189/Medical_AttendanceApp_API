# Medical Attendance API

## Overview
This project is a RESTful API for managing medical attendances, built with **Spring Boot**. It allows you to register and authenticate patients and doctors, schedule and manage medical consultations, and mark consultations as completed. The API is designed for simplicity and clarity, using traditional Java approaches and Spring Data JPA for database access.

## What is Spring Boot?
**Spring Boot** is a framework for building stand-alone, production-grade Spring-based applications. It simplifies the setup and development of new Spring applications by providing:
- Embedded servers (like Tomcat)
- Auto-configuration
- Production-ready features (metrics, health checks, etc.)
- Minimal configuration

**Spring Data JPA** is used for easy database access, allowing you to interact with the database using Java objects and interfaces, without writing SQL for common operations.

## Project Structure
- `controller/` — REST controllers for handling HTTP requests
- `model/` — Entity classes and DAOs for business logic and database access
- `resources/database/Medical.sql` — SQL script to create and populate the database

## Database Schema
The database consists of three main tables:
- **pacientes** (patients)
- **medicos** (doctors)
- **consultas** (consultations)

### Example Table: pacientes
```sql
CREATE TABLE pacientes (
    id INT AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    contacto BIGINT,
    pass VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
```

## Main Entities

### Pacientes (Patients)
Represents a patient in the system.
```java
@Entity
public class Pacientes {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String nome;
    private int idade;
    private long contacto;
    private String pass;
    // getters and setters
}
```
- **id**: Unique identifier
- **nome**: Name
- **idade**: Age
- **contacto**: Contact number
- **pass**: Password (for login)

### Medicos (Doctors)
Represents a doctor in the system.
```java
@Entity
public class Medicos {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String especialidade;
    private String horario;
    private String pass;
    // getters and setters
}
```
- **id**: Unique identifier
- **nome**: Name
- **especialidade**: Specialty
- **horario**: Work schedule
- **pass**: Password (for login)

### Consultas (Consultations)
Represents a medical consultation.
```java
@Entity
public class Consultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pacienteId;
    private int medicoId;
    private Date data;
    private Time hora;
    private String descricao;
    private String status;
    // getters and setters
}
```
- **id**: Unique identifier
- **pacienteId**: ID of the patient
- **medicoId**: ID of the doctor
- **data**: Date of the consultation
- **hora**: Time of the consultation
- **descricao**: Description
- **status**: Status (e.g., "Realizada")

## Main Functionalities

### Patients
- **Register**: `POST /pacientes/save` — Register a new patient
- **Login**: `POST /pacientes/login` — Authenticate a patient
- **List All**: `GET /pacientes/getAll` — List all patients

### Doctors
- **Register**: `POST /medicos/save` — Register a new doctor
- **Login**: `POST /medicos/login` — Authenticate a doctor
- **List All**: `GET /medicos/getAll` — List all doctors

### Consultations
- **Register**: `POST /consultas/register` — Register a new consultation
- **List All**: `GET /consultas/getAll` — List all consultations
- **List by Patient**: `POST /consultas/byPaciente` (body: `{ "pacienteId": 1 }`)
- **List by Doctor**: `POST /consultas/byMedico` (body: `{ "medicoId": 1 }`)
- **Mark as Done**: `POST /consultas/markDone` (body: `{ "id": 1 }`)

## Example: Marking a Consultation as Done
```java
@PostMapping("/consultas/markDone")
public Consultas markConsultaAsDone(@RequestBody Map<String, Integer> body) {
    int id = body.get("id");
    Consultas consulta = consultasDao.getConsultaById(id);
    if (consulta != null) {
        consulta.setStatus("Realizada");
        return consultasDao.save(consulta);
    }
    return null;
}
```

## Technologies Used
- **Spring Boot**: Main framework for the application
- **Spring Data JPA**: ORM for database access
- **H2/MySQL**: Database (use the provided SQL script for setup)
- **Maven**: Build tool

## How to Run

Just 
1. Clone the repository and import the project into your IntelliJ IDEA or any Java IDE:
   ```sh
   git clone
4. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
5. Use a tool like Postman or curl to interact with the API endpoints


This project is for educational purposes on The University of Mindelo, Cabo Verde.

