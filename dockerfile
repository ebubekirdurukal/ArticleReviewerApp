From openjdk:8
copy ./target/ArticleReviewer-0.1.jar ArticleReviewer-0.1.jar
CMD ["java","-jar","ArticleReviewer-0.1.jar"]
