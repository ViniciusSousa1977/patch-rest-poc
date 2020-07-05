
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/patch-rest-poc-1.0.0-R1.jar patch-rest-poc.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar patch-rest-poc.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar patch-rest-poc.jar
