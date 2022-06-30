# java-spring-kafka-mongodb-example
Example of communication between two Spring APIs using Kafka Broker and data persistence using MongoDB. This project uses docker-compose for container management.

## Technologies and tools used in this example
- Java
- Maven
- Spring Boot
  - Spring Data MongoDB
  - Spring Web
  - Spring Kafka
- Lombok
- Validation API
- Kafka
- Mongo DB
- Docker Compose

## How it works
It simulates a bank transfer operation. 
- The first API (bank-transfer-api) is responsible for receiving the bank transfer information, performing data validation and sending it to the transactions topic.
- The second API (transactions-api) is responsible for listening to the transactions topic and persisting all transactions data in the NoSQL Database. You can also retrieve all persisted data by calling /transactions.

## Testing the application.

### Running the application:

#### Running via docker-compose:

In the main project folder (java-spring-kafka-mongodb-example), run the command ```docker-compose up```. You must have Docker and Docker-compose installed on your host machine.

#### Running the APIs on your host machine:

1. In the main project folder (java-spring-kafka-mongodb-example), run the command ```docker-compose -f "docker-compose-local.yml" up```. The MongoDB database and Kafka will run in docker containers, which can be accessed by APIs running on your host machine.
2. Run both APIs (bank-transfer-api and transactions-api) with the local profile, by running the command ```mvn spring-boot:run -D"spring-boot.run.profiles"=local``` in the root folder of both projects.

### Performing Requests:

Performing a new bank transfer:

```
curl --location --request POST 'http://localhost:9090/bank-transfer-api/v1/transfers' \
--header 'Content-Type: application/json' \
--data-raw '{
    "transferValue": 1,
    "originAccount": {
        "bank":"01",
        "branch": "0001",
        "account": "123456789100"
    },
    "destinationAccount": {
        "bank": "10",
        "branch": "1000",
        "account": "100987654321"
    }        
}'

```
Retrieving the performed bank transfer:

```
curl --location --request GET 'http://localhost:9091/transactions-api/v1/transactions'
```

You should get the following response body:
```
[
    {
        "transactionType": "TRANSFER",
        "transactionData": {
            "transferValue": 1.0,
            "originAccount": {
                "bank": "01",
                "branch": "0001",
                "account": "123456789100"
            },
            "destinationAccount": {
                "bank": "10",
                "branch": "1000",
                "account": "100987654321"
            }
        }
    }
]
```


