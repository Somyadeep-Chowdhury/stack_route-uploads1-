FROM openjdk:11.0-jdk
ADD ./target/MuzixTrack-0.0.1-SNAPSHOT.jar /muzix/track/MuzixTrack-0.0.1-SNAPSHOT.jar
WORKDIR muzix/track
ENTRYPOINT ["java", "-jar", "MuzixTrack-0.0.1-SNAPSHOT.jar"]