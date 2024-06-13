
# Start with a base image containing Java runtime (Here we are using OpenJDK)
FROM openjdk:8-jdk-alpine
# Add Maintainer Info
LABEL maintainer="guilherme.soffa@example.com"

# Add a volume pointing to /tmp

VOLUME /tmp

# Make port 8080 available to the world outside this container

EXPOSE 8080

# The application's jar file

ARG JAR_FILE=target/my-app-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container

# Run the jar file
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

This Dockerfile assumes that your application is packaged as a jar and that the jar file is located in the target directory with a name of 'my-app-0.0.1-SNAPSHOT.jar'.

For
For the database connection, you would typically use environment variables to pass the database connection details to your application. These can be set in the Docker run command with the -e option. For example:

```bash
Here's an example of how you might set these in a docker-compose file:

```yaml
version: '3'
services:
  my-app:
    image: my-app:latest
    ports:
      - 8080:8080
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/mydatabase
docker run -e SPRING_DATASOURCE_URL=jdbc:mysql://your-database-url -e SPRING_DATASOURCE_USERNAME=your-username -e SPRING_DATASOURCE_PASSWORD=your-password -p 8080:8080 -t your-image-name
      - SPRING_DATASOURCE_USERNAME=myuser