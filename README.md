# Multiply-Technical-Assessment
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
GET:: /api/v1/shoppe/customer/all

2. To get all products
GET:: /api/v1/shoppe/customer/all

3. To make a purchase
POST:: /api/v1/shoppe/customer/all 

#Purchase Payload :: 
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


# Expected Response Object
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


# Possible Response Statuses
OK, INSUFICIENT_POINTS, NO_PRODUCTS, CUSTOMER_NOT_FOUND, INVALID_PRODUCTS


# Possible Response Status Codes
200, 400


# Database Configuration

Database = h2 (testdb)

username: sa

password:
    
To access the h2 memory database: 
http://localhost:8080/h2-console/
