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

NOTE: I didn't use doceker because in this moment i am studing and only i have the containers basic concepts

STEPS TO DEPLOY THE APPLICATION
1 - Download DB MariaDB,we have to create a Data base with the name "db_microservices_ecommerce" with the user='root' anda password='root', the table wil be created atomatically.
2 - Checkout microservices-eureka service form the repo and runt a Spring boot application.
3 - we have to checkout the services locally (commons-microservice, commons-model, microservices-products, microservices-orders) and verify that the product and orders microservices compile in the correct way, after that run as Spring boot aplication the services (microservices-products, microservices-orders).
4 - start a Api gateway, we have to run  microservices-zuul proyect.
5 - the last step i verify the correct functionality of the Services in Swagger, we have to identify the port of orders microservices after the proect started.

also yo can verify with postman the curls are the following:

- Service suggested in the challenge  checkoutOrder

                        curl --location --request POST 'localhost:8090/api/orders/checkout' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "clientId" : 2,
        "direction" : "Calle 30 #" ,    
        "products" : [
            {
        "id": 3,
        "name": "Beisball Ball",
        "quantity": 20,
        "cost": 50.00
    }
        ]
   
    },
    {
        "clientId" : 1,
        "direction" : "Calle 11C # 79-82" ,    
        "products" : [
            {
        "id": 1,
        "name": "ping pong Ball",
        "quantity": 6,
        "cost": 100.00
    },
    {
        "id": 2,
        "name": "Soccer Ball",
        "quantity": 10,
        "cost": 2000.00
    }
        ]
   
    }
]'
                
- get products = curl --location --request GET 'localhost:8090/api/products' 
- get orders = curl --location --request GET 'localhost:8090/api/products'
- create product = curl --location --request POST 'localhost:8090/api/products' \
                        --header 'Content-Type: application/json' \
                        --data-raw '{
                                      "name":"Beisball Ball",
                                      "quantity":20,
                                      "cost" : "50"
                              
                                      

