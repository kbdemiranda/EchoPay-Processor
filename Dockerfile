FROM maven:3.9.5-amazoncorretto-21 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM amazoncorretto:21.0.5
WORKDIR /app
COPY --from=build /app/target/processor-0.0.1-SNAPSHOT.jar /app/processor.jar

EXPOSE 8081

LABEL authors="kbdemiranda"

ENTRYPOINT ["java", "-jar", "/app/echopay.jar"]
