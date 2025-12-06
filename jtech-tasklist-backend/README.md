# jtech-tasklist

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring_boot-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

**jtech-tasklist Backend** is a robust RESTful API built with **Spring Boot**. It serves as the core engine for the Task Management ecosystem, handling business logic, data persistence, and validation rules. It is designed to be consumed by modern frontend frameworks (like Vue.js) via HTTP requests.

---

## 🛠️ Technology Stack

* **Core Framework:** Spring Boot 3
* **Language:** Java 21
* **Database Interaction:** Spring Data JPA (Hibernate)
* **Database:** PostgreSQL
* **Build Tool:** Gradle
* **Architecture:** Hexagonal (Use cases, adapters, application)

---

## ✨ Key Features

* **RESTful Standards:** Clean, resource-oriented URL structure using HTTP verbs.
* **Data Validation:**
    * Uses `Jakarta Validation` (Hibernate Validator).
    * Enforces constraints on `title` (not empty) and `status`.
* **Global Error Handling:**
    * Centralized exception handling to return consistent JSON error responses.
    * Friendly error messages for validation failures.
* **Status Management:** Supports strict enum-based statuses (e.g., `PENDING`, `COMPLETED`).

---

## 🔌 API Reference

The API is exposed under the `/api/v1` prefix.

### Task Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/tasklists` | **List:** Retrieves all tasks from the database. |
| `POST` | `/api/v1/tasklists` | **Create:** Adds a new task. Validates payload. |
| `PUT` | `/api/v1/tasklists/{id}` | **Update:** Modifies an existing task by ID. |
| `DELETE` | `/api/v1/tasklists/{id}` | **Remove:** Deletes a task permanently. |

---

## 📦 Data Models

### Task Object (JSON)
When sending data to the API (POST/PUT), use the following structure:

```json
{
  "title": "Fix login bug",
  "description": "Investigate 403 error on auth endpoint",
  "status": "PENDING"
}

## How to use

### Create a task

```http
POST /api/v1/tasklists
Content-Type: application/json

{
  "title": "Implement Google OAuth",
  "description": "Allow users to sign in using their Google accounts",
  "status": "PENDING"
}

### 🔹 Get all tasks
```http
GET /api/v1/tasklists
```

**Response**
```json
[
  {
    "id": "1",
    "title": "Implement Google OAuth",
    "description": "Allow users to sign in using their Google accounts",
    "status": "PENDING"
  },
  {
    "id": "2",
    "title": "Refactor API endpoints",
    "description": "Optimize database queries for faster response times",
    "status": "IN_PROGRESS"
  }
]
```

---

### 🔹 Get a task by ID
```http
GET /api/v1/tasklists/{id}
```

**Example**
```http
GET /api/v1/tasklists/1
```

**Response**
```json
{
  "id": "1",
  "title": "Implement Google OAuth",
  "description": "Allow users to sign in using their Google accounts",
  "status": "PENDING"
}
```

---

### 🔹 Update a task
```http
PUT /api/v1/tasklists/{id}
Content-Type: application/json
```

**Request Body**
```json
{
  "title": "Finalize Google OAuth",
  "description": "Handle token refresh and error states",
  "status": "IN_PROGRESS"
}
```

---

### 🔹 Delete a task
```http
DELETE /api/v1/tasklists/{id}
```

**Example**
```http
DELETE /api/v1/tasklists/1
```

**Response**
```http
204 No Content
```

---

### 🔹 Validation error example
```json
{
  "status": 400,
  "message": "Validation failed",
  "path": "/api/v1/tasklists",
  "timestamp": "2025-09-04T23:31:00",
  "debugMessage": "Validation failed",
  "subErrors": [
    {
      "object": "TasklistRequest",
      "field": "title",
      "rejectedValue": "",
      "message": "Title is required."
    }
  ]
}
```

---

## 🚀 How to run

### Backend
```bash
git clone https://github.com/lukadev08/fullstack1.git
cd jtech-tasklist-backend
./mvnw spring-boot:run
```

Link to the api calls:

```
http://localhost:8080/api/v1/tasklists
```

## 💡 Coming Improvements
➡️ Provide a fully interactive API documentation interface (e.g., Swagger/OpenAPI).

➡️ Optimize large datasets by allowing clients to filter and paginate returned results.

➡️ Secure the API endpoints by implementing JSON Web Token (JWT) based authentication and role management.

➡️ Implement internationalization (i18n) logic for localized error reporting.

➡️ Implement high coverage of automated and unit tests.

➡️ Create a login system so that each user has a different task list.
