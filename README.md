# entech-event-services

**Introcution**

Entech Event Services is a Java-based microservice that provides a RESTful API used to store and retrieve event-related data. It was developed by the original JnJ GradTech team in June'2018.

**Technology Stack**
- Java 8
- Maven
- Spring Boot
- Flyway
- MySQL

**Build Instructions**
1. Install Git.
2. Install Java (1.8.x).
3. Install Maven (3.5.3).
4. Clone this repository.
5. From the project directory execute `mvn clean install`
6. From the project directory execute `java -tar target/event-services-0.0.2-SNAPSHOT.jar`
7. Verify the API is working by opening a browser and navigating to `http://localhost:8080/demo/all`
