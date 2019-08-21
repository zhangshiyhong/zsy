FROM centos
MAINTAINER chenqiming@ygsoft.com

ADD jdk-8u144-linux-x64.tar.gz /
COPY necp.mapp.collecitoninfo.boot/target/necp.mapp.collecitoninfo.boot-1.0.0.jar /


RUN mv /etc/localtime /etc/localtime.bak && ln -s /usr/share/zoneinfo/Asia/Shanghai /etc/localtime 

CMD ["/jdk1.8.0_144/bin/java", "-jar", "-Dserver.port=8080", "necp.collecitoninfo.boot-1.0.0.jar"]