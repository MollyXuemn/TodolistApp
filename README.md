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
   
   ```
2. Configure the project by running the setup script
   ```shell
   ./00_setup.sh
   ```
   ⚠ Warning ⚠

   The default credentials for the app and the database are stored in the `.env` file located in the `docker` folder.
   You can change them here.


3. Build and run the project (With intellij)

   You can start / create the db by running this command:
   ```shell
   docker-compose up postgres postgres-test -d
   ```

   Then start the project with **local** profiles by adding this line: `-Dspring.profiles.active=local` in your
   configuration.


4. Build and run the project (With Docker)

   You can start only the api with the attached database by running
   ```shell
   ./10_run.sh
   ```
   Or you can start the whole TakimaCert project by running
   ```shell
   ./10_run.sh --dev
   ```
   (by the way you can directly give `-n` or `-y` params to skip the build-kit activation question)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- Mailjet -->

### Mailjet for your local environment (Optional)

1. Create an account to [Mailjet](https://app.mailjet.com/signup?lang=fr_FR):


2. Go to settings then click on API Key Management (Primary and Sub-account), and generate an api key.
   in REST API section
   > Update it in `configuration -> Environment variables` via Intellij : `MAILJET_KEY = your_key`


3. Then generate a Secret Key:

   > Update it in `configuration -> Environment variables` via Intellij : `MAILJET_SECRET = your_secret_key`

4. Finally, set up your mailjet address (mail that created your account) :
   > `configuration -> Environment variables` via Intellij : `MAILJET_ADDRESS = your_mailjet_address`

As you can see in `resources/mail/*.html`, it's mostly impossible to maintening those.

They are like this because we used a mail templating site, and then we exported to html format to use it in our code.

If one day, you need to refacto the mail template or create a new one, I advise you to restart it from scratch and also use templating site, it will be a lot easier.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->

## Contact

- Alexandre REAUBOURG - [areaubourg@takima.fr](mailto:areaubourg@takima.fr)
- Fabien PUISSANT - [fpuissant@takima.fr](mailto:fpuissant@takima.fr)
- Benjamin YVERNAULT - [byvernault@takima.fr](mailto:byvernault@takima.fr)
- Aurélien MOREAU [amoreau@takima.fr](mailto:amoreau@takima.fr)
- Léa BRUCHON [lbruchon@takima.fr](mailto:lbruchon@takima.fr)
- Eric Li [eli@takima.fr](mailto:eli@takima.fr)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge

[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge

[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members

[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge

[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers

[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge

[issues-url]: https://github.com/othneildrew/Best-README-Template/issues

[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge

[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://linkedin.com/in/othneildrew

[process-overview]: docs/img/process_overview.svg