# Start with a base image containing Java runtime
FROM bwalker1020/ubuntu-jdk11

# Add Author info
LABEL maintainer="kbjn1649@gmail.com"

# Add a volume to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 4002

# The application's jar file
ARG JAR_FILE=build/libs/product_service-0.0.1-SNAPSHOT.jar
# Add the application's jar to the container
ADD ${JAR_FILE} to-do-springboot.jar

RUN java -Djava.security.egd=file:/dev/./urandom -jar /to-do-springboot.jar
