FROM maven:3.9.8-amazoncorretto-21 AS build
LABEL authors="vdavdov"
COPY src /spring-todo-list/src
COPY pom.xml /ToDoList
RUN mvn -f /spring-todo-list/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-todo-list/target/spring-todo-list-0.0.1-SNAPSHOT.jar"]

ENTRYPOINT ["top", "-b"]