# Java Backend - ProjectSupport

## Overview
The Java Backend - ProjectSupport is a server-side component of the "System supporting management of projects" (ProjectSupport). It is built using Java technologies, including Spring Security, Spring Boot, Spring Data, and JPA. The Java backend handles the core functionality and data management for the ProjectSupport system.

## Requirements
To run the Java Backend - ProjectSupport, ensure that the following software and dependencies are installed:

- Java Development Kit (JDK)
- Apache Maven
- PostgreSQL
- Docker

## Getting Started
1. Clone the Java Backend - ProjectSupport repository from the provided source.
2. Set up the database `Database (PostgreSQL) - Setup` system and configure the database connection details in the application configuration.
3. Build the project using Maven.
4. Run the application using the Spring Boot CLI or an IDE.
5. The backend APIs will be accessible at the configured endpoint (e.g., http://localhost:8080).

## Database (PostgreSQL) - Setup:
1. Download [Docker Desktop](https://www.docker.com/products/docker-desktop/).
2. Launch a terminal and execute the following commands:
- docker pull postgres
- docker run --name project-support-db -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
3. Check in Docker Desktop if the container has been created successfully.
4. Install [pgAdmin](https://www.pgadmin.org/download/) for managing the database.
5. Launch pgAdmin and add a new server: Register > Server. Use the server name, password (postgres), and address (localhost).
6. Create a new database on the added server and name it **PSdata**.

#### Useful:
- Check the container status and its execution: `docker ps -a` or in Docker Desktop.
- Start the container: `docker start project-support-db`.
- Stop the container: `docker stop project-support-db`.