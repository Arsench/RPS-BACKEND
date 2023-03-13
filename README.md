# Rock Paper Scissors game
A simple Rock Paper Scissors game developed using Spring Boot RESTful API.

## Requirements 
To run this application, you will need:<br />
. Java 11 or higher<br />
. Maven 3.6 or higher<br />
## Installation
To install and run the application, follow these steps:

1. Clone the repository to your local machine:<br />
```git clone https://github.com/USERNAME/RPS-BACKEND.git<br />```
2. Navigate to the project directory:<br />
```cd RPS-BACKEND```
3. Build the project using Maven:<br />
```mvn clean package```
4. Start the application using Maven:<br />
```mvn spring-boot:run```
## API Documentation
The RESTful API includes the following endpoints:<br />
POST /play: Plays a round of Rock Paper Scissors with the player's choice as input. Returns the computer's choice and the result of the game.<br />
The request and response formats for the POST /play endpoint are as follows:

Request:
```
{
  "selectedElement": "rock"
}
```
Response:<br />
```
{
  "playerChoice": "rock",
  "computerChoice": "paper",
  "result": "Computer wins!"
}
```

## Architecture
The application is designed using a layered architecture, with the following components:

. Controller: Handles incoming HTTP requests and maps them to service methods.<br />
. Service: Implements the game logic and calls the data access layer.

## Testing
To run the tests included in the project, use the following command:<br />

``` mvn test ```

## Deployment
To deploy the application to a production environment, build a deployable artifact using the following command:<br />

``` mvn clean package ```<br />

The resulting JAR file can be run using the following command:<br />

``` java -jar The_name_of_the_Jar ```



