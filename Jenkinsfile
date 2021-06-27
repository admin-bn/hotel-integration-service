#!/usr/bin/env groovy

node {
    def customImage
    def registryCredential
    def registry
    def image_tag
    def image_Name = '/hotel-integration-service'

    stage('Checkout repository') {
       echo "#------------------- Checkout Develop Branch -------------------#"
       checkout scm

       echo "#------------------- load environment variable -------------------#"

       load "${env.WORKSPACE}" + "/.env"
       echo "${env.CURRENT_BRANCH_NAME}"
       echo "${env.VERSION_TAG}"
       echo "${env.REGISTRY_PREFIX}" + ""

       image_tag ="${env.VERSION_TAG}"
       registryCredential = "${env.REGISTRY_CREDENTIAL}"
       registry = "${env.REGISTRY_PREFIX}" + image_Name

       echo "#------------------- environment variable loaded-------------------#"
    }

    stage('Build image') {
      echo "#------------------- Build Docker Image-------------------#"

        customImage = docker.build(registry)

      echo "#------------------- Image Build Complete -------------------#"
    }

    stage('Push image to custom Registry') {
     echo "#------------------- Push Image -------------------#"

       docker.withRegistry('https://de.icr.io', registryCredential) {
           customImage.push("${env.BUILD_NUMBER}")
           customImage.push(image_tag)
       }

    echo "#------------------- Image Push to Repository Complete -------------------#"
    }
}
