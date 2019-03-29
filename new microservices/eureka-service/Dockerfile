FROM openjdk:11.0-jdk
ADD ./target/eureka-0.0.1-SNAPSHOT.jar /muzix/eureka/eureka-0.0.1-SNAPSHOT.jar
WORKDIR muzix/eureka
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "eureka-0.0.1-SNAPSHOT.jar"]