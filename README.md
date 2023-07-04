## About The Project

![Global Process Overview][process-overview]


<p align="right">(<a href="#top">back to top</a>)</p>

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
2. Configure the project by running the setup script
   ```shell
   
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

   You can start only the api with the attached database by running
   ```shell
  
   ```
   Or you can start the whole TakimaCert project by running
   ```shell
   
   ```
   (by the way you can directly give `-n` or `-y` params to skip the build-kit activation question)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- Mailjet -->


## Contact

- Meini Xue- [mxue@takima.fr](mailto:mxue@takima.fr)
- 

<p align="right">(<a href="#top">back to top</a>)</p>


