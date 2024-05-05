FROM openjdk:17
EXPOSE 8084
ADD target/notificationservice-onemorerep.jar notificationservice-onemorerep.jar
ENTRYPOINT ["java","-jar","/notificationservice-onemorerep.jar"]