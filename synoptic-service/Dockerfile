FROM java:8

MAINTAINER Vincent BALLADA <vballada@gmail.com>

ADD ./target/synoptic-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/synoptic-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 1111-9999