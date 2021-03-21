FROM openjdk:11

VOLUME /tmp

EXPOSE 8765

ADD ./target/hr-zuul-api-gateway-1.0.0.jar hr-api-gateway-zuul.jar

ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]