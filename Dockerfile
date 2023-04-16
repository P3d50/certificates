FROM maven:3.8.4-jdk-11
WORKDIR /certificates
COPY pom.xml .
COPY src/ ./src/
RUN mvn clean install
ENTRYPOINT ["mvn", "spring-boot:run"]

