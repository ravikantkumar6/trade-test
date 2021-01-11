# Code Design Criteria
## Used SOLID principle to design this code.

* Single Responsibility Principle
* Open/Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion

#workers
## Created 3 workers(Thread) 
* For Reading File and add into blocking queue
* Second is doing processing and putting into queue after grouping.
* Third is schedular, picking data from the queue in each 15 second and sending to websocket topic.

#Data structures

Mainly I have used Blocking queue and List data Structure. 

#Instructions to setup and run

We can run this application in any env. No need of any external thing.

```java
Gradlew clean build
```
We will get jar file in the lib folder.
```java
java -jar <fully qualified name of jar file>
```
Service will start running on 8080 port. if you want to change port then we pass port number extenally.


### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

