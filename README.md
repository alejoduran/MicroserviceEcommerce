# MicroserviceEcommerce
This is the repository of ecommerce  microservices solution

Solution Description

This microservice approach was implemented with Spring Cloud framework, i used a share data base pattern, also Eureka Server provieded by Netflix, and Zuul as Api gateway to route the microservices with the server. in the next part i will explanin the functionality of each component.  

commons-microservice
- this component was used as a generic component,for the services, controller and repositories.

commons-model
- the idea with this service is provied the common entities in the project and don't rewrite the classes.

microservices-eureka
- this service is a server where we will deploy our microservices, all of them must be register in Eureka.

microservices-zuul
- Zuul is a tool that permit us dinamic routing the requests of our microservices to the server, or another external services, is know as the Api Gateway. this component is also responsible for load balancing and security filters.

microservices-products
- this is this first microservices build, in this we handle all things about the poduct, in this component we have a CRUD to create, update, list and delete a product.

microservices-orders
- The second microservice is encourage the create, update , delete , list and also trigger the checkout service (Bill service and logistic service, create the order).

DB MariaDB, is a share data base, we have to create a Data base with the name "db_microservices_ecommerce".
