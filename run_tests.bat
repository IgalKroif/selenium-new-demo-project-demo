@echo off
echo Starting the Selenium Project Build...

REM Change to the directory where this script is located
cd /D "%~dp0"

REM Set Java and Maven Paths (If needed, otherwise remove these lines)
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.16
set MAVEN_HOME=C:\apache-maven-3.9.0
set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

REM Check if Java and Maven exist
java -version
if errorlevel 1 echo Java not found! & exit /b 1

mvn -version
if errorlevel 1 echo Maven not found! & exit /b 1

REM Pull latest changes from GitHub (Optional, if not using Jenkins SCM)
echo Pulling latest changes from GitHub...
git pull origin main
if errorlevel 1 echo Git pull failed! & exit /b 1

REM Build the project using Maven
echo Building the project with Maven...
mvn clean install
if errorlevel 1 echo Maven build failed! & exit /b 1

REM Run Selenium Tests
echo Running Selenium Tests...
java -cp "target\classes;target\test-classes;lib\*" org.testng.TestNG testng.xml
if errorlevel 1 echo Selenium tests failed! & exit /b 1

echo Build and tests completed successfully!
exit /b 0
