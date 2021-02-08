# BudGetter app
This repository contains the server side of the application to help you control and manage your expenses.  

## General overview
The application was created to practice cloud technologies related to the Spring Cloud framework.  

## Technologies
* Java 8
* Spring Boot (Spring Cloud)

### Minor technologies
* Eureka Naming Server - main autodiscovery tool. Every service can register itself in Eureka. It was created for load balancing.  
* ZuulProxy - main proxy of app. Every request comes here first (mostly connected with security layer).  
* Feign - tool for sending requests between services.  

## Data
Application uses H2 in-memory database 

## Setup
Every microservice should be turn on independly on itself.
$ cd auth-service-zuul / eureka-naming-server / expense-account-service  
$ mvn clean install  
$ mvn spring-boot:run  
