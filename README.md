# multiply-assessment
A basic SpringBoot shop service for multiply job application technical assessment.


# How to start the Rest Service
1. If you use Maven, you can run the application by using:
./mvnw spring-boot:run

2. Alternatively, you can build the JAR file with:
./mvnw clean package 
and then run the JAR file, as follows:
java -jar target/shoppe-1.0.0.jar

3. I have also packaged an executable jar file that can be ran with the below command:
java -jar shoppe-1.0.0.jar


# REST Service Endpoints:
1. To get all customers
URL: /api/v1/shoppe/customer/all
METHOD: GET

2. To get all products
URL: /api/v1/shoppe/customer/all
METHOD: GET

3. To make a purchase
URL: /api/v1/shoppe/customer/all
METHOD: POST
PAYLOAD: 
{
    "customerId":1,
    "products":[
        {
            "code": "1011",
            "name": "Prod1",
            "cost": 100.0
        },
        {
            "code": "1012",
            "name": "Prod2",
            "cost": 200.0
        }
    ]
}
RESPONSE_OBJECT:
{
    "status": "OK",
    "statusCode": 200,
    "customerId": 1,
    "products": [
        {
            "code": "1011",
            "name": "Prod1",
            "cost": 100.0
        },
        {
            "code": "1012",
            "name": "Prod2",
            "cost": 200.0
        }
    ],
    "invalidProducts": null,
    "total": 300.0
}

POSSIBLE RESPONSE STATUSES:
OK, INSUFICIENT_POINTS, NO_PRODUCTS, CUSTOMER_NOT_FOUND, INVALID_PRODUCTS

POSSIBLE RESPONSE STATUSES_CODES:
200, 400


DB CONFIGURATION:
Memory Database = h2
