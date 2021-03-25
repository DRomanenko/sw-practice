#!/bin/bash

cd "../stage1" || exit
rm -r felix-framework-7.0.0/ 2> /dev/null
tar -xvf org.apache.felix.main.distribution-7.0.0.tar.gz > /dev/null
cd "felix-framework-7.0.0" || exit
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8080 -jar bin/felix.jar

# uninstall 7
# uninstall 8
# install "../../stage3/lib/org.osgi.util.function-1.1.0.jar"
# install "../../stage3/lib/org.osgi.util.promise-1.1.0.jar"
# install "../../stage3/lib/org.apache.felix.scr-2.1.26.jar"
# deploy 9

# install "../../stage3/client/target/client-1.0-SNAPSHOT.jar"
# install "../../stage3/service/target/service-1.0-SNAPSHOT.jar"
# start 7
# start 8
# start 9
# start 15
# start 16
