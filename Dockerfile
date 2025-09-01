FROM openjdk:21
MAINTAINER Dmitry Kononov
WORKDIR /opt
EXPOSE 8080
EXPOSE 61616
COPY target/ ./
ENTRYPOINT ["java", "-jar", "magaz-pet-app-1.0.0.jar"]