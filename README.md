# Power Plant System

A virtual power plant system for aggregating distributed power sources into a single cloud based energy provider. 

The system comprises the battery inventory which holds two functionalities.

- Store all batteries with properties: name, postcode and capacity.
- Fetch battery list with associated statistics data based on postcode range.


# Server Details
server.port=8080

# Database
URL: http://localhost:8080/h2-console

In-memory database (H2 database) is used in this system.

# Tools and Library used

- Spring Boot
- JDK 1.8
- Maven 3
- Lombok

# For building and running the application you need:
- JDK 1.8
- Maven 3

# Running the application locally

There are several ways to run a Spring Boot application on your local machine.

- One way is to execute the main method in the com.powerplantsystem.PowerPlantSystemApplication class from your IDE.

- Alternatively you can use the Spring Boot Maven plugin like so:
  
  mvn spring-boot:run

# Postman Collection
Location: ./POWER PLANT SYSTEM.postman_collection.json

The API documentation includes two APIs with request and response examples.

     
# Test Data
    [
        {
            "name": "Cannington",
            "postcode": "6107",
            "capacity": 13500
        },
        {
            "name": "Midland",
            "postcode": "6057",
            "capacity": 50500
        },
        {
            "name": "Hay Street",
            "postcode": "6000",
            "capacity": 23500
        },
        {
            "name": "Mount Adams",
            "postcode": "6525",
            "capacity": 12000
        },
        {
            "name": "Koolan Island",
            "postcode": "6733",
            "capacity": 10000
        },
        {
            "name": "Armadale",
            "postcode": "6992",
            "capacity": 25000
        },
        {
            "name": "Lesmurdie",
            "postcode": "6076",
            "capacity": 13500
        },
        {
            "name": "Kalamunda",
            "postcode": "6076",
            "capacity": 13500
        },
        {
            "name": "Carmel",
            "postcode": "6076",
            "capacity": 36000
        },
        {
            "name": "Bentley",
            "postcode": "6102",
            "capacity": 85000
        },
        {
            "name": "Akunda Bay",
            "postcode": "2084",
            "capacity": 13500
        },
        {
            "name": "Werrington County",
            "postcode": "2747",
            "capacity": 13500
        },
        {
            "name": "Bagot",
            "postcode": "0820",
            "capacity": 27000
        },
        {
            "name": "Yirrkala",
            "postcode": "0880",
            "capacity": 13500
        },
        {
            "name": "University of Melbourne",
            "postcode": "3010",
            "capacity": 85000
        },
        {
            "name": "Norfolk Island",
            "postcode": "2899",
            "capacity": 13500
        },
        {
            "name": "Ootha",
            "postcode": "2875",
            "capacity": 13500
        },
        {
            "name": "Kent Town",
            "postcode": "5067",
            "capacity": 13500
        },
        {
            "name": "Northgate Mc",
            "postcode": "9464",
            "capacity": 13500
        },
        {
            "name": "Gold Coast Mc",
            "postcode": "9729",
            "capacity": 50000
        }
    ]


# General Success Response
    {
    "status": "OK",
    "message": "Battery statistics data fetched successfully",
    "code": "200",
    "data": {}
    }

# General Error Response
    {
    "status": "INTERNAL_SERVER_ERROR",
    "message": "Requested data not found",
    "errors": ["No value present"]
    }

