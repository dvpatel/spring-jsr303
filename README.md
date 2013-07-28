spring-jsr303
-------------------
Example of Spring / JSR-303 data validation based on rules defined in Annotations and XML file.  This is work in progress.

For technical documentation, refer to URL:  http://digital-gems.blogspot.com/2013/07/protecting-your-application-from-mallory.html

Application access an execution
-------------------
Code Access:  git clone git://github.com/dvpatel/spring-jsr303.git
	
Run Unit Tests:  mvn tests
	
Run Sample App:
*  cd <dir>/spring-jsr303
*  mvn tomcat7:run-war
*  Access:  http://localhost:8080/spring-jsr303

System Requirements:
-------------------
*  Java 1.6
*  Spring 3.2.3 and supporting components
*  Hibernate 4.3.1Final for JSR-303 implementation
*  Tomcat 7

See pom.xml for complete details

