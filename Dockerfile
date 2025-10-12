FROM amazoncorretto:21-alpine-jdk
COPY target/test-0.0.1-SNAPSHOT.jar /miapiv2.jar

ENTRYPOINT ["java","-jar","/gmiapiv1.jar"]