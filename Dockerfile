FROM java:8
VOLUME /tmp
EXPOSE 8081
ADD /build/libs/searchPatient-1.0.0.jar searchPatient-1.0.0.jar
ENTRYPOINT ["java","-jar","searchPatient-1.0.0.jar"]