FROM openjdk:11.0-jdk

ADD ./target/muzixApplicationTask1-0.0.1-SNAPSHOT.jar /muzix/app/muzixApplicationTask1-0.0.1-SNAPSHOT.jar

WORKDIR muzix/app

ENTRYPOINT ["java", "-jar", "muzixApplicationTask1-0.0.1-SNAPSHOT.jar"]