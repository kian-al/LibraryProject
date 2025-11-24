# Library Shop Project

This project is a **full-stack book store application** built with:

* **Spring Boot** for the backend
* **React** for the frontend
* **Playwright** for end-to-end testing
* **Docker** for containerization and deployment

## Project Structure

```
LibraryProject/
│
├── backend/        # Spring Boot API
├── frontend/       # React application
└── tests/          # Playwright E2E tests
```

## Backend (Spring Boot)

The backend provides APIs for managing books, users, and orders. It follows a clean layered architecture:

* Controller
* Service
* Repository
* DTOs
* Exception Handling

## Frontend (React)

The frontend is a simple and clean UI for:

* Listing books
* Viewing details
* Adding books to cart
* Managing user orders

It communicates with the backend using REST API.

## Testing (Playwright)

Playwright will run end-to-end tests to ensure:

* UI loads correctly
* API responses are handled properly
* User flows (add to cart, checkout, etc.) work as expected

A folder called `tests/` contains:

* Test configuration
* UI test cases
* API integration checks

## Docker Setup

The project will be containerized using Docker.
Two images will be built:

* **backend image** (Spring Boot JAR)
* **frontend image** (React build served by Nginx or Node)

A `docker-compose.yml` will run everything together:

* Backend on port 8080
* Frontend on port 3000 or served as static build

## Goal of the Project

The goal is to deliver a **complete senior-level full‑stack project** that includes:

* Clean codebase
* Full CI/CD structure
* Docker support
* E2E tests with Playwright
* Scalable folder structures

This project will represent a real online book shop with production‑ready structure, suitable for portfolio and real‑world usage.
