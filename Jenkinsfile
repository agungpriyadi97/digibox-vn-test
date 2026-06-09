pipeline {

    agent any

    environment {
        KATALON_API_KEY = credentials('katalon-api-key')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/USERNAME/digibox-vn-test.git'
            }
        }

        stage('Run Regression') {
            steps {

                bat '''
                "C:\\Users\\AgungPriyadi\\.katalon\\packages\\KS-11.1.3\\katalonc.exe" ^
                -noSplash ^
                -runMode=console ^
                -projectPath="%WORKSPACE%\\digibox-vn.prj" ^
                -retry=0 ^
                -apiKey="%KATALON_API_KEY%" ^
                -testSuiteCollectionPath="Test Suites/WEB/Web_Test_Suite_Collection/Regression_Digiboxvn_Web" ^
                -browserType="Chrome (headless)"
                '''
            }
        }
    }

    post {

        always {

            archiveArtifacts artifacts: 'Reports/**/*', fingerprint: true

        }

        success {
            echo 'Automation Success'
        }

        failure {
            echo 'Automation Failed'
        }
    }
}
