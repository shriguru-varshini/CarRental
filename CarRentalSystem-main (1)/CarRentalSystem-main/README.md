To make changes to the repository, First pull the repo in a local folder, make changes and then push in the main branch




Update - Novaneel - 9 March 2025

- Modified backend to work smoothly.
- Tested APIs from React App through multiple Components 
- CRUD of users, cars, Reservations and payments working fine.


Major Updates 

Changed the earlier codes where we used traditional approach to build java project.
In the new one I have modified the codes to use JPArepository extension and RestAPI to make it easier to build.


to create tables and insertions uncomment the last two lines :

#spring.sql.init.mode=always  
#spring.sql.init.platform=mysql 

in the application.properties and then run CarRentalApplication.java. 
The tables and insertion should take place automatically 

NOTE: The uncomment of the two lines should be done only once i.e. the first run to avoid duplicate entries to get inserted in the table 



Feel free to test the APIs in POSTMAN. 
For any Doubt, Do Contact in Teams or Whatsapp.
