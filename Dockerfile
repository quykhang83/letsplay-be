# FROM quay.io/wildfly/wildfly
FROM jboss/wildfly:24.0.0.Final

# Set the WILDFLY_VERSION env variable
ENV JBOSS_HOME /opt/jboss/wildfly

USER root

#Tell Wildfly to use our configuration over theirs
COPY module.xml $JBOSS_HOME/modules/system/layers/base/org/postgresql/main/
COPY standalone.xml $JBOSS_HOME/standalone/configuration/

COPY src/main/resources/log4j2.xml $JBOSS_HOME/standalone/configuration/
COPY postgresql-42.5.0.jar $JBOSS_HOME/modules/system/layers/base/org/postgresql/main/

# RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/
# RUN rm -rf $JBOSS_HOME/standalone/log/*
RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/ $JBOSS_HOME/standalone/log/*
    # rm -rf $JBOSS_HOME/modules/system/layers/base/org/postgresql/main/postgresql-42.5.0.jar
# Expose the ports in which we're interested
EXPOSE 8080/tcp 9990/tcp 5432/tcp 8787/tcp

COPY target/*.war $JBOSS_HOME/standalone/deployments/
COPY serviceAccountKey.json $JBOSS_HOME/standalone/configuration/

# Set the default command to run on boot
# This will boot WildFly in standalone mode and bind to all interfaces
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
# RUN docker run --name=horizon5132/approve-me-be -d -v ~/dockerlogs:/wildfly/standalone/log -p 5000:80 docker
# ENTRYPOINT ["java","-jar","testapi.war"]