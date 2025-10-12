FROM amazoncorretto:21-alpine-jdk
COPY target/TallerDespliegue-0.0.1-SNAPSHOT.jar /miapiv2.jar

ENTRYPOINT ["java","-jar","/miapiv2.jar"]
