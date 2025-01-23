## About The Project

![Global Process Overview][process-overview]


### Built With

* [Spring](https://spring.io)
* [Java](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html)
* [PostgreSQL](https://www.postgresql.org/)
* [Docker](https://www.docker.com/)
* [Docker-Compose](https://docs.docker.com/compose/)
* [Intellij](https://www.jetbrains.com)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->

## Getting Started

### Prerequisites

You need to install [Docker](https://www.docker.com/) and [Docker-Compose](https://docs.docker.com/compose/) to run this
project

### Installation

1. Clone the repo
   ```shell
   git@gitlab.takima.io:mxue/todolist.git
   ```
2. Configure the project by 
   ```shell
   .env
   ```
   ⚠ Warning ⚠

   The default credentials for the app and the database are stored in the `.env` file located in the `docker` folder.
   You can change them here.


3. Build and run the project (With intellij)

   You can start / create the db by running this command:
   ```shell
   docker-compose up 
   ```

   Then start the project with **local** profiles by adding this line: `-Dspring.profiles.active=local` in your
   configuration.


4. Build and run the project (With Docker)

   You can start only the api with the attached database by clicking the `run` button in 
   `ToDoListApp`

   You can test all your endpoints in `Postman` which give you all the corresponding status responses.
   Example [GET] http://localhost:8080/api/todo-items/1

   ```
      {
      "id": 1,
      "title": "Hello world test",
      "description": "what the sunny day??????",
      "createdAt": "2021-12-03T10:15:30",
      "lastModified": "2023-12-30T10:15:30",
      "done": null
      }
   ```

5. Build and run the test

   You can run the unit test and integration test to verify that the 
   CRUD method in the TodolistApi class listens to a certain HTTP request 

## Contact

- Molly Xue- [molly504954366@gmail.com](mailto:molly504954366@gmail.com)
- 

<p align="right">(<a href="#top">back to top</a>)</p>


