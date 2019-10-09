pipeline {
    agent any
    stages {
        stage ('Compile') {
            steps {
                withMaven(
                    // Maven installation declared in the Jenkins "Global Tool Configuration"
                    maven: 'maven-3') {
                    // Run the maven build
                    sh "mvn -DskipTests -Dgpg.skip clean install"
                }
            }
        }
    }
}
