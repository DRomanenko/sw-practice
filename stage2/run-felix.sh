#!/bin/bash

cd "../stage1/felix-framework-7.0.0" || exit
java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8080 -jar bin/felix.jar

# uninstall 7
# uninstall 8
# install "../../stage2/target/HelloService.jar"
# start 7
# install "../../stage2/target/HelloClient.jar"
# start 8
