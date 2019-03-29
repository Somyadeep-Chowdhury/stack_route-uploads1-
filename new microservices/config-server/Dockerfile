FROM openjdk:11.0-jdk
ADD ./target/config-server-0.0.1-SNAPSHOT.jar /muzix/config-server/config-server-0.0.1-SNAPSHOT.jar
WORKDIR muzix/config-server
EXPOSE 8066
ENTRYPOINT ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]