pipeline {
    agent any

    environment {
        APP_NAME = 'Eco_Api'
        REPO_URL = 'https://github.com/MariaOyola/Eco_Api.git'
    }

    tools {
        maven 'Maven'
        jdk 'JDK17'
    }

    stages {

        stage('1 - Clonar Repositorio') {
            steps {
                echo ' Clonando repositorio desde GitHub...'
                checkout scm
            }
        }

        stage('2 - Instalar Dependencias') {
            steps {
                echo ' Descargando dependencias Maven...'
                sh 'mvn dependency:resolve'
            }
        }

        stage('3 - Compilar Proyecto') {
            steps {
                echo ' Compilando el proyecto Spring Boot...'
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('4 - Ejecutar Pruebas Unitarias') {
            steps {
                echo ' Ejecutando pruebas unitarias...'
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
                failure {
                    echo ' Pruebas fallidas - Build FAILED'
                }
            }
        }

        stage('5 - Validar Calidad del Código') {
            steps {
                echo ' Validando calidad del código...'
                sh 'mvn checkstyle:check || true'
            }
        }

        stage('6 - Empaquetar Aplicación') {
            steps {
                echo ' Generando artefacto .jar...'
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }

        stage('7 - Despliegue Simulado') {
            when {
                anyOf {
                    branch 'main'
                    branch 'develop'
                }
            }
            steps {
                echo ' Desplegando aplicación...'
                echo " Branch actual: ${env.BRANCH_NAME}"
                echo " Build número: ${env.BUILD_NUMBER}"
                echo ' Despliegue completado exitosamente'
            }
        }
    }

    post {
        success {
            echo ' BUILD SUCCESS - Pipeline completado sin errores'
        }
        failure {
            echo ' BUILD FAILED - Revisa los logs arriba'
        }
        unstable {
            echo ' BUILD UNSTABLE - Hay advertencias o pruebas con problemas'
        }
        always {
            echo " Estado final: ${currentBuild.result ?: 'SUCCESS'}"
            cleanWs()
        }
    }
}