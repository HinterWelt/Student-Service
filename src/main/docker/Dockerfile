FROM java:8

MAINTAINER Bill Corrie, hinterwelt.com

ADD hintermoodle.jar /app.jar
 
EXPOSE 8080
 
CMD java -Djava.security.egd=file:/dev/./urandom -jar /app.jar
