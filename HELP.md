# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.5/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.5/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


## Guide Seby:

### Baza tworzenie:
(https://hevodata.com/learn/docker-postgresql/)

1. pobranie [Docker Desktop](https://www.docker.com/products/docker-desktop/)
2. pobieranie najnowszej wersji postgresa `docker pull postgres`
3. tworzenie nowego kontenera: `docker run --name project-support-db -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres`
4. po poprawnym wykonaniu polecenia w Docker Desktop powininen się pojawić nowy kontener
5. polecam [pgadmin](https://www.pgadmin.org/download/) tam można jebnąć sobie database'a i później może się przydać do przeglądania bazy.
6. po wejściu w pgadmina **Register > Server** i podajemy nazwe jakąś i pare innych pierdół jak hasło na konto (**postgres**) i adres (**localhost**)
7. stworzyć database'a na dodanym serwerze i dać mu nazwę **PSdata**, żadna specjalna konfiguracja nie jest potrzebna
8. w **pkt. 3** zalecam zostawić hasło **postgres** i w **pkt. 7** dać nazwę database'a **PSdata**, żebyśmy mieli to samo i nie musieli potem pierdolić się z tym w application.properties. 

#### Przydatne:
- to czy wam stoi kontener i czy jest włączony można sprawdzić `docker ps -a` albo w Docker Desktop
- włączanie kontenera: `docker start project-support-db`
- wyłączanie kontenera: `docker stop project-support-db`


