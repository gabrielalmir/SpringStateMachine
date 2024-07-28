
# SpringStateMachine

SpringStateMachine is a project designed to study and demonstrate the usage of Spring State Machine. This project includes a state machine configuration for managing the states and transitions of an order processing system.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [State Machine Configuration](#state-machine-configuration)
- [Running the Project](#running-the-project)
- [Endpoints](#endpoints)

## Introduction

This project demonstrates the use of Spring State Machine to handle the lifecycle of an order. It covers the creation of states, transitions, and actions associated with each state transition in the order processing workflow.

## Technologies Used

- Java
- Spring Boot
- Spring State Machine
- Maven

## Project Structure

The project consists of the following main components:

- `StateMachineConfig`: Configures the states, transitions, and actions of the state machine.
- `OrderController`: REST controller to handle HTTP requests for order operations.
- `OrderService`: Service layer to manage the business logic of the order state transitions.

## State Machine Configuration

The state machine configuration defines the various states an order can be in and the events that trigger transitions between these states. The states include:

- `NEW`
- `VALIDATED`
- `PAID`
- `SHIPPED`
- `COMPLETED`
- `CANCELLED`

The transitions are defined by the events:

- `VALIDATE`
- `PAY`
- `SHIP`
- `COMPLETE`
- `CANCEL`

## Running the Project

To run the project, follow these steps:

1. Clone the repository:
    ```
    git clone https://github.com/gabrielalmir/SpringStateMachine.git
    ```
2. Navigate to the project directory:
    ```
    cd SpringStateMachine
    ```
3. Build the project using Maven:
    ```
    mvn clean install
    ```
4. Run the application:
    ```
    mvn spring-boot:run
    ```

## Endpoints

The project exposes the following REST endpoints to interact with the order state machine:

- `POST /order/new`: Creates a new order and transitions its state to `NEW`.
- `POST /order/pay`: Transitions the order state to `PAID`.
- `POST /order/ship`: Transitions the order state to `SHIPPED`.
- `POST /order/complete`: Transitions the order state to `COMPLETED`.

Each endpoint triggers the respective event in the state machine to transition the order to the next state.

## Conclusion

This project serves as a basic example of using Spring State Machine to manage the lifecycle of an order. It demonstrates how to configure states, transitions, and actions, and provides a simple REST API to interact with the state machine.
