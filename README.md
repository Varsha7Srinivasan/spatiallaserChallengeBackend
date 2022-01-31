# spatiallaserChallengeBackend

Step 1 : Create the below file with:
/src/main/resources/application.properties
```
spring.datasource.url= <jdbc url>
spring.datasource.username= <username>
spring.datasource.password= <password>
spring.jpa.database-platform=org.hibernate.spatial.dialect.postgis.PostgisDialect
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
server.port= <HTTP server port>
```

Step 2:
Also make sure to install Maven dependencies before running the server.
Build it in the IDE of choice and run. 
