![Jtech Logo](http://www.jtech.com.br/wp-content/uploads/2015/06/logo.png)

# 🚀 jtech-tasklist (Frontend)

![Vue.js](https://img.shields.io/badge/vuejs-%2335495e.svg?style=for-the-badge&logo=vuedotjs&logoColor=%234FC08D)
![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%23563D7C.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![Axios](https://img.shields.io/badge/Axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white)

**jtech-tasklist Frontend** is a modern Vue 3 application designed to serve as the user interface for the jtech-tasklist ecosystem. It provides a clean, responsive experience for managing tasks by consuming the Spring Boot backend API.

---

## 🛠️ Technology Stack

* **Framework:** Vue 3
* **Language:** TypeScript
* **HTTP Client:** Axios
* **Styling:** Bootstrap 5
* **Routing:** Vue Router

---

## ✨ Key Features

* **Task Management:** Create, Read, Update, and Delete (CRUD) tasks effortlessly.
* **Smart Validation:** Client-side validation for required fields (`title`, `status`) and integration with backend API error messages.
* **User Feedback:**
    * Real-time success and error alerts.
    * Native tooltips for action buttons.
    * **Status Formatting:** Automatically converts enum values (e.g., `PENDING`) into human-readable text (e.g., "Pending").
* **Safety Mechanisms:** Custom modal confirmations to prevent accidental task deletions.

---

## 📂 Project Architecture

The application follows a strict modular structure to ensure code quality:

| Module | Description | Key Files |
| :--- | :--- | :--- |
| **Views** | Main page layouts and UI logic. | `View.vue`, `Form.vue` |
| **Router** | Handles navigation between the list and form views. | `router/index.ts` |
| **Types** | TypeScript definitions for data consistency. | `Task.ts` |
| **Services** | Centralized HTTP requests and API handling. | `axios` setup |
| **Styles** | Scoped Bootstrap styling for layout. | `*.css`, `*.scss` |

---

## 🔌 API Integration

This frontend interfaces with the `jtech-tasklist` Spring Boot API via the following endpoints:

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/v1/tasklists` | Retrieve all tasks |
| `GET` | `/api/v1/tasklists/{id}` | Retrieve a specific task by id|
| `POST` | `/api/v1/tasklists` | Create a new task |
| `PUT` | `/api/v1/tasklists/{id}` | Update an existing task |
| `DELETE` | `/api/v1/tasklists/{id}` | Permanently remove a task |

---

## 📖 Usage Guide

### 1. View & Manage
Upon loading, the **TaskList** view displays all current tasks.
* **Columns:** Title, Description, Status, Actions.
* **Tooltips:** Hover over action buttons for hints.

### 2. Create a Task
1.  Click the **➕ Add** button in the main view.
2.  Complete the form (Title, Description, Status).
3.  Click **Save**.

### 3. Edit a Task
1.  Click the **✏️ (Edit)** icon next to the target task.
2.  Update the desired fields.
3.  Save your changes.

### 4. Delete a Task
1.  Click the **❎ (Delete)** icon.
2.  Confirm the action in the pop-up modal.

---

## 🚀 Getting Started

Follow these steps to run the project locally.

### Prerequisites
* Node.js installed
* npm (Node Package Manager)

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/lukadev08/fullstack1.git
    cd jtech-tasklist-frontend
    ```

2.  **Install dependencies:**
    ```bash
    npm install
    ```

3.  **Run the development server:**
    ```bash
    npm run dev
    ```

4.  **Access the App:**
    Open your browser and navigate to the local URL provided in the terminal.

---
<p align="center">
  <sub>Developed for the jtech-tasklist project using Vue 3 & Spring Boot.</sub>
</p>
