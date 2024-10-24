# EchoPay-Processor

EchoPay-Processor is a microservice responsible for processing financial transactions that are received from the EchoPay API. It listens to transaction events via Kafka and updates the transaction status in PostgreSQL.

## Requirements

- **Java 21**
- **Docker** and **Docker Compose**
- **Kafka**
- **PostgreSQL**

## Setup and Execution

### 1. Clone the repository

```bash
git clone https://github.com/kbdemiranda/EchoPay-Processor.git
cd EchoPay-Processor
```

### 2. Configure Docker Compose

The project is configured to run using `docker-compose` alongside the EchoPay service, Kafka, and PostgreSQL.

Run the following command to start the containers:

```bash
docker-compose up
```

### 3. Main Functionality

- Processes transactions by listening to the Kafka topic `transactions`.
- Updates the transaction status to `APPROVED` after processing.

## Environment Variables

The environment variables configured in `docker-compose.yml` include:

- `SPRING_KAFKA_BOOTSTRAP_SERVERS`: Configured Kafka server.
- `ECHOPAY_SERVICE_URL`: URL for communicating with the EchoPay API.

## Project Structure

```bash
├── application/         # Contains services for transaction processing
├── infrastructure/      # Kafka and other configurations
├── Dockerfile           # Docker configuration file
└── docker-compose.yml   # File to orchestrate the containers
```

## Technologies Used

- **Spring Boot**: Framework for handling transaction processing.
- **Kafka**: For consuming transaction events from EchoPay.
- **PostgreSQL**: To store the updated transaction status.
- **Docker**: For containerization and service orchestration.

## Author

Developed by **Kaique de Miranda**.

