pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'gradle build'
        jacoco(buildOverBuild: true, deltaBranchCoverage: '1', deltaClassCoverage: '1', deltaComplexityCoverage: '1', deltaInstructionCoverage: '1', deltaLineCoverage: '1', deltaMethodCoverage: '1', classPattern: 'build/classes', execPattern: 'build/jacoco/*.exec', maximumBranchCoverage: '100', maximumClassCoverage: '100', maximumComplexityCoverage: '100', maximumInstructionCoverage: '100', maximumLineCoverage: '100', maximumMethodCoverage: '100', minimumBranchCoverage: '80', minimumClassCoverage: '80', minimumComplexityCoverage: '80', minimumInstructionCoverage: '80', minimumLineCoverage: '80', minimumMethodCoverage: '80', sourceInclusionPattern: 'src/main/java', sourceExclusionPattern: 'src/test')
      }
    }
    stage('Analysis') {
      environment {
        scannerHome = 'SonarQubeScanner'
      }
      steps {
        withSonarQubeEnv('sonarqube') {
          sh "${scannerHome}/bin/sonar-scanner"
        }

        waitForQualityGate true
      }
    }
    stage('Upload') {
      steps {
        archiveArtifacts 'build/libs/*.jar'
      }
    }
  }
  post {
    always {
      echo 'Build stage complete'

    }

    failure {
      echo 'Build failed'
      mail(subject: 'Buil faild', body: 'Build faild', bcc: 'h_mokeddem@esi.dz')

    }

    success {
      echo 'Build succeeded'
      mail(subject: 'Buil Sucess', body: 'Build sucess', bcc: 'h_mokeddem@esi.dz')

    }

  }
}