# How to Start Rest API  - CLI

1) import post_data_backup.sql 
    -- mysql -u "username"  -p  < post_data_backup.sql
    -- password 
2)
    
3) Install vmn - setup to install https://openiam.atlassian.net/wiki/spaces/IAMSUITEV3/pages/524742/Installing+Apache+Maven+on+Mac
	and check mvn -version

4) To run the application 
  - 	mvn spring-boot:run
  
  #OR

5)  you can use the following maven command to package your spring boot application as jar.
   --mvn clean package
   you will get the jar :-   visual-meta/target/visual-meta-0.0.1-SNAPSHOT.jar

6)   Run the jar 
       java -jar target/visual-meta-0.0.1-SNAPSHOT.jar
       
7) Open http://localhost:8080/api/ -- you will get welcome messagd        
       
	
 