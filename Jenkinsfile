pipeline {
    agent any

    stages {
        stage('BUILD') {
            steps {
                echo 'pipeline is created'
            }
        }
         stage('TEST') {
            steps {
                
             sh'''
                echo 'Hello World' > yogi.txt
             '''
            }
        }
         stage('DEPLOY') {
            steps {
              sh '''
                echo 'Hello World' > file
             '''
            }
        }
    }
}
