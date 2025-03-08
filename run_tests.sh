#!/bin/bash

# Change to the directory where pom.xml is located
cd "$(dirname "$(find . -name 'run_tests.sh' -print -quit)")"

# Set Java and Maven Paths (if not in system PATH)
export JAVA_HOME=/path/to/jdk-11.0.16
export MAVEN_HOME=/path/to/apache-maven-3.9.0
export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH

# Pull latest changes from GitHub (if not using Jenkins SCM)
git pull origin main

# Build the project using Maven
mvn clean install

# Run Selenium Tests (Modify as needed)
java -cp "target/classes:target/test-classes:lib/*" org.testng.TestNG testng.xml

# Exit with success status
exit 0
