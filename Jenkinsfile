pipeline {
    agent any
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
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
                sh 'mvn compile'
            }
        }

        stage ('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
