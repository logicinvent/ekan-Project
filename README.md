# Ekan Test Project (New - 1.0) Beneficiary App

![](docs/img/Oauth2.1%20Authorization%20Server.drawio.png)

The project was developed to present hexagonal architecture, white label model, and APIs with basic security.

## Summary

I developed that App to present new features and architecture hexagonal, I used custom annotations to insert date values dynamically and some concepts of how to work with adapters and use cases, and some unit tests were developed for the App.

## Pre-requists

#### You will need some basic stuffs to run this app

`Java` - "Java SE 20 Archive Downloads -> https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html"

`Docker` - "Docker Desktop -> https://www.docker.com/products/docker-desktop/"

`Maven` - "Apache Maven 3.9.6 -> https://maven.apache.org/download.cgi"

#### How to run the app:

   1. `Maven comamnd`: mvn spring-boot:run
   
   
   2. `Spring command`: java -jar target/Ekan-Project-0.0.1-SNAPSHOT.jar


## Features:

Postman collection: https://documenter.getpostman.com/view/3572260/2sA3QnhZhy

| Beneficiary   | EndPoints                                | 
|---------------|------------------------------------------|
| POST save     | http://localhost:8080/v1/api/beneficiary |
| PUT update    | http://localhost:8080/v1/api/beneficiary    |
| GET getAll    | http://localhost:8080/v1/api/beneficiary    |
| GET getById   | http://localhost:8080/v1/api/beneficiary/{id} |
| DELETE remove | http://localhost:8080/v1/api/beneficiary/{id} |


| Document Type | EndPoints                                       | 
|---------------|-------------------------------------------------|
| POST save     | http://localhost:8080/v1/api/document-type      |
| PUT update    | http://localhost:8080/v1/api/document-type      |
| GET getAll    | http://localhost:8080/v1/api/document-type      |
| GET getById   | http://localhost:8080/v1/api/document-type/{id}   |
| DELETE remove | http://localhost:8080/v1/api/document-type/{id} |


| Document      | EndPoints                                                              | 
|---------------|------------------------------------------------------------------------|
| POST save     | http://localhost:8080/v1/api/document                                  |
| PUT update    | http://localhost:8080/v1/api/document                                  |
| GET getAll    | http://localhost:8080/v1/api/document                                  |
| GET getById   | http://localhost:8080/v1/api/document/{beneficiaryId}/{documentTypeId} |
| DELETE remove | http://localhost:8080/v1/api/document/{beneficiaryId}/{documentTypeId} |                               |

