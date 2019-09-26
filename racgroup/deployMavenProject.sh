#!/bin/bash

project_home=/Users/junhexiao/Documents/projects/racgroup/springframework
tomcat_home=/Users/junhexiao/Documents/projects/apache-tomcat-8.5.32


## step 1
date; 
cd $project_home
rm -f target/*.war
time mvn -Dmaven.test.skip -U clean package


## step 2
date; cd $tomcat_home/webapps
rm -rf springframework-1.0-SNAPSHOT*;
sleep 10; 

## step 3
date; cp $project_home/target/*.war $tomcat_home/webapps

## step 4
echo "";
echo "";


## step 5
date; tail -f $tomcat_home/logs/catalina.out

## step 6
