# Microservices Order Management System

A scalable Microservices-based Order Management System built using Spring Boot and Spring Cloud.  
The project demonstrates service discovery, centralized routing, JWT-based authentication, inter-service communication, and Docker containerization.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Cloud
- Eureka Server (Service Discovery)
- API Gateway
- JWT Authentication
- MySQL
- Docker
- Maven

---

##  Architecture Overview

This project follows Microservices Architecture with the following components:

- **Eureka Server** – Service Discovery
- **API Gateway** – Centralized Routing
- **Auth Service** – JWT Token Generation & Validation
- **User Service** – User Registration & Management
- **Product Service** – Product Management
- **Order Service** – Order Processing
- **Payment Service** – Payment Handling

---

##  Request Flow

1. Client sends request to API Gateway
2. API Gateway routes request to appropriate microservice
3. Services register themselves with Eureka Server
4. JWT token is validated for secure endpoints
5. Order Service communicates with Product & Payment services

---

##  Project Structure
microservices-project
│
├── eureka-server
├── api-gateway
├── auth-service
├── user-service
├── product-service
├── order-service
└── payment-service


---

##  Authentication Flow

- User registers via User Service
- Login via Auth Service
- JWT token generated
- Token required for secured APIs

---

##  Docker Support

Each service includes Docker configuration for containerized deployment.

---

##  How To Run (Local)

1. Start MySQL
2. Run Eureka Server
3. Run API Gateway
4. Run remaining microservices
5. Test APIs using Postman

---

##  Features

✔ User Registration & Login  
✔ JWT-Based Authentication  
✔ Product Management  
✔ Order Creation  
✔ Payment Processing  
✔ Service Discovery using Eureka  
✔ Centralized API Gateway  

---

##  Author

Boobathi Kumar N  
Backend Developer | Java | Spring Boot | Microservices
