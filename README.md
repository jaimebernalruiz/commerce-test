

## Instructions for run application locally

You must review each microservice the file applications.propreties, in the repository you will find application-local.properties . You make sure that application.properties have the configuration of the file application-local.properties.

Then must run each microservice with command

./mvnw spring-boot:run

The data-microservice is the service that connect to database for configure this connect you must modify the values for connection.

## Instructions for run application in aws

In the document present with the test is detailed of the infrastructure created in aws for  the application, I couldn’t implement the CI/CD with AWS CodePipeline and AWS CodeBuild.

The repository you find the dockerfiles for build docker images and once time you have images and infrastructure it would only be necessary to deploy the images
 
 
## Document OpenAPI

 The document OpenAPI is located in ./documents 

## Reflection

The first when start the modeling of the data, i was think that the three microservices be connect to database and would merge the business logic with persistence logic, for this reason I decided separate all persistence logic in other microservice with goal of that this microservice be only that connect to data base.

With the implements of JWT I think any same to back, once time implements, I thinked that could be a other micro service with the goal of separate the things of better way but I coudl’t decide. so i levae it how hte implement at first.

About structure project I tried used domain driven design and hexagonal architecture, also of repository, my goal is separated the logic in use cases for have a code more simple and evited class very extensive. also, the use of mappers for cast DTO to entities of persistence 