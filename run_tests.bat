@echo off
echo Starting the Selenium Project Build...

REM Set Java and Maven paths (if not set globally)
set JAVA_HOME=C:\Program Files\Java\jdk-17
set MAVEN_HOME=C:\Apache Maven\apache-maven-3.9.2
set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

REM Change to the project directory (adjust if needed)
cd /D "%~dp0"

REM Print Java and Maven versions for debugging
java -version
mvn -version

REM Clean and Build the project using Maven
echo Running Maven build...
mvn clean install
if errorlevel 1 (
    echo Maven build failed! Exiting...
    exit /b 1
)

REM Run Selenium Tests using TestNG (Ensure testng.xml is correct)
echo Running Selenium Tests...
mvn test -Dsurefire.suiteXmlFiles=project-root/testng.xml
if errorlevel 1 (
    echo Selenium tests failed!
    exit /b 1
)

echo Build and tests completed successfully!
exit /b 0
