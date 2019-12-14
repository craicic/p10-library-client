# Client webapp 1.1.0-ALPHA-2 for the [library project](https://github.com/xxjokerx/p10-library)
  
## Description  
  
This webapp call the webservice's methods to build web pages. It provide library's user
a search function and a manager for loans (consult & extend).
  
## Technologies  
 
Java version : 8
This application has been started via [Spring Initializr](https://start.spring.io/).  

##### Multi-modules  

It's a multi-modules application with the following structure :

![Modules' dependencies](https://raw.githubusercontent.com/xxjokerx/p10-library-client/master/documents/modules.png)

lets review the stack used in main modules :

###### Webapp
Built around **Spring MVC** and **Thymeleaf**, it also uses **Spring Security** to manage user session.

###### Business
Make use of **MapStruct** to perform objects mapping.

###### Consumer
To consume the WSDL it uses **JAX-B2** and **Spring-WS** to connect the web service.
Finally **Spring annotation processor** dependency is here to manage custom properties in the application.properties.


## Deployment

Before you start the procedure, be sure you have deployed and ran [the associated web service](https://github.com/xxjokerx/p10-library-service)

##### 1 - Check the wsdl URL

Depending on setting you choose for tomcat, at [step 9](https://github.com/xxjokerx/p10-library-service#9---deploy-on-tomcat) you should find your wsdl on :\
http://localhost:8080/{webservice-context-folder}/ws/books.wsdl

And same for users.wsdl, profiles.wsdl and loans.wsdl

##### 2 - Download this project
Then unzip it.

##### 3 - Edit the configuration

Go to p10-library-client/library-client-webapp/src/main/application.properties then edit `consumer.webservice.uri=http://localhost:8080/{your-webservice-context-folder}/{webservice.location}`\
Then edit p10-library-client-consumer/pom.xml and configure the property base.wsdl.location as follow `<wsdl.base.location>http://localhost:8080/{your-webservice-context-folder}/{webservice.location}</wsdl.base.location>`

##### 4 - Package the application

In command prompt, go to the project and run the command `mvn package`

##### 5 - Deploy on tomcat

Navigate to [http://localhost:8080/manager/html](http://localhost:8080/manager/html) (you may need to configure the user in `$CATALINA_HOME/conf/tomcat-user.xml`)

Under Deploy :

Context-path : choose `/`\
WAR or directory's URL : local path to your WAR

Click Deploy and it's done ! 

## Release notes

##### 1.0.0

Provide a web interface for library's users.

## Current version

##### 1.1.0-BETA-2

Addressed a bug where a user could extend a loan while out-of-date.

## Upcoming Version

##### 1.1.0

Will provide an advanced booking system