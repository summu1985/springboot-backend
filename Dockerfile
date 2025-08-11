FROM registry.access.redhat.com/ubi8/openjdk-17
WORKDIR /opt/app
USER root
COPY target/demo-0.0.1-SNAPSHOT.jar .
RUN chown -R 1001:0 /opt/app \
&& chmod -R g=u /opt/app
USER 1001
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/demo-0.0.1-SNAPSHOT.jar"]