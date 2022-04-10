# Spring Boot Prices Microservice Project

This is a SpringBoot PricesService microservice. Currently the service only supports an operation to obtain the price of a product fulfilling the conditions indicated in the requirements.   

## How to Run 

* Clone this repository:
```
git clone https://github.com/damor4321/prices-service.git
cd prices-service
git checkout main
```

* Make sure you are using JDK 1.11.x and Maven 3.x
* You run the tests by running ``mvn clean test``
* You can build the project, run the tests and verify the outcome by running ``mvn clean verify``
* You can build the project and run the tests and install the generated artifact to your local mvn repository by running ``mvn clean install``
* You can run the service by running ``mvn spring-boot:run``

Then the service is running in http://localhost:60002

Once the application runs you should see something like this

```
2022-04-10 11:26:26.194  INFO 216157 --- [           main] o.s.b.w.e.t.TomcatWebServer              : Tomcat started on port(s): 60002 (http) with context path ''
2022-04-10 11:26:26.199  INFO 216157 --- [           main] c.g.d.p.PricesServiceApplication         : Started PricesServiceApplication in 2.22 seconds (JVM running for 2.667)
```

## About the Service

The service is just a simple price REST service. It uses an in-memory database (H2) to store the data.

 
Here is the one endpoint you currently can call:


### GET a price resource for a product

```
curl --location --request GET "http://localhost:60002/prices/v1/product?product_id=35455&brand_id=1&request_date=2020-06-16%2021%3A00%3A00"

Response: HTTP/1.1 200
Content-Type: application/json

{
   "brandId":1,
   "startDate":"2020-06-15T14:00:00.000+00:00",
   "endDate":"2020-12-31T22:59:59.000+00:00",
   "pricelist":4,
   "productId":35455,
   "price":38.95,
   "currency":"EUR"
}
```

Note that the params for the GET request must be url encoded. Otherwise it will returns:

```
Response: HTTP/1.1 400

{
   "timestamp":"2022-04-10T09:39:16.344+00:00",
   "status":400,
   "error":"Bad Request",
   "message":"",
   "path":"/prices/v1/product"
} 

```

If there is not a price resource for the requested params, the response will be:

```
Response: HTTP/1.1 400

{
   "ErrorMessage":"java.lang.Exception: Price not found for product: 10, brand_id: 1",
   "Exception":"NoPriceFoundException"
}

```

All the prices service exceptions (NoPriceFoundException, DataStoreException...) are children of the class PricesServiceException. 
And they will be intercepted and handled by the annotated @RestControllerAdvice controller class PricesServiceExceptionController. 
As is explained in

```

https://www.baeldung.com/exception-handling-for-rest-with-spring#controlleradvice

```



