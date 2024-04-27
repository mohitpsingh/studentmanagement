FROM openjdk:21

COPY target/employee_docker_app.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "employee_docker_app.jar"]