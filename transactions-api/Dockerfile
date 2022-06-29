FROM maven:3.6.3-jdk-11-openj9 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11
MAINTAINER gumoises@live.com
COPY --from=build /usr/src/app/target/transactions-api-0.0.1-SNAPSHOT.jar usr/app/transactions-api.jar
ENTRYPOINT ["java", "-jar","/usr/app/transactions-api.jar"]