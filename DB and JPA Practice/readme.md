
Manual Query written system with jdbc template
------------------------------------------------------------
- Configuring Database (Creatign JdbcTemplate)
- Creating model (Student)
- Creating JdbcController to take data from postman and update the data to database through StudentService class
- Creating StudentService class for inserting data into database

Modern JPA system where manual querry doesn't require at all
--------------------------------------------------------------

- Here we don't need to configure the database separtely, but wiil configure it in application.yml file, here the database will be 
  created automatically using hibernate and ddl (yml file helps to write the clean code here)
- In student service we don't need to create manual query, jpa and hibernate will take care of it
- Here StuentRepository interface extends all the jpa properties
- we inject the Studentrepository in Studentservice class, by which we can avoid manual query

Sql joining(many to many and one to one) and personally query writing in interface are not included in this repo.

