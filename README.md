# 📚 Library Management System

A simple **Library Management System** built with **Java Spring Boot**.  
This project allows management of books, users, shopping carts, and factors (invoices).  
It is designed with a layered architecture following clean coding practices.

---

## 🚀 Features

- Manage library users
- Manage books and related data
- Handle shopping carts and invoices (factors)
- DTO-based API responses
- Centralized exception handling
- Database integration via Spring Data JPA

---

## 🧠 Project Structure

LibraryProject/
├── src/
│ ├── main/
│ │ ├── java/ir/library/libraryproject/
│ │ │ ├── controller/ # REST Controllers
│ │ │ ├── dto/ # Data Transfer Objects
│ │ │ ├── exception/ # Custom Exceptions
│ │ │ ├── model/ # Entity Classes
│ │ │ ├── repository/ # Spring Data Repositories
│ │ │ ├── service/ # Business Logic
│ │ │ └── LibraryProjectApplication.java
│ │ └── resources/
│ │ ├── application.properties
│ │ ├── static/
│ │ └── templates/
│ └── test/
│ └── java/ir/library/libraryproject/
│ └── LibraryProjectApplicationTests.java
├── pom.xml
└── README.md

ruby
Copy code

---

## ⚙️ Technologies Used

- **Java 17+**
- **Spring Boot 3**
- **Spring Data JPA**
- **Maven**
- **H2 / MySQL** (depending on configuration)
- **Lombok** (for reducing boilerplate code)
- **JUnit 5** (for testing)

---

## 🧩 API Endpoints (example)

| Method | Endpoint             | Description            |
|:-------|:---------------------|:-----------------------|
| `GET`  | `/api/users`         | Get all users          |
| `GET`  | `/api/users/{id}`    | Get user by ID         |
| `POST` | `/api/users`         | Create new user        |
| `PUT`  | `/api/users/{id}`    | Update existing user   |
| `DELETE` | `/api/users/{id}`  | Delete user            |

---

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/<your-username>/LibraryProject.git
Navigate to the project directory:

bash
Copy code
cd LibraryProject
Build and run the project:

bash
Copy code
./mvnw spring-boot:run
The application will start at:

arduino
Copy code
http://localhost:8080
🧾 Configuration
In src/main/resources/application.properties, configure your database connection:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
🧪 Testing
Run unit tests with:

bash
Copy code
./mvnw test
👨‍💻 Author
Kian Almasi
junior Java Developer 
📧 kianalmasi0@gmail.com
🌐 https://github.com/kian-al/