FROM openjdk:17
COPY target/email-microservice*.jar /usr/src/email-microservice.jar
COPY  src/main/resources/application.properties /opt/conf/application.properties
CMD ["java", "-jar", "/usr/src/email-microservice.jar", "--spring.config.location=file:/opt/conf/application.properties"]