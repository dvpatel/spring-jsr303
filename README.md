spring-jsr303
-------------------
Example of Spring / JSR-303 data validation based on rules defined in Annotations and XML file.  This is work in progress.

For technical documentation, refer to URL:  http://digital-gems.blogspot.com/2013/07/protecting-your-application-from-mallory.html

System Requirements:
-------------------
*  Java +1.6
*  Git +1.8
*  Maven +3.X

All dependencies, including Spring, Hibernate, tomcat7, and other supporting components are retrieved and configured using maven project manager.  See pom.xml for complete details.

Run-time
-------------------
Code Access:  
*  git clone https://github.com/dvpatel/spring-jsr303.git

Build Project:  
*  cd spring-jsr303
*  mvn package
	
Run Unit Tests:  
*  cd spring-jsr303
*  mvn test
	
Run Sample App:
*  cd spring-jsr303
*  mvn tomcat7:run-war
*  http://localhost:8080/spring-jsr303

To clean:
*  cd spring-jsr303
*  mvn clean