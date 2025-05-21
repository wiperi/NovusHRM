# NovusCRM - Enterprise Employee Management System

## Project Overview

Designed and developed an enterprise-level employee management system (NovusCRM) based on Spring Boot, implementing core features such as employee information management, department management, and report generation. The system adopts a front-end/back-end separation architecture: the back end is built with Java Spring Boot, while the front end features a modern UI design for a clean and intuitive user experience.

## Tech Stack

* **Backend Framework**: Spring Boot 3.4.1, MyBatis
* **Database**: MySQL 8.0
* **Authentication & Authorization**: JWT (JSON Web Token)
* **API Documentation**: SpringDoc OpenAPI (Swagger)
* **Logging**: Logback
* **Containerization**: Docker, Docker Compose
* **Development Tools**: Maven, Git

## Core Features

* **Employee Management**: CRUD operations for employee data, including personal details, work history, and salary management
* **Department Management**: Create, update, delete, and query departments, and associate employees with departments
* **User Authentication**: Secure authentication mechanism based on JWT
* **Operation Logging**: Implemented with AOP to log system operations for auditing and troubleshooting
* **Reporting**: Data analytics and report generation features to support business decision-making
* **File Upload**: Support for uploading and managing employee-related files such as profile pictures

## Technical Highlights

* **Microservice-Oriented Design**: Adopted modern microservice design principles for better scalability and maintainability
* **Containerized Deployment**: Utilized Docker and Docker Compose to streamline deployment and improve portability
* **AOP Aspect-Oriented Programming**: Applied Spring AOP for cross-cutting concerns like logging and performance monitoring
* **Interceptor Mechanism**: Implemented request interceptors and JWT validation to enhance system security
* **Pagination Optimization**: Integrated PageHelper for efficient pagination and improved query performance
* **Global Exception Handling**: Developed a unified exception handling mechanism to enhance system robustness and user experience
