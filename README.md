# Spring-Boot-Micro-Service-Movie-Catalog
This is the basic demonstration of how spring boot micro service application works.

PROJECT START STEPS:

Pre-requisites:
1. Java must be installed
2. Install maven module (https://maven.apache.org/install.html).

Steps:
1. To run this application, do the following:
    1.a. Go to the project root directory.
    1.b. Run the following commands in the terminal/command line to build the app:
        - mvn clean install
    1.c. Run the following command(s) in the terminal/command line to run the app:
        - java -jar microserice jar path.
    1.d. Run all three microservices and discovery-server through terminal/command one by one using above command(s).

2. Go to http://localhost:8082/catalog/{userId} in your browser to view entry microservice.

3. All three microservices and discovery-server is running on different port(s) as they are running on different tomcat instances.

