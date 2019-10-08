pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Compile') {
            steps {
                withMaven(
                    // Maven installation declared in the Jenkins "Global Tool Configuration"
                    maven: 'maven-3') {
                    // Run the maven build
                    sh "mvn clean verify"
                }
            }
        }

        stage ('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
