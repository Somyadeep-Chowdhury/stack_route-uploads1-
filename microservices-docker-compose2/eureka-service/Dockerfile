FROM openjdk:11.0-jdk
ADD ./target/eureka-service-0.0.1-SNAPSHOT.jar /muzix/app/eureka-service-0.0.1-SNAPSHOT.jar
WORKDIR muzix/app
ENTRYPOINT ["java", "-jar", "eureka-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 9091