FROM openjdk:latest
VOLUME /tmp
# ARG MONGO_CONN
ADD build/libs/qna-backend-0.0.1.jar qna-backend-0.0.1.jar
ENTRYPOINT ["java","-jar","/qna-backend-0.0.1.jar"]
