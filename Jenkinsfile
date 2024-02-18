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
                echo 'Hello World' > file1.txt
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
