[![Build Status](https://travis-ci.org/joao-osilva/springboot-rabbitmq-parser.svg?branch=master)](https://travis-ci.org/joao-osilva/springboot-rabbitmq-parser)

# Spring Boot RabbitMQ Parser
> By: João Silva (vitor191291@gmail.com)

A simple adapter implementation that consumes messages, parse them and place it in a message broker.

Implemented with:
* Java 8
* Spring Boot 1.5.6-RELEASE
* Maven 3
* Tomcat 8
* RabbitMQ
* Docker

Package the app:
```
$ mvn package
```

Use docker compose to spin up the whole environment:
```
$ docker-compose up
```

RabbitMQ management console can be accessed through ```http://localhost:15672```, with user ```admin``` and password ```Admin123```
