FROM dockerhub.3g.fang.com/base/jdk/jdk8u202-pinpoint1.8.1:v1
MAINTAINER jiangxiangji <jiangxiangji@fang.com>
VOLUME /tmp
COPY myinterapi/target/myinterapi-0.0.1-SNAPSHOT.jar  app.jar
EXPOSE 8080
ENV JAVA_OPTS="\
-server \
-Xmx2g \
-Xms2g \
-Xmn1500M \
-XX:MetaspaceSize=200m \
-XX:MaxMetaspaceSize=200m"
ENTRYPOINT java  ${JAVA_OPTS}  -javaagent:/www/webdev/pinpoint-agent-1.8.1/pinpoint-bootstrap-1.8.1.jar -Dpinpoint.agentId=myfang-myinterapi-${podId##*-}  -Dpinpoint.applicationName=kg-myfang-myinterapi -jar app.jar
