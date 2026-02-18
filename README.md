# Microservices Order Management System

A scalable Microservices-based Order Management System built using Spring Boot and Spring Cloud.  
The project demonstrates service discovery, centralized routing, JWT-based authentication, inter-service communication, and Docker containerization.

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- Spring Security + JWT
- Spring Data JPA
- MySQL / H2
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
##  Base URL (API Gateway)
http://localhost:8085
Register User
POST /auth/register
Login
POST /auth/login
Create User
POST /users
Create Products
POST /products
Place Order
POST /orders

## Authentication Flow (JWT)
1.User registers or logs in via Auth Service
2.Auth Service returns a JWT Token
3.Token must be passed in Authorization Header
4.Secured services validate the token before processing requests
Authorization: Bearer <JWT_TOKEN>
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
---
1.Start Eureka Server
2.Start API Gateway
3.Start all microservices:
   Auth Service
   User Service
   Product Service
   Order Service
4.Test APIs using Postman
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
