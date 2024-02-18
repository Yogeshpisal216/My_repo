pipeline {
    agent {
        label node_1
    }
    stages {
        stage('git commit') {
            steps {
                echo 'welcome'
                git 'https://github.com/Yogeshpisal216/yogi.git'
                  }
             }
        stage('maven package'){
            steps{
                sh '''
                echo "Install maven package"
                sudo apt update
                sudo apt install maven -y
                sudo mvn clean
                sudo mvn package
                '''
            }
        }
        stage('artifacts') {
            steps {
                sh '''
                 echo 'added artifacts in bucket'
                 sudo update 
                 sudo apt install 
                 aws s3 cp target/*.war s3://s3-bucket-for-ec2-nginx
                '''
                 }
             }
             stage('tomccat'){
                steps{
                    sh '''
                    echo "install apache tomcate"
                    sudo apt update
                    sudo apt install unzip -y
                    wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.98/bin/apache-tomcat-8.5.98.tar.gz
                    tar -xzvf apache-tomcat-8.5.98.tar.gz
                    '''
                }
             }
          stage('adding'){
            steps{
                sh '''
                echo "data add into webapps"
                cp s3://s3-bucket-for-ec2-nginx./target/*.war ./apache-tomcat-8.5.98/webapps/student.war
                sh apache-tomcat-8.5.98/bin/catalina.sh start
                '''
                }
        }
        
    }
}
