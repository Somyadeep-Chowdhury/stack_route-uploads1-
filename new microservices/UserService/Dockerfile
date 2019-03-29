FROM openjdk:11.0-jdk
ADD ./target/MuzixUser-0.0.1-SNAPSHOT.jar /muzix/user/MuzixUser-0.0.1-SNAPSHOT.jar
WORKDIR muzix/user
ENTRYPOINT ["java", "-jar", "MuzixUser-0.0.1-SNAPSHOT.jar"]

