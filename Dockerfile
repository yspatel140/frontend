FROM openjdk:11

WORKDIR /opt/app

COPY target/frontend*.jar /opt/app/app.jar

ADD docker-entrypoint.sh /opt/app/docker-entrypoint.sh

RUN chmod a+rx /opt/app/docker-entrypoint.sh

ENTRYPOINT ["/opt/app/docker-entrypoint.sh"]