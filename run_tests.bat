@echo off

REM Change to the directory where pom.xml is located
REM This assumes the .bat file is in a location relative to the project root.
REM Adjust the 'cd' command if your .bat file is in a different location.
REM For example, if the .bat file is at the root level, you might not need this.
cd /D "%~dp0.."
if errorlevel 1 echo Failed to change directory. & exit /b 1

REM Set Java and Maven Paths (if not in system PATH)
REM Adjust these paths to your actual Java and Maven installation directories
set JAVA_HOME=C:\Program Files\Java\jdk-11.0.16
if not exist "%JAVA_HOME%\bin\java.exe" echo Warning: JAVA_HOME not found at specified path.
set MAVEN_HOME=C:\apache-maven-3.9.0
if not exist "%MAVEN_HOME%\bin\mvn.cmd" echo Warning: MAVEN_HOME not found at specified path.
set PATH=%JAVA_HOME%\bin;%MAVEN_HOME%\bin;%PATH%

REM Pull latest changes from GitHub (if not using Jenkins SCM)
echo Pulling latest changes from GitHub...
git pull origin main
if errorlevel 1 echo Failed to pull changes from Git. & exit /b 1

REM Build the project using Maven
echo Building the project with Maven...
mvn clean install
if errorlevel 1 echo Maven build failed. & exit /b 1

REM Ensure chromedriver has execute permissions
REM Windows handles file permissions differently.
REM You might need to ensure the chromedriver is accessible and not blocked by any security measures.
REM This step might not have a direct equivalent in Windows.

REM Run Selenium Tests (Modify paths as needed)
echo Running Selenium Tests...
java -cp "target\classes;target\test-classes;lib\*" org.testng.TestNG testng.xml
if errorlevel 1 echo Selenium tests failed. & exit /b 1

REM Exit with success status
exit 0