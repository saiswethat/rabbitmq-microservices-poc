# RabbitMQ Microservices POC

This is a simple Spring Boot microservices proof-of-concept that demonstrates asynchronous communication using RabbitMQ running in Docker.

## ✨ Objectives
- Implement two independent microservices (A and B).

- Facilitate communication between them using RabbitMQ queues.

- Use RabbitMQ running locally via Docker


## 🛠️ Technologies Used

- Java 17
- Spring Boot
- RabbitMQ
- Maven
- Docker

---



## ⚙️ Prerequisites

- Java 17 installed
- Maven installed
- RabbitMQ running locally on port `5672`
- Postman to test the API

---

## 🐇 Starting RabbitMQ (Locally via Docker)

If you don't have RabbitMQ already running:

```bash
docker run -d --hostname rabbitmq-host --name rabbitmq \
  -p 5672:5672 -p 15672:15672 \
  rabbitmq:3-management
```

- RabbitMQ dashboard: http://localhost:15672
- Default credentials:  
  - Username: `guest`  
  - Password: `guest`

---

## 🚀 Instructions to Run the code

### 1. Clone the repository

```bash
git clone https://github.com/your-username/rabbitmq-microservices-poc.git
cd rabbitmq-microservices-poc
```

### 2. Start Consumer Service

Open a terminal:

```bash
cd message-consumer
mvn spring-boot:run
```

### 3. Start Producer Service

Open another terminal:

```bash
cd message-producer
mvn spring-boot:run
```

---

## 📬 Test the Flow with Postman

### 🔸 Endpoint

**POST** `http://localhost:8081/api/send`  
**Body (raw text):**
```
hello
```

### 🔸 Expected Flow

1. Producer sends `"hello"` to RabbitMQ.
2. Consumer receives it, replies with `"hello World"`.
3. Producer logs: `Received back: hello World`

---


## ✅ Summary

- `Producer` POSTs messages to RabbitMQ.
- `Consumer` listens and responds.
- RabbitMQ handles the messaging pipeline.