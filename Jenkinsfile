def gv
pipeline {
    agent any
    parameters {
        choice(name: 'Version', choices:['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTest', defaultValue: true, description: '')
    }
    stages {
        stage('init') {
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('Build') {
            steps {
                script{
                    gv.buildApp()
                }
            }
        }
        stage('Test') {
            when {
                expression {
                    params.executeTest
                }
            }
            steps {
                script{
                    gv.testApp()
                }
            }
        }
        stage('Deploy') {
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}