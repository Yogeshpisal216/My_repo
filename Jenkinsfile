pipeline {
    agent any

    stages {
        stage('BUILD') {
            steps {
                echo 'pipeline is created'
                git 'https://github.com/Yogeshpisal216/yogi.git'
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
