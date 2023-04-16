#!/bin/bash

sudo apt-get update
sudo apt-get install docker.io
sudo docker build -t certificates .
sudo docker run -dp 8081:8081 certificates
sudo docker ps

