# Upesi Transactions Service

Upesi Transactions Service is a transaction processing system to implement the below functionality.

### Key objectives

```
* Allows user to login whilst maintaining security and allowing for single sign on.
* Allows user to transfer funds and confirm if they have adequate funds in their account.
* Allows user to withdraw money from an ATM if they have adequate funds in their account and the ATM has adequate money to dispense. 
```
## Project Structure

### Project Language/Platform/Boundaries
List of framework/platform/dependent components this project uses.

* Language: `Java [v17]`
* Framework: `Spring Boot [v3.1.2]`
* Additional Frameworks: `Spring Webflux`, `R2DBC`, `Aerogear`, `Passay`, `Google-Guava`, `Uap-Java`, `Geoip2`
* Data Cache: `Redis Data Cache`
* Database: `MariaDb`

### Libraries
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/maven-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#actuator)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web.reactive)
* [OAuth2 Authorization Server](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web.security.oauth2.authorization-server)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web.servlet.spring-mvc.template-engines)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#io.email)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.r2dbc)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.nosql.redis)
* [Prometheus](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#actuator.metrics.export.prometheus)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#io.validation)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#web.security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsinge/index.html#data.sql.jpa-and-spring-data)
* [Liquibase](https://contribute.liquibase.com/extensions-integrations/directory/integration-docs/springboot/springboot/)
* [AeroGear](https://github.com/aerogear-attic/aerogear-otp-java)
* [Java Passay](https://www.baeldung.com/java-passay)
* [Google Guava](https://github.com/google/guava/wiki)
* [Uap Java](https://github.com/ua-parser/uap-java)
* [GeoIp](https://dev.maxmind.com/geoip/docs/databases)

### Logging
- For local deployment, it is available on STDOUT using the format configured in [logback.spring.xml](src/main/resources/logback.spring.xml)
- For remote deployment, it is available on New Relic using the format configured in [logback.spring.xml](src/main/resources/logback.spring.xml).

### **Here is our quickstart guide.**
* Clone the repo
```shell
 git clone git@github.com:AlexKimani/upesi.git
```
* When you attempt to clone the repository, you receive the error message. [Fix – git@github.com : permission denied](https://dev.classmethod.jp/articles/fix-gitgithub-com-permission-denied-publickey-fatal-could-not-read-from-remote-repository/)
* [Install docker](https://docs.docker.com/get-docker/). Ensure that docker is always running.

## Running and testing
* via IDE for local debugging (recommended)
  * Run all the required Services on Docker `docker-compose up --scale service-upesi-auth=0 service-upesi-account=0`. Note: This command won't start `service-upesi-auth` and `service-upesi-account`
  Please follow the troubleshooting section if you are facing any issue
  * Start app via IDE (SpringBoot: `com.upesi.upesiauthserver.UpesiAuthServerApplication` or `com.upesi.upesiaccount.UpesiAccountApplication`). [Not Recommended]
* Build and Test
  * `./mvnw clean build`
  * Integration tests will use test containers
* Run
  * via Docker
    * `docker-compose build service-upesi-auth` and `docker-compose build service-upesi-account`

### Coverage

Coverage is implemented using jacoco. To generate the coverage report locally run

```
cd account-management && mvnw test jacocoTestReport
```

### Coverage Verification

```
cd upesi-auth-server && mvnw test jacocoTestReport jacocoTestCoverageVerification
```


#### How to run using Docker Compose

* cd to the root directory of this project (which has the `docker-compose.yaml` file)
* Run ```docker-compose build ```
* Run ```docker-compose up```
* To stop all containers, run ```docker-compose down``` 