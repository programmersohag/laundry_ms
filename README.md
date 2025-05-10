# 🧺 Laundry Management System

## 📌 Overview

The **Laundry Management System** is a web-based application built with **Spring Boot** to manage laundry service operations such as order creation, service tracking, customer management, and billing. It supports admin and customer roles with a RESTful API architecture.

## 🚀 Features

- Customer registration and login
- Order placement and tracking
- Service categorization (wash, iron, dry clean, etc.)
- Price calculation and billing
- Admin dashboard for managing orders and customers
- Role-based access control (Admin, Customer)
- RESTful APIs with Swagger documentation

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- MySQL
- Lombok
- Swagger (Springdoc OpenAPI)
- Gradle

## ⚙️ Setup Environment

### 1. Install Prerequisites

- Java 17 or higher
- Gradle 8+ (or use the included `gradlew`)
- MySQL (or compatible relational database)

### 2. Set Up MySQL

- Create a database:
  ```sql
  CREATE DATABASE laundry_db;

### 🔧 Setup Instructions
1. **Clone the Repository**

   ```bash
   git clone https://github.com/programmersohag/laundry_ms.git
   cd laundry_ms

2. **Change your local db connection in properties file**
spring.datasource.url=jdbc:mysql://localhost:3306/laundry_db
spring.datasource.username=laundry_user
spring.datasource.password=password

3. **Build and Run JAR**
   ```bash
    ./gradlew clean build
    java -jar build/libs/laundry-management-0.0.1-SNAPSHOT.jar

## Licence
This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
## 👨‍💻 Author
- Md. Sohaq Ali (ID: 23314)
- Mohammad Ziaul Hoq (ID: 23319)

## Documentation
- [LMS-DOCUMENTATION](docs%2FLMS-DOCUMENTATION.pdf)
- [LMS-PRESENTATION](docs%2FPresentation.pptx)