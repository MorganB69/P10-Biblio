FROM tomcat:9.0-jre8

ADD server.xml /usr/local/tomcat/conf/
ADD target/${WAR_FILE} /usr/local/tomcat/webapps/

ENV CATALINA_OPTS="-Dkey=value"
ENV DB=${DB}
ENV DATASOURCEURL=${DATASOURCEURL}
ENV USERNAME=${USERNAME}
ENV PASSWORD=${PASSWORD}

ENV USERNAMEMAIL=${USERNAMEMAIL}
ENV PASSWORDMAIL=${PASSWORDMAIL}

CMD ["catalina.sh", "run"] 

