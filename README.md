spring-jsr303
-------------------
Example of Spring / JSR-303 data validation based on rules defined in Annotations and XML file.  This is work in progress.

For technical documentation, refer to URL:  http://digital-gems.blogspot.com/2013/07/protecting-your-application-from-mallory.html

System Requirements:
-------------------
*  Java +1.6
*  Git +1.8
*  Maven +3.X

All dependencies, including Spring, Hibernate, tomcat7, and supporting components are configured using maven build envionrment.  See pom.xml for complete details.

App run-time
-------------------
Code Access:  
*  cd DEV_SOURCE_DIR
*  git clone git://github.com/dvpatel/spring-jsr303.git
	
Run Unit Tests:  
*  cd DEV_SOURCE_DIR
*  mvn tests
	
Run Sample App:
*  cd DEV_SOURCE_DIR/spring-jsr303
*  mvn tomcat7:run-war
*  http://localhost:8080/spring-jsr303