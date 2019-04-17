# Client webapp for the library project  
  
## Description  
  
This webapp call the webservice's methods to build web pages. It provide library's user
a search function and a manager for loans (consult & extend).
  
## Technologies  
  
This application has been started via [Spring Initializr](https://start.spring.io/).  

##### Multi-modules  

It's a multi-modules application with the following structure :

![Modules' dependencies](https://raw.githubusercontent.com/xxjokerx/library-client/master/documents/modules.png)

lets review the stack used in main modules :

###### Webapp
Built around **Spring MVC** and **Thymeleaf**, it also uses **Spring Security** to manage user session.

###### Business
Make use of **MapStruct** to perform objects mapping.

###### Consumer
To consume the WSDL it uses **JAX-B2** and **Spring-WS** to connect the web service.
Finally **Spring annotation processor** dependency is here to manage custom properties in the application.properties.


## Deployment

Before you start the procedure, be sure you have deployed and ran [the associated web service](https://github.com/xxjokerx/library-service)

##### 1 - Check the wsdl URL

Depending on setting you choose for tomcat (i use port 8080 but you may have changed it), at [step 9](https://github.com/xxjokerx/library-service) you should find your wsdl on :\
http://localhost:8080/{your-webservice-context-folder}/ws/books.wsdl

And same for users.wsdl, profiles.wsdl and loans.wsdl

##### 2 - Edit the configuration

Go to `library-client-webapp/src/main/application.properties` the edit `consumer.webservice.uri=http://localhost:8080/{your-webservice-context-folder}/ws`\
Then edit `library-client-consumer/pom.xml` and configure the property base.wsdl.location as follow `<wsdl.base.location>http://localhost:8080/{your-webservice-context-folder}/ws</wsdl.base.location>`

##### 3 - Package the application

Using the command `mvn package`

##### 4 - Deploy on tomcat

You can either follow the same step as webservice's [step 9](https://github.com/xxjokerx/library-service#9---deploy-on-external-tomcat), just make sure you context folder is `/`

Or

Navigate to [http://localhost:8080/manager/html]() (you may need to configure the user in `$CATALINA_HOME/conf/tomcat-user.xml`)\

Under Deploy :

Context-path : `/`\
WAR or directory's URL : local path to your WAR

Click Deploy and it's done ! 
