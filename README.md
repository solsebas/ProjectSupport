# Project Name
- System supporting management of projects - ProjectSupport

# Description
ProjectSupport is a comprehensive educational project management system that provides easy organization, assessment, communication, and reporting functionalities. The project has been implemented using the following technologies:
- **Angular**: User interface
- **Java**: Backend
- **Spring Boot**: Java framework
- **Spring Data**: Data access framework
- **JPA (Java Persistence API)**: Interface for managing relational data in Java
- **PostgreSQL**: Database

![main page](https://imgtr.ee/images/2023/06/20/ZAsSn.jpg)

![panel](https://imgtr.ee/images/2023/06/20/ZAtWc.jpg)

# Environment
To run the project, the following software needs to be installed and configured:
- **Node.js**: Version 14.x or higher
- **Java Development Kit** (JDK): Version 11 or higher
- **PostgreSQL**: Installed database server

# Deployment Instructions

## New method - docker compose
1. Download [Docker Desktop](https://www.docker.com/products/docker-desktop/).
2. Launch a terminal, enter angularclient folder and execute the following command:
- `npm run build`
3. Enter main project folder and execute the following command:
- `docker compose up ` (For detach mode add `-d`. Containers will be started in the background, and the console output will be available for further use)

## Old method

### Database (PostgreSQL) - Setup:
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

### Angular:
1. Install [node.js](https://nodejs.org/en/download) (recommended version: "LTS 18.15.0 (includes npm 9.5.0)").
2. Set appropriate execution permissions for PowerShell scripts: `Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope LocalMachine`.
3. Install Angular CLI: `npm install -g @angular/cli`.
4. In the project folder of Angular, execute the following commands:
- npm install
- ng serve --open
#### Useful:
- Launching the Angular application: `ng serve --open`  (in the project folder, e.g., [...]\InteliJDepos\ProjectSupporter\project-supporter-client).

## Bibliography:
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)