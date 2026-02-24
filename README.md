
# Cat Manager Backend

This project is a backend application for managing cat information, designed for animal shelters, foster homes and cat
parents.

## Core Technologies

*   **Core Frameworks:**
    *   Java 21
    *   Spring Boot 3.3
    *   Spring Web (REST)
    *   Spring Data JPA
    *   Spring Security

*   **Database:**
    *   PostgreSQL

*   **API Documentation:**
    *   Swagger/OpenAPI

*   **Development Tools:**
    *   Lombok
    *   JWT (JSON Web Token)

## Project Status

### Currently Implemented
*   **User Authentication:** Secure user registration and login functionality.
*   **Add a Cat:** Users can add new cats to the system.

### In Development
*   **View Cat Data:** Viewing personal cat data and lists.
*   **Add and Keep Track of Procedures:** Adding procedures with dates to keep track of a cat's health and activities.

## Setup & Installation

To run this backend locally, please follow these steps:

### 1. Database Setup
Ensure you have **PostgreSQL** installed and running.
1.  Create a new database named `catmanager`.
2.  Check `src/main/resources/application.properties` and update the `username` and `password` to match your local PostgreSQL credentials if necessary.

### 2. Run the Application
1.  Open the project in your IDE (IntelliJ IDEA is recommended).
2.  Allow Maven/Gradle to import dependencies.
3.  Run the main class `CatManagerApplication.java`.
4.  The API will start at `http://localhost:8080`.

### 3. API Documentation
Once the application is running, you can access the Swagger UI for API documentation and testing at:
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
