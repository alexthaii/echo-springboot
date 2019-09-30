pipeline {
  agent any
  stages {
    stage ("Build") {
      tools {
        maven 'M3'
      }
      steps {
        sh 'mn --version'
      }
    }
  }

  post {
    always {
      logstashSend failBuild: false, maxLines: 1000
    }
  }
}
