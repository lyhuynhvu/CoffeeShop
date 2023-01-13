FROM openjdk:8
COPY ./src/GUI/ /app
WORKDIR /app
CMD ["java","Login"]