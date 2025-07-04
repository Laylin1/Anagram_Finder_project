FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/anagrams-1.0-SNAPSHOT.jar app.jar

COPY data/ ./data/

ENTRYPOINT ["java", "-jar", "app.jar"]