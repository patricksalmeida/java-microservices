FROM openjdk:11

VOLUME /tmp

ADD ./target/hr-oauth-1.0.0.jar hr-oauth.jar

ENTRYPOINT ["java","-jar","/hr-oauth.jar"]