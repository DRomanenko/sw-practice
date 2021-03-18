#!/bin/bash

MANIFEST_ROOT="../src/main/java/"
SERVICE_ROOT="service/"
CLIENT_ROOT="client/"

cd "../stage1" || exit
rm -r felix-framework-7.0.0/ 2> /dev/null
tar -xvf org.apache.felix.main.distribution-7.0.0.tar.gz > /dev/null
cd "../stage2/target" || exit
cp -ur "$(pwd)/classes/service" "$(pwd)"
cp -ur "$(pwd)/classes/client" "$(pwd)"
jar --create --file HelloService.jar --manifest "$MANIFEST_ROOT"ServiceManifest.mf \
  "$SERVICE_ROOT"Hello.class "$SERVICE_ROOT"HelloImpl.class "$SERVICE_ROOT"HelloService.class
jar --create --file HelloClient.jar --manifest "$MANIFEST_ROOT"ClientManifest.mf \
  "$CLIENT_ROOT"HelloClient.class