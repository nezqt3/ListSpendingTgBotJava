FROM openjdk:21-slim as build

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package && ls -l /app/target

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "target/hexletJavaBot-1.0-SNAPSHOT.jar"]
