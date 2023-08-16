# Add maven as part of the docker image to build project
FROM maven:3.8.7-openjdk-18-slim AS build
RUN mkdir -p /var/log/
RUN chmod a+rwx -R /var/log/
COPY upesi-auth-server/src /usr/src/app/src
COPY upesi-auth-server/pom.xml /usr/src/app
RUN --mount=type=cache,target=/root/.m2,rw mvn dependency:go-offline -f /usr/src/app/pom.xml -Dmaven.test.skip clean package

# Create the run target service
FROM openjdk:17.0.1-jdk-slim
MAINTAINER joealexkimani
COPY --from=build /usr/src/app/target/upesi-auth-server-1.0.0.jar /usr/app/upesi-auth-server.jar
ENTRYPOINT ["java","-jar","/usr/app/upesi-auth-server.jar"]