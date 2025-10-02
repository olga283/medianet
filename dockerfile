FROM eclipse-temurin:21-jre
WORKDIR /app
COPY medianet-0.0.1-SNAPSHOT.jar medianet.jar
EXPOSE 8084
LABEL authors="fligh"

ENTRYPOINT ["java", "-jar", "medianet.jar"]