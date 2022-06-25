# ControlAlumnosApp
ESCALAB - SpringBootApplication level 3 
# Student Control SchoolProject
# ESCALAB - ACADEMY
##### Web application created with SpringBoot, and Postgresql relational database.
<br/>

### Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Modeling Data Base](#modeled DataBAse)
* [Setup](#setup)

* 
## General info
SpringBoot Resfull Aplication where students, teachers, tutors and Admins can performs the correspond services like Get, Put, Post, Delete...but with their permissions.
It is implemented SpringSecurity with their Roles and permiossions.


### Technologies and dependencies


````
* Java 8
* Spring Boot version: 2.1.9
* Spring Web
* Spring Security
* Devtools
* Validation
* Jpa
* PostgreSQL
* Hateoas
* SwaggerConfiguration to document Controllers and Entities
* Cors Filter
* DTO structure
* Exceptions

````
### Modeling Data Base
Here is the diagram of relation between classes

![Diagrama de realciones](https://user-images.githubusercontent.com/69442805/171068270-d32b1faf-5358-4c8b-84d7-907cbdb74eed.png)


### Swagger Screen shot

![image](https://user-images.githubusercontent.com/69442805/171069084-7bd7a222-15fa-4cbc-9359-aae38cb80fcd.png)

### RESTful Stress screen shot
![Setting Prueba de Stress](https://user-images.githubusercontent.com/69442805/175750755-457c5703-4408-42b0-acff-21e7f28799b9.png)
![Resultado prueba Stress](https://user-images.githubusercontent.com/69442805/175750762-9f1d9c62-d37f-46e7-a405-647f35e22b0e.png)

## Setup
To run this project, install it locally, open it into your IDE, go to the properties file and then
change the database configuration like driver, Url, db name, user and password. Finally, run it as any other java
application.

```
   dataSourceBuilder.driverClassName("org.postgresql.Driver");
   dataSourceBuilder.url("jdbc:postgresql://localhost:5432/dbName");
   dataSourceBuilder.username("username");
   dataSourceBuilder.password("password");
```

### Author
This repository is from a learning Course at ESCALAB ACADEMY tought by Josse Ángel Niño Silverio.

* **Barrera Luis German**  - *Java Engineer*

