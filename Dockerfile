## Build image
FROM maven:3.9.4-amazoncorretto-21 AS maven
WORKDIR /tmp/build
COPY ./pom.xml ./
RUN mvn dependency:go-offline
COPY . ./
RUN mvn package -DskipTests

## Run image
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=maven /tmp/build/target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
