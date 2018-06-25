

## Setup the Application

1. Create a database named `continent`.
   create database continent in mysql workbench.
2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your MySQL installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.
OR
By issuing the below command the application will run
java -jar springboot-flagpicker/target/flag-picker-springboot-services-0.0.1-SNAPSHOT.jar
This will automatically create database continent. Using PostMan the data can be uploaded.
and the services will work for saving continents, countries and their informations to the db.

