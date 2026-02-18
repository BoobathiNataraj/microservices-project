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
## API Endpoints (Via API Gateway)
http://localhost:8085

**1.Register (Auth User)**  
POST /auth/register  
Body
{  
  "username": "boobathi",  
  "password": "12345678"  
}    
**Postman Screenshot**

 ![Alt Text](screenshots/auth_register.png)
 
**2.Login (Generate JWT Token)**  
POST /auth/login  

Body

{  
  "username": "boobathi",  
  "password": "12345678"  
}    

 Response

{  
  "token": "eyJhbGciOiJIUzI1NiJ9..."  
}  

 Save this token — required for all secured APIs.

 **Postman Screenshot**

 ![Alt Text](screenshots/auth_login.png)  
 
 Authorization Header (IMPORTANT)

For all secured APIs, add this header:

**Authorization: Bearer <JWT_TOKEN>**  
**Content-Type: application/json**

![Alt Text](screenshots/auth_login_token.png)

**3.User Service APIs (Secured)**

Create User  
POST /users  

Body

{  
  "name": "vasanth",  
  "email": "vasanth@gmail.com"  
}    

**Postman Screenshot**

![Alt Text](screenshots/user_add.png)  

Input Validation & Error Handling   

![Alt Text](screenshots/user_exception.png) 

 Get All Users    
GET /users  

 Get User By ID  
GET /users/{id}


**4️. Product Service APIs (Secured)**   

Create Product  
POST /products  
Body

{  
  "name": "pen",  
  "price": 20,  
  "stock": 10  
} 

**Postman Screenshot**

![Alt Text](screenshots/product_add.png) 

Input Validation & Error Handling   

![Alt Text](screenshots/product_exception.png)

Get All Products  
GET /products  

Get Product By ID    
GET /products/{id}  

**5️. Order Service APIs (Secured)**

Place Order  
POST /orders  
Body  
{  
  "userId": 1,  
  "productId": 1,  
  "quantity": 3  
}    

Postman Scrennshot

![Alt Text](screenshots/order_add.png)  

Input Validation & Error Handling 

![Alt Text](screenshots/order_exception.png) 

**6️. Payment Service APIs**

Make Payment (Called by Order Service)  
POST /payments  
⚠️ Normally NOT called directly by client
Triggered automatically when order is placed.


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
##  Database Design (Database Per Service Pattern)

Each microservice maintains its own independent MySQL database to ensure loose coupling and independent scalability.

Database Structure:

- authuser_db → Authentication Service
- user_db → User Service
- product_db → Product Service
- order_db → Order Service
- payment_db → Payment Service

All SQL schema files are available inside the `/database` folder.



---

##  Docker Support

Each service includes Docker configuration for containerized deployment.

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
