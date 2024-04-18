FROM amazoncorretto:17-alpine
RUN mkdir /app
COPY auth-container/target/auth-container-0.0.1-SNAPSHOT.jar /app/auth-container-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "auth-container-0.0.1-SNAPSHOT.jar"]
