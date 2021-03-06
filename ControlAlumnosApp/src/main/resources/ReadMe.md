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
"src/main/resources/static/Diagrama de realciones.png"
src/main/resources/static/Diagrama de realciones.png

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

