FROM openjdk:11-jre-slim
EXPOSE 8080
ADD target/EmployeeManagementSystem_9_8_2022-0.0.1-SNAPSHOT.jar EmployeeManagementSystem_9_8_2022-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/EmployeeManagementSystem_9_8_2022-0.0.1-SNAPSHOT.jar"]