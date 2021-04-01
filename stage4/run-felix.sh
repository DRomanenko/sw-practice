#!/bin/bash

# mvn clean install

cd "../stage1" || exit
rm -r felix-framework-7.0.0/ 2> /dev/null
tar -xvf org.apache.felix.main.distribution-7.0.0.tar.gz > /dev/null
cd "felix-framework-7.0.0" || exit
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8090 -jar bin/felix.jar

# install "../../stage4/target/stage4-1.0-SNAPSHOT.jar"
# start 7
# practice:hello Demian

