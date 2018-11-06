FROM tomcat:9.0-jre8

ADD server.xml /usr/local/tomcat/conf/
ADD target/${WAR_FILE} /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"] 

