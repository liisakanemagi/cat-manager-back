# BMX Estonia - Vali IT! Final Project (Backend)

**Frontend Repository:** https://github.com/liisakanemagi/bmxfront

This repository contains the backend **RESTful API** for the BMX Estonia community platform. It is built using **Java** and **Spring Boot**, serving data to the Vue.js frontend application.

**Project Type:** Educational capstone project for the Vali IT! retraining program.

## Project Status: Work in Progress

> **Note:** This project is currently under development. While the core API endpoints are functional, some features are simplified or pending implementation.

## Tech Stack

**Core Frameworks:**
* **Java**
* **Spring Boot**
* **Spring Web (REST)**
* **Spring Data JPA**

**Database:**
* **PostgreSQL**

## Setup & Installation

To run this backend locally, please follow these steps:

### 1. Database Setup
Ensure you have **PostgreSQL** installed and running.
1. Create a new database named `bmx`.
2. Check `src/main/resources/application.properties` and update the `username` and `password` to match your local PostgreSQL credentials if necessary.

### 2. Run the Application
1. Open the project in your IDE (IntelliJ IDEA is recommended).
2. Allow Maven/Gradle to import dependencies.
3. Run the main class `BmxApplication.java`.
4. The API will start at `http://localhost:8081`.

## Known Issues (Backend)
* **Missing Seed Images:** The initial database script does not contain binary image data for pre-seeded locations (assets are local-only). Note: Image upload for new spots works correctly.
* **Security:** User passwords are currently stored without encryption for educational simplicity.
