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
                bash '''
                echo 'Hello World' > file1.txt
                '''
            }
        }
         stage('DEPLOY') {
            steps {
                bash'''
                echo 'Hello World' > file
                '''
            }
        }
    }
}
