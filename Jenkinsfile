pipeline {
    agent any

    stages {
        stage('checkout') {
            steps{
                git branch:'main', url: 'https://github.com/VanesssaJND/ContinousIntegration.git'
            }
        }
        stage('Build') {
            steps {
                dir('integracion-continua'){
                    bat 'mvn.cmd clean install -DskipTests'
                }
            }
        }
        stage('deploy'){
            steps{
                bat 'docker-compose --version'
                dir('integracion-continua'){
                    bat 'docker build -t my-app:v1 .'
                   bat 'docker-compose up -d'
                }
            }
        }
    }
    post{
        success {
            emailext ( subject: "Éxito en la construcción: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
            body: """<p>El trabajo ${env.JOB_NAME} [${env.BUILD_NUMBER}] se ha completado con éxito.</p>""",
            to: 'corsamps@gmail.com', 'otrocorreo@ejemplo.com' )
        }
        failure {
            emailext ( subject: "Error en la construcción: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
            body: """<p>El trabajo ${env.JOB_NAME} [${env.BUILD_NUMBER}] ha fallado.</p>""",
            to: 'corsamps@gmail.com' )
        }
    }
}