# -------- BUILD STAGE --------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

# -------- RUNTIME STAGE --------
FROM openjdk:21
WORKDIR /app
COPY --from=build /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]