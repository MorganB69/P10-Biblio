FROM tomcat:9.0-jre8

ADD server.xml /usr/local/tomcat/conf/
ADD target/${WAR_FILE} /usr/local/tomcat/webapps/

ENV CATALINA_OPTS="-Dkey=value"
ENV LIVRESERVICE=${LIVRESERVICE}
ENV USERSERVICE=${USERSERVICE}
ENV PRETERVICE=${PRETSERVICE}
ENV IDENTIFICATIONSERVICE=${IDENTIFICATIONSERVICE}


CMD ["catalina.sh", "run"] 

