def gv
CODE_CHANGES = getGitChanges()
pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    parameters {
        choice(name: 'Version', choices:['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTest', defaultValue: true, description: '')
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn --version'
            }
        }
        stage('Test') {
            when {
                expression {
                    params.executeTest
                }
            }
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                echo "deploying version ${params.VERSION}"
            }
        }
    }
}
