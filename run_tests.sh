@echo off
cd /d "%~dp0"  REM Change to script directory

REM Set Java and Maven Paths (if not in system PATH)
set JAVA_HOME=C:\Users\user\Desktop\JDKS\jdk-11.0.16
set MAVEN_HOME=C:\Program Files\apache-maven-3.9.0
set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

REM Pull latest changes from GitHub (if not using Jenkins SCM)
git pull origin main

REM Build the project
mvn clean install

REM Run Selenium Tests (Modify as needed)
java -cp target/myproject.jar;lib/* org.testng.TestNG testng.xml

REM Exit with success status
exit /b 0
