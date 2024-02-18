pipeline {
    agent any

    stages {
        stage('BUILD') {
            steps {
                echo 'Hello World'
            }
        }
         stage('TEST') {
            steps {
                
             sh'''
                echo 'Hello World' > yogi
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
