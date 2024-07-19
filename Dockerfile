
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM openjdk:8

WORKDIR /app

COPY ./target/helpmeiud-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8084

CMD ["java","-Dspring.profiles.active=default","-jar", "app.jar"]
