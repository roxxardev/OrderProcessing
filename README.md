# OrderProcessing
Order processing rest app based on data from northwind database. Angular 5 frontend and Spring Boot 2 backend.

### Technologies
Name         | Technology
---               | ---
Frontend          | Angular 5
Backend    | SpringBoot 2
REST Documentation| Swagger
Database      | H2 
Persistence       | JPA
Security          | JWT Token Based security with Spring Security
Build Tools| Maven, angular-cli, npm

## [Demo](https://arcane-hollows-58269.herokuapp.com)
Application is hosted on [heroku](https://arcane-hollows-58269.herokuapp.com). Login credentials: test/test

## Getting Started
These instructions will get you project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
**You need to have Maven, Java 1.8 and node installed**
### Installing and starting servers
```bash
# start backend server on port 8080
# go to project root directory and type
mvn spring-boot:run

#start frontend server on port 4200
# go to /frontend directory
npm install
# it will run ng serve with proxy configuration (to port 8080)
npm start
```
### URLs
Name        | URL                                      
---               | ---                                      
Angular frontend  |  localhost:8080, localhost:8080/home/*
Swagger documentation |  localhost:8080/swagger-ui.html 
H2 Database       |  localhost:8080/h2-console     

H2 database URL can only be accessed when spring security is disabled.

## Deployment
To deploy application you can simply build frontent and copy dist folder to backend resources/static/
```bash
# install as above and type in /frontend directory, it will create static content under dist/
npm run build
# start backend
mvn spring-boot:run
```

## Features
  * Angular modules
  * AJAX requeests
  * Lazy loading
  * Loading and vizualize large data
  * Route protection
  * Chart visulaization
  * Interceptors
  * JWT token based security with Spring Security
  * Swagger API documentation 
  * H2 in memory database 
  * JPA

## Tokens
To access api you need to provide (in request header) token with "Bearer " at front. To obtain one you simply call `POST api/login` with username and password.
```
# example request
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "password": "test", \ 
   "username": "test" \ 
 }' 'https://localhost:8080/api/login'
 
# response header
"authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTE5MzAxMDY5fQ.6g4Bh0WQ50NmIEz3wU3x2LYWvOzFFfmCZP1XG3M1i7YaEwKmJBirmAQ9G4xLcySUQxZenWZp6hAsc3rcaBQzXw"

# example request with token attached
curl -X GET --header 'Accept: application/json' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTE5MzAxMDY5fQ.6g4Bh0WQ50NmIEz3wU3x2LYWvOzFFfmCZP1XG3M1i7YaEwKmJBirmAQ9G4xLcySUQxZenWZp6hAsc3rcaBQzXw' 'https://localhost:8080/api/categories'

```

Within swagger documentation at localhost:8080/swagger-ui.html you are not authenticated from start. You can do it by clicking "Authorize" button at the top right and passing "Bearer " and token. After that, all requests should have authentication header attached.
