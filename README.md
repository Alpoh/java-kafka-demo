# POC: Java 21 + Spring Boot + Kafka

This project is a Proof of Concept (POC) demonstrating a microservices architecture using modern technologies: **Java 21**, **Spring Boot**, **Apache Kafka**, and **Maven**.

The application is structured as a multi-module Maven project with three microservices:
* **User Service**: Manages user-related data and produces events to Kafka.
* **Item Service**: Manages items and can consume events from other services.
* **Transaction Service**: Handles transactions, consuming and producing events to complete business flows.

The project uses an **event-driven architecture** where microservices communicate asynchronously via Kafka topics.

## 🚀 Technologies Used

* **Java 21**: The latest LTS version, leveraging **Virtual Threads** for high concurrency.
* **Spring Boot 3.2.5**: Simplifies application configuration and development.
* **Apache Kafka**: A distributed streaming platform for real-time, event-driven communication.
* **Maven**: Manages project dependencies and the build lifecycle.
* **H2 Database**: An in-memory database used for development and testing.

## 📦 Project Structure

The project is a multi-module Maven project with the following structure: