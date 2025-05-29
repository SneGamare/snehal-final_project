trigger:
  branches:
    include:
      - main
      - develop
      - release/*
      - hotfix/*
      - feature/*
    exclude:
      - none

variables:
  - group: ECR_NonProd
  - name: AWS-ACCESS-KEY-ID
    value: $[variables.AWS_ACCESS_KEY_ID]
  - name: AWS-SECRET-ACCESS-KEY
    value: $[variables.AWS_SECRET_ACCESS_KEY]
  - name: AWS-DEFAULT-REGION
    value: $[variables.AWS_DEFAULT_REGION]
  - name: AWS-ACCOUNT-ID
    value: $[variables.AWS_ACCOUNT_ID]
  - name: DOCKER_REPO_NAME
    value: 'ecr-plutus-dev-nonprod-01'
  - name: DOCKER_REPOSITORY
    value: '$(AWS-ACCOUNT-ID).dkr.ecr.ap-south-1.amazonaws.com/$(DOCKER_REPO_NAME)'
  - name: DOCKER_REPO_TAG
    value: $(Build.BuildId)

resources:
  repositories:
    - repository: templates
      type: git
      name: "Builder Tools/cicd-templates"
      ref: refs/tags/v1.3.6

stages:
  - stage: Checkmarkx
    displayName: Checkmarx Scan
    pool:
      name: private build
    jobs:
      - job:
        displayName:
        steps:
          - task: DownloadSecureFile@1
            inputs:
              secureFile: 'CxSast_root.pem'
          - task: checkmarx.cxsast.cx-scan-task.Application security testing@2024
            displayName: 'Application security testing'
            inputs:
              projectName: '[APP-03146]Plutus - [orchestrator-service]'
              syncMode: false
              CheckmarxService: 'Checkmarx-connection'
              fullTeamName: 'CxServer\APP-03146:Plutus'
              sastCaChainFilePath: '$(Agent.TempDirectory)/CxSast_root.pem'
              comment: 'APP-03146:Plutus:$(Build.Repository.Name):orchestrator-service:$(Build.BuildId)'

  # Build stage
  - template: templates/build-stage/build-java-maven.yaml@templates
    parameters:
      #settingsFile: settings.xml
      jdkVersionOption: '1.21'
      mavenGoals: clean package
      dockerNetwork: host
      filePathOfCodeCoverageHtml: 'target/site/jacoco/index.html'
      dockerImageDetails:
        - dockerFilePath: '$(system.defaultworkingdirectory)'
          dockerRepoName: 'ecr-plutus-dev-nonprod-01'

  # Code Quality stage
  - template: templates/code-quality-stage/scan-java-code.yaml@templates
    parameters:
      sonarsources: .
      manifestsFolder: '/kubernetes'
      featureFilesPath: src/test/resources/feature.acceptance
      CheckmarxServiceConnection: checkmarx-connection
      prismaServiceConnection: default-prisma

  # Test stage
  - template: templates/test-stage/test-java.yaml@templates
    parameters:
      applicationPort: 9090
      relativeUrlsToTest: '/certify'
      manifestFiles: 'kubernetes/deployment-uat.yaml,kubernetes/service.yaml,kubernetes/ingress.yaml'

  # Package stage
  - template: templates/package-stage/package-java.yaml@templates
    parameters:
      dockerImageDetails:
        - dockerFilePath: '$(system.defaultworkingdirectory)'
          dockerRepoName: 'ecr-plutus-dev-nonprod-01'
