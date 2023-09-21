# Args
ARG MAVEN_VERSION=3.6.3-jdk-11
ARG JRE_VERSION=11.0.17_8-jre-alpine

## Stage 1 : build package
FROM maven:${MAVEN_VERSION} AS builder
LABEL maintainer="Sergio Talens-Oliag <sto@kyso.io>"
WORKDIR /build
COPY . ./
RUN mvn package

## Stage 2 : create the jre image
FROM eclipse-temurin:$JRE_VERSION
LABEL maintainer="Sergio Talens-Oliag <sto@kyso.io>"
COPY --from=builder /build/target/gcr-imagebox-2.0.0.jar /opt/app/
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/gcr-imagebox-2.0.0.jar"]
