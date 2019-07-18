node {

    stage("Checkout Repository"){
        git branch: 'master',
        credentialsId: 'aaf288ba-44cb-4133-b59e-ca5b1c04dede',
        url: 'https://github.com/dissid/luma_magento'
    }
    stage("build"){
        sh "./gradlew clean luma_magento_api:assemble"
    }

    stage("run api tests"){
        sh "./gradlew luma_magento_api:test"
    }

    stage("run ui tests"){
            sh "./gradlew luma_magento_ui:test"
        }
    stage('Reports') {
        steps {
        script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'luma_magento_api/build/allure-results']]
                ])
        }
        }
    }

}