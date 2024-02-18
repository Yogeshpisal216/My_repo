pipeline {
    agent { 
        label 'My_node' 
        }
    stages {
        stage('git commit') {
            steps {
                echo 'welcome to my pipeline'
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
                 sudo apt install awscli -y
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
                aws s3 cp s3://s3-bucket-for-ec2-nginx/studentapp-2.2-SNAPSHOT.war ./apache-tomcat-8.5.98/webapps/student.war
                sh /home/ubuntu/workspace/Yogi/apache-tomcat-8.5.98/bin/catalina.sh start
                '''
                }
        }
        
    }
}                
