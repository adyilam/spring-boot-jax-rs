## JAX-RS REST API using Spring Boot

This is a basic guide on how to create a JAX-RS (Java API for RESTful Web Services) REST API using Spring Boot framework. 
JAX-RS is a Java standard for building RESTful web services, and Spring Boot is a popular Java framework for building scalable 
and efficient web applications. 

This guide assumes that you are familiar with Java, RESTful web services, and have a basic understanding of Spring Boot.

# Prerequisites

You will need the following:

1. Java Development Kit (JDK) installed on your local machine
2. Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA
3. Spring Boot installed or included as a dependency in your project
4. Maven or Gradle build tool installed on your local machine

# Getting Started

Follow the steps below to create a JAX-RS REST API using Spring Boot:

Step 1: Create a new Spring Boot project

You can create a new Spring Boot project using:
  1. Spring Initializr web-based tool
  
  Make sure the maven file should have spring-boot-starter-jersey
  ```   
  <dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-jersey</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency> 
  ```
  2. Spring Boot CLI (Command Line Interface)
  ```
  spring init --dependencies=web <<project_name>>
  ```
     
Step 2: Create a JAX-RS Resource
In JAX-RS, a resource represents a RESTful endpoint that handles HTTP requests and responses. 
To create a JAX-RS resource in your Spring Boot project, you can follow these steps:

Create a new Java class in your project that represents your JAX-RS resource. This class 
should be annotated with @Path and @Produces annotations from the javax.ws.rs package, which 
define the URI path and media types that the resource produces, respectively. 

For example:
```
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ProductResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }
}
```

Step 3:
