FROM openjdk:11.0-jdk
ADD ./target/zuul-service-0.0.1-SNAPSHOT.jar /muzix/zuul/zuul-service-0.0.1-SNAPSHOT.jar
WORKDIR muzix/zuul
ENTRYPOINT ["java", "-jar", "zuul-service-0.0.1-SNAPSHOT.jar"]