FROM java:8
VOLUME /tmp
ADD target/demo-0.0.1-SNAPSHOT.jar movie.jar
RUN bash -c 'touch /movie.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/movie.jar"]
