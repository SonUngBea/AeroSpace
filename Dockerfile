From tomcat:8-jre8
ADD ./interfaces/build/libs/interfaces-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080