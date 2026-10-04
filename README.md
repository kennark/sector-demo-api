# Sector API demo

Built using Spring Boot.

To run:
`./gradlew bootRun`  
This will expose the API at http://localhost:8080

Available API endpoints can be found at the [ApiController class](src/main/java/com/example/demoapi/api/controller/ApiController.java)

This project uses an H2 local database file. Database file location is defined
at [application.properties](src/main/resources/application.properties)
