pipeline {

    agent any

    options {
        timeout(time: 12, unit: 'HOURS')
    }

    triggers {
        // Setiap hari Jumat jam 08:00
        cron('0 8 * * 5')
    }

    parameters {
        string(
            name: 'TEST_PATH',
            defaultValue: '',
            description: 'Kosongkan untuk Regression default'
        )
    }

    environment {
        KATALON_API_KEY = credentials('katalon-api-key')
        KATALON_EXE = 'C:\\Users\\AgungPriyadi\\.katalon\\packages\\KS-11.1.3\\katalonc.exe'
    }

    stages {

        stage('Prepare') {
            steps {
                script {

                    bat '''
                    if exist Reports rmdir /s /q Reports
                    if exist Screenshot rmdir /s /q Screenshot
                    '''

                    if (params.TEST_PATH?.trim()) {
                        env.FINAL_PATH = params.TEST_PATH.split('=')[1]
                        env.ARG_TYPE = params.TEST_PATH.split('=')[0]
                    } else {
                        env.FINAL_PATH = 'Test Suites/WEB/Web_Test_Suite_Collection/Regression_Digiboxvn_Web'
                        env.ARG_TYPE = '-testSuiteCollectionPath'
                    }

                    echo "ARG_TYPE = ${env.ARG_TYPE}"
                    echo "FINAL_PATH = ${env.FINAL_PATH}"
                }
            }
        }

        stage('Chrome Headless') {
            steps {

                catchError(buildResult: 'SUCCESS',
                           stageResult: 'UNSTABLE') {

                    bat """
                    "%KATALON_EXE%" ^
                    -noSplash ^
                    -runMode=console ^
                    -projectPath="%WORKSPACE%\\digibox-vn.prj" ^
                    -retry=0 ^
                    -apiKey="%KATALON_API_KEY%" ^
                    ${env.ARG_TYPE}="${env.FINAL_PATH}" ^
                    -browserType="Chrome (headless)" ^
                    -reportFolder="Reports\\Chrome_Reports" ^
                    -reportFileName="Chrome_Report" ^
                    --config ^
                    -webui.autoUpdateDrivers=true ^
                    -webui.chrome.args="--disable-blink-features=AutomationControlled --no-sandbox --disable-dev-shm-usage --disable-gpu --window-size=1920,1080"
                    """
                }
            }
        }

        stage('Firefox Headless') {
            steps {

                bat """
                "%KATALON_EXE%" ^
                -noSplash ^
                -runMode=console ^
                -projectPath="%WORKSPACE%\\digibox-vn.prj" ^
                -retry=0 ^
                -apiKey="%KATALON_API_KEY%" ^
                ${env.ARG_TYPE}="${env.FINAL_PATH}" ^
                -browserType="Firefox (headless)" ^
                -reportFolder="Reports\\Firefox_Reports" ^
                -reportFileName="Firefox_Report" ^
                --config ^
                -webui.autoUpdateDrivers=true
                """
            }
        }
    }

    post {

        always {

            archiveArtifacts(
                artifacts: '''
                    Reports/**,
                    Screenshot/**,
                    failure_*.html
                ''',
                allowEmptyArchive: true
            )

            junit(
                allowEmptyResults: true,
                testResults: 'Reports/**/*.xml'
            )
        }

        success {
            echo 'Automation SUCCESS'
        }

        unstable {
            echo 'Chrome gagal, tetapi pipeline tetap lanjut'
        }

        failure {
            echo 'Automation FAILED'
        }
    }
}
