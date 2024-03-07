FROM openjdk:latest
VOLUME /tmp
EXPOSE 8080
ARG MONGO_USER 
ADD build/libs/qna-backend-0.0.1.jar qna-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/qna-backend-0.0.1.jar"]
