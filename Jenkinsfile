pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh 'gradle build'
        jacoco(buildOverBuild: true, deltaBranchCoverage: '0', deltaClassCoverage: '0', deltaComplexityCoverage: '0', deltaInstructionCoverage: '0', deltaLineCoverage: '0', deltaMethodCoverage: '0', classPattern: 'build/classes', execPattern: 'build/jacoco/*.exec', maximumBranchCoverage: '100', maximumClassCoverage: '100', maximumComplexityCoverage: '100', maximumInstructionCoverage: '100', maximumLineCoverage: '100', maximumMethodCoverage: '100', minimumBranchCoverage: '20', minimumClassCoverage: '20', minimumComplexityCoverage: '20', minimumInstructionCoverage: '20', minimumLineCoverage: '20', minimumMethodCoverage: '20', sourceInclusionPattern: 'src/main/java', sourceExclusionPattern: 'src/test')
      }
    }
    stage('Analysis') {
      steps {
        withSonarQubeEnv('sonarqube') {
          sh 'sonar-scanner'
        }

        waitForQualityGate true
      }
    }
    stage('Upload') {
      when { // si la branche production
      branch 'master'
      }
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
