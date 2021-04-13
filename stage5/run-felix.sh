#!/bin/bash

cd "../stage1" || exit
rm -r felix-framework-7.0.0/ 2> /dev/null
tar -xvf org.apache.felix.main.distribution-7.0.0.tar.gz > /dev/null
cd "felix-framework-7.0.0" || exit
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8080 -jar bin/felix.jar

:<<console
install "../../stage5/lib/org.apache.felix.scr-2.1.26.jar"
deploy 7
install "../../stage5/lib/org.osgi.util.function-1.1.0.jar"
start 13
install "../../stage5/lib/org.osgi.util.promise-1.1.0.jar"
start 14
install "../../stage5/lib/gson-2.8.6.jar"
start 15
start 7
install "../../stage5/base-service/target/base-service-1.0-SNAPSHOT.jar"
start 16
install "../../stage5/lenta-service/target/lenta-service-1.0-SNAPSHOT.jar"
start 17
install "../../stage5/aif-service/target/aif-service-1.0-SNAPSHOT.jar"
start 18
install "../../stage5/meduza-service/target/meduza-service-1.0-SNAPSHOT.jar"
start 19
install "../../stage5/command-service/target/command-service-1.0-SNAPSHOT.jar"
start 20
news:stats
news:stats lenta
news:stats aif
news:stats meduza
news:stats all
console