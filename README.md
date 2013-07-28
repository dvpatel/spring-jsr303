spring-jsr303
-------------------
Example of Spring / JSR-303 data validation based on rules defined in Annotations and XML file.  This is work in progress.

For technical documentation, refer to URL:  http://digital-gems.blogspot.com/2013/07/protecting-your-application-from-mallory.html

Application access and execution
-------------------
Code Access:  
*  cd <dev_source_dir>
*  git clone git://github.com/dvpatel/spring-jsr303.git
	
Run Unit Tests:  
*  cd <dev_source_dir>
*  mvn tests
	
Run Sample App:
*  cd <dev_source_dir>/spring-jsr303
*  mvn tomcat7:run-war
*  http://localhost:8080/spring-jsr303

System Requirements:
-------------------
*  Java +1.6
*  Maven +3.X

All dependencies, including Spring, Hibernate, tomcat7, and supporting components are configured through maven.  See pom.xml for complete details.

