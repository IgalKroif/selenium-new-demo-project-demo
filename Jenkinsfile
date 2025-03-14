pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/IgalKroif/selenium-new-demo-project-demo.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'java -cp "target/classes;target/test-classes;lib/*" org.testng.TestNG testng.xml'
            }
        }

        stage('Archive Test Results') {
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        success {
            echo "Build and tests completed successfully!"
        }
        failure {
            echo "Build or tests failed. Check logs for details."
        }
    }
}
