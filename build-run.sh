#!/usr/bin/env bash

mvn clean install
docker build -t maria/readparty:${1} .
docker stop readparty
docker rm readparty
docker run -d --name readparty --net=hackathon -p 8082:8080 maria/readparty:${1}
docker logs readparty -f
