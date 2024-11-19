pipeline {
    agent any

    stages {
        stage('Build del proyecto') {
            steps {
                dir('integracion-continua'){
                    bat 'mvn.cmd clean install -DskipTests'
                }
            }
        }
        stage('Ejecucion de test del proyecto'){
            steps{
             echo 'Test no disponibles debido a que la app no cuenta con ellos'
            }
        }
        stage('Proceso de deploy'){
            steps{
                bat 'docker-compose --version'
                dir('integracion-continua'){
                    bat 'docker build -t my-app:v1 .'
                   bat 'docker-compose up -d'
                }
            }
        }
    }
    post {
        success {
            emailext(
                subject: "Éxito en la construcción: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                body: """<p>El trabajo ${env.JOB_NAME} [${env.BUILD_NUMBER}] se ha completado con éxito.</p>""",
                to: 'tu-correo@dominio.com'
            )
        }
        failure {
            emailext(
                subject: "Error en la construcción: ${env.JOB_NAME} [${env.BUILD_NUMBER}]",
                body: """<p>El trabajo ${env.JOB_NAME} [${env.BUILD_NUMBER}] ha fallado.</p>""",
                to: 'tu-correo@dominio.com'
            )
        }
    }
}