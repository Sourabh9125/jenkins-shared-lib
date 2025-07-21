def call(Map config= [:]){
     def credentialsId = config.credentialsId ?: error ("please provide credentialsId")
     def imageName = config.imageName ?: error ("give the image name")
     def imageTag = config.imageTag ?: "latest"
     withCredentials([usernamePassword(
                credentialsId:"${credentialsId}",
                usernameVariable: "dockerHubUser",
                passwordVariable: "dockerHubPass")]){
            sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
          //  sh "docker image tag ${env.dockerHubUser}/${imageName} ${env.dockerHubUser}/${imageName}:${imageTag}"
            sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
        }
}
